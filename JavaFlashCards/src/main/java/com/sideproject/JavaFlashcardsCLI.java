package com.sideproject;

import jdk.swing.interop.SwingInterOpUtils;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import javax.sql.DataSource;
import java.nio.channels.ScatteringByteChannel;
import java.util.List;
import java.util.Scanner;

public class JavaFlashcardsCLI {

    private final Scanner userInput = new Scanner(System.in);

    private final FlashCardDao flashCardDao;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/JavaFlashcards");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        JavaFlashcardsCLI application = new JavaFlashcardsCLI(dataSource);
        application.run();
    }

    private void run() {
        displayBanner();
        boolean running = true;
        while (running) {
            displayMenu();
            int selection = promptForInt("Please select an option:");
            System.out.println();
            if (selection == 1) {
                viewFlashCards();
            }else if (selection == 2) {
                FlashCard flashCard = getRandomFlashCard();
                displayFlashcard(flashCard);
                promptUserToHitEnterForDefinition();
                displayDefinition(flashCard);
            }
        }
    }

    public JavaFlashcardsCLI(DataSource dataSource) {
        flashCardDao = new JdbcFlashCardDao(dataSource);
    }



    private void displayBanner() {
        System.out.println();
        System.out.println("<><><><><><><><><><><><><>");
        System.out.println("<><><>JAVA-FLASHCARDS<><><>");
        System.out.println("<><><><><><><><><><><><><>");
    }

    private void displayMenu() {
        System.out.println();
        System.out.println("1. View All Java FlashCards");
        System.out.println("2. View A Random FlashCard");
        System.out.println("3. Modify An Existing FlashCard");
        System.out.println("4. Add A FlashCard");
        System.out.println("5. Exit");
    }

    private int promptForInt (String prompt) {
        return (int) promptForDouble(prompt);
    }

    private double promptForDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String response = userInput.nextLine();
            try {
                return Double.parseDouble(response);
            }catch (NumberFormatException e) {
                if (response.isBlank()) {
                    return -1;
                }else {
                    displayError("Please enter a valid number only.");
                }
            }
        }
    }

    private void displayError (String message) {
        System.out.println();
        System.out.println(message);
    }

    // viewFlashCards method will need fixed to display ID with flashcard as opposed to
    // count.  This could cause issues if more flashcards are added and ID and count become unsynced.
    private void viewFlashCards() {
        System.out.println("The following flashcards are available: ");
        try {
            int count = 1;
            for (String flashCard: flashCardDao.getAllFlashcards()) {
                System.out.println(count + ": " + flashCard);
                count ++;
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.");
        }

    }

    private FlashCard getRandomFlashCard() {
        FlashCard flashCard = null;
        try {
            flashCard = flashCardDao.getRandomFlashcard();
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.");
        }
        return flashCard;
    }

    private void displayFlashcard(FlashCard flashCard) {
        if (flashCard != null) {
            System.out.println();
            System.out.println("Term: " + flashCard.getTerm());
        }else {
            System.out.println("Flashcard is null");
        }
    }

    private void displayDefinition(FlashCard flashCard) {
        if (flashCard != null) {
            System.out.println("Definition: " + flashCard.getDefinition());
        } else {
            System.out.println("Definition is null");
        }
    }

    private void promptUserToHitEnterForDefinition() {
        System.out.println("Press enter to view definition.");
        userInput.nextLine();
    }





}
