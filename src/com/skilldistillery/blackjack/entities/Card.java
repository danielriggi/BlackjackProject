package com.skilldistillery.blackjack.entities;

import java.util.Objects;

public class Card {
	private Suit suit;

	private Rank rank;

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public String toString() {
		String rankString;
		switch (rank) {
		case TWO:
			rankString = "Two";
			break;
		case THREE:
			rankString = "Three";
			break;
		case FOUR:
			rankString = "Four";
			break;
		case FIVE:
			rankString = "Five";
			break;
		case SIX:
			rankString = "Six";
			break;
		case SEVEN:
			rankString = "Seven";
			break;
		case EIGHT:
			rankString = "Eight";
			break;
		case NINE:
			rankString = "Nine";
			break;
		case TEN:
			rankString = "Ten";
			break;
		case JACK:
			rankString = "Jack";
			break;
		case QUEEN:
			rankString = "Queen";
			break;
		case KING:
			rankString = "King";
			break;
		case ACE:
			rankString = "Ace";
			break;
		default:
			rankString = "Unknown";
		}
		return rankString + " of " + suit.toString();

	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}

}
