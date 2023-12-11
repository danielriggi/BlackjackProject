package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		
	}
	
	public int getHandValue() {
		int value = 0;
		int numAces = 0;
		for (Card card : super.cards) {
			if (card.getRank() == Rank.ACE) {
				numAces++;
			}
			value += card.getRank().getValue();
		}
		
		while (numAces > 0 && value > 21) {
			value -= 10;
			numAces--;
		}
		return value;
	}
	
	public boolean hasAce() {
		for (Card card : super.cards) {
			if (card.getRank() == Rank.ACE) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isSoftSeventeen() {
		if (getHandValue() == 17 && hasAce()) {
			return true;
		}
		return false;
	}
	
	public boolean isBlackjack() {
		boolean isBlackJack = false;
		if (super.cards.size() == 2 && getHandValue() == 21) {
			isBlackJack = true;
		}
		return isBlackJack;
	}
	
	public boolean isBust() {
		boolean isBust = (getHandValue() > 21) ? true : false;
		return isBust;
	}
	

	

}
