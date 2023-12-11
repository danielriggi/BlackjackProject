package com.skilldistillery.blackjack.entities;

public enum Suit {
    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");
    


    private String name;

    Suit(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
      return name;
    }
}
