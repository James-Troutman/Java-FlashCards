package com.sideproject;

import java.util.List;

public interface FlashCardDao {

    FlashCard getFlashCardById(int flashCardId);

    List<String> getAllFlashcards();

    FlashCard getRandomFlashcard();

    List<FlashCard> getFlashCardByPartialNameSearch(String term);

    FlashCard create(FlashCard flashCard);


    FlashCard updateFlashcard(FlashCard flashCard);



}
