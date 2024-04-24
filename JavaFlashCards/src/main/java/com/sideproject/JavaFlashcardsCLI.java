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
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Java_FlashCards");
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
               promptUserAfterListOfTermsDisplayed();
            }else if (selection == 2) {
                FlashCard flashCard = getRandomFlashCard();
                displayFlashcard(flashCard);
                promptUserToHitEnterForDefinition();
                displayDefinition(flashCard);
            }else if (selection == 3) {
                viewFlashcardBySearch();
                promptUserAfterListOfTermsDisplayed();
            }else if (selection == 4) {
                viewFlashCards();
                promptUserToModifyThisFlashcard();
            }else if (selection == 5) {
                addFlashcard();
            }else if (selection == 6) {
                viewFlashCards();
                promptUserToDeleteThisFlashcard();
            }else if (selection == 7) {
                    running = false;
                System.out.println("Exiting the program...");
            }else {
                System.out.println("Please enter a valid selection");
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
        System.out.println("3. Search For A Term");
        System.out.println("4. Modify An Existing FlashCard");
        System.out.println("5. Add A FlashCard");
        System.out.println("6. Delete A FlashCard");
        System.out.println("7. Exit The Program");
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

    private void viewFlashCards() {
        System.out.println("The following flashcards are available: ");

        List<FlashCard> flashcards = flashCardDao.getAllFlashcards();
        try {

            for (FlashCard flashCard: flashCardDao.getAllFlashcards()) {
                System.out.println(flashCard.getFlashCardId() + ": " + flashCard.getTerm());
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.");
        }
    }

    private void viewFlashcardBySearch() {
        System.out.println("Please enter the name or partial name of the term you're looking for: ");
        String input = userInput.nextLine();
        System.out.println();
        System.out.println("The following Flashcards appear in your search:");

        try {
            List<FlashCard> flashCards = flashCardDao.getFlashCardByPartialNameSearch(input);
                if (flashCards.isEmpty()) {
                    System.out.println("No Flashcards available");
                    displayMenu();
                }
                for (FlashCard flashCard : flashCards) {
                    System.out.println(flashCard.getFlashCardId() + ": " + flashCard.getTerm());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database.");
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
            System.out.println("Term: " + flashCard.getTerm() + " --- Definition: " + flashCard.getDefinition());
            System.out.println();
            promptUserToContinue();
        } else {
            System.out.println("Definition is null");
        }
    }

    private void promptUserToHitEnterForDefinition() {
        System.out.println();
        System.out.println("Press enter to view definition.");
        userInput.nextLine();
    }

    private void promptUserAfterListOfTermsDisplayed() {
        System.out.println();
        int id = promptForInt("Please select the number of the term you'd like to view: ");
        FlashCard flashCard = flashCardDao.getFlashCardById(id);
        displayFlashcard(flashCard);
        promptUserToHitEnterForDefinition();
        displayDefinition(flashCard);
    }

    private void promptUserToModifyThisFlashcard() {
        System.out.println();
        int id = promptForInt("Please select the number of the term you'd like to modify: ");
        FlashCard flashCard = flashCardDao.getFlashCardById(id);
        displayFlashcard(flashCard);
        System.out.println();
        System.out.println("Modify this FlashCard? (y) or (n)");
        System.out.println();
        String userInputResponse = userInput.nextLine();
        if (userInputResponse.equalsIgnoreCase("y")) {
            updateFlashcard(flashCard);
        }else if (userInputResponse.equalsIgnoreCase("n")) {
            displayMenu();
        } else {
            System.out.println("Please enter (y) or (n)");
        }
    }

    private void promptUserToDeleteThisFlashcard() {
        System.out.println();
        int id = promptForInt("Please select the number of the term you'd like to delete");
        FlashCard flashCard = flashCardDao.getFlashCardById(id);
        displayFlashcard(flashCard);
        System.out.println();
        System.out.println("Are you sure you want to delete this flashcard? (y) or (n)");
        System.out.println();
        String userInputResponse = userInput.nextLine();
        if (userInputResponse.equalsIgnoreCase("y")) {
            deleteFlashcard(flashCard);
        }else if (userInputResponse.equalsIgnoreCase("n")) {
            displayMenu();
        }else {
            System.out.println("Please enter (y) or (n)");
        }
    }

    private void deleteFlashcard(FlashCard flashcardToDelete) {
        try {
            int deletedRows = flashCardDao.deleteFlashcardById(flashcardToDelete.getFlashCardId());
            if (deletedRows == 0) {
                displayError("No records deleted");
            }else {
                System.out.println("Deleted" + flashcardToDelete.getTerm());
            }
        } catch (DaoException e) {
            displayError("Error occurred: " + e.getMessage());
        }
    }

    private void updateFlashcard(FlashCard flashCardToUpdate) {
        String newCard = promptForString("New Flashcard Name (enter to leave unchanged): ");
        if (!newCard.isBlank()) {
            flashCardToUpdate.setTerm(newCard);
        }
        String newDefinition = promptForString("New Definition (enter to leave unchanged): ");
        if (!newDefinition.isBlank()) {
            flashCardToUpdate.setDefinition(newDefinition);
        }
        try {
            FlashCard updatedFlashcard = flashCardDao.updateFlashcard(flashCardToUpdate);
            System.out.println("---Updated---: " + updatedFlashcard.getTerm() + " -- " + updatedFlashcard.getDefinition());
            System.out.println();
            promptUserToContinue();
        } catch (DaoException e) {
            displayError("Error occured: " + e.getMessage());
        }
    }
        private void addFlashcard() {
            FlashCard newFlashcard = promptForNewFlashcardData();

            try {
                newFlashcard = flashCardDao.create(newFlashcard);
                System.out.println("--Added the following to the database");
                System.out.println(newFlashcard.getTerm() + ": " + newFlashcard.getDefinition());
                System.out.println();
                promptUserToContinue();
            } catch (DaoException e) {
                displayError("Error occurred: " + e.getMessage());
            }
        }

        private FlashCard promptForNewFlashcardData() {
            FlashCard flashCard = new FlashCard();

            String term = "";
            while (term.isBlank()) {
                term = promptForString("New Term: ");
            }
            flashCard.setTerm(term);

            String definition = "";
            while (definition.isBlank()) {
                definition = promptForString("Definition: ");
            }
            flashCard.setDefinition(definition);

            return flashCard;
        }

    private void promptUserToContinue() {
        System.out.println("Press enter to continue...");
        userInput.nextLine();
    }

    private String promptForString(String prompt) {
        System.out.println(prompt);
        return userInput.nextLine();

    }
}
