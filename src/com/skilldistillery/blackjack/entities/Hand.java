package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards;

	public Hand() {
		cards = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		cards.clear();
	}
	
	public abstract int getHandValue();
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{");
	    int size = cards.size();
	    for (int i = 0; i < size; i++) {
	        stringBuilder.append(cards.get(i));
	        if (i < size - 1) {
	            stringBuilder.append(", ");
	        }
	    }
	    
	    stringBuilder.append("}"); // Add closing bracket
	   
		return stringBuilder.toString();
	}

	public List<Card> getCards() {
		return cards;
	}
}

