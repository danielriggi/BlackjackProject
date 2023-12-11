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
		for (Card card: cards) {
			stringBuilder.append(card).append("\n");
		}
		return stringBuilder.toString();
	}

}

