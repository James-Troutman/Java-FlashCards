package com.sideproject;

public class FlashCard {

    private int flashCardId;
    private String term;
    private String definition;

    public FlashCard() {
    }

    public FlashCard(int flashCardId, String term, String definition) {
        this.flashCardId = flashCardId;
        this.term = term;
        this.definition = definition;
    }

    public int getFlashCardId() {
        return flashCardId;
    }

    public void setFlashCardId(int flashCardId) {
        this.flashCardId = flashCardId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String toString() {
        return String.format("%s, %s (ID: %d)", getTerm(), getDefinition(), getFlashCardId());
    }
}

