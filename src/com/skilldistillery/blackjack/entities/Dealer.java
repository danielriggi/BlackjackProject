package com.skilldistillery.blackjack.entities;

import java.util.List;

public class Dealer {
	private Hand hand;
	private Deck deck;

	public Dealer() {
		this.hand = new BlackjackHand();
		this.deck = new Deck();
	}

	public void shuffleDeck(Deck deck) {
		deck.shuffle();
	}

	public void performInitialDeal(List<Player> players) {
		// Logic for the initial deal at the start of the game
		for (int i = 0; i < 2; i++) {
			for (Player player : players) {
				player.getHand().addCard(deck.dealCard());
			}
			hand.addCard(deck.dealCard());
		}
	}
	
	public void performInitialDeal(Player player, Card playerCard1, 
			Card playerCard2, Card dealerCard1, Card dealerCard2) {
		// Logic for the initial deal at the start of the game
		
		player.getHand().addCard(playerCard1);
		player.getHand().addCard(playerCard2);
		hand.addCard(dealerCard1);
		hand.addCard(dealerCard2);
		deck.removeCard(playerCard1);
		deck.removeCard(playerCard2);
		deck.removeCard(dealerCard1);
		deck.removeCard(dealerCard2);

	}

	public Card dealCard() {
		return deck.dealCard();
	}

	public int playDealerTurn() {
		System.out.println("Dealer is playing their turn:");
		while (hand.getHandValue() < 17 || ((BlackjackHand) hand).isSoftSeventeen()) {
			Card card = deck.dealCard();
			hand.addCard(card);
			System.out.printf("%nDealer must hit, receives: %n%s%n", card.toString());
			System.out.printf("%nDealer total: %d%n", hand.getHandValue());
		}
		System.out.printf("%nDealer turn over.%nDealer total: %d%n", hand.getHandValue());
		return hand.getHandValue();
	}

	
	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

}
