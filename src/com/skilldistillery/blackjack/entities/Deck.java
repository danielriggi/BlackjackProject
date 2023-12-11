package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Deck {
	private List<Card> cards;
	Random random = new Random();

	
	public Deck(List<Card> deck) {
		super();
		this.cards = deck;
	}
	
    public Deck() {
        // Initialize the deck with all possible combinations of Suit and Rank
        cards = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }
	
	public int cardsLeftInDeck() {
		return cards.size();
	}
	
	public Card dealCard() {
		int randomIndex = random.nextInt(cards.size());
		return cards.remove(randomIndex);
	}
	
	public void removeCard(Card card) {
		cards.remove(card);
	}
	public void shuffle() {
		Collections.shuffle(cards);
	}

	public List<Card> getDeck() {
		return cards;
	}

	public void setDeck(List<Card> deck) {
		this.cards = deck;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Card card: cards) {
			stringBuilder.append(card).append("\n");
		}
		return stringBuilder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cards);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck other = (Deck) obj;
		return Objects.equals(cards, other.cards);
	}
	
	
}
