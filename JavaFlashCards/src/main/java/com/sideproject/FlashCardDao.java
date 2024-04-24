package com.sideproject;

import java.util.List;

public interface FlashCardDao {

    FlashCard getFlashCardById(int flashCardId);

    List<FlashCard> getAllFlashcards();

    FlashCard getRandomFlashcard();

    List<FlashCard> getFlashCardByPartialNameSearch(String term);

    FlashCard create(FlashCard flashCard);


    FlashCard updateFlashcard(FlashCard flashCard);
    int deleteFlashcardById(int flashcardId);



}
