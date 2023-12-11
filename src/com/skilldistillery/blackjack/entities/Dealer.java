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
			int idx = 1;
			for (Player player : players) {
				Card card = deck.dealCard();
				System.out.printf("Player %d recieves %s%n", idx, card.toString());
				player.getHand().addCard(card);
				idx++;
			}
			Card dealerCard = deck.dealCard();
			hand.addCard(dealerCard);
			if (i == 1) {
				System.out.printf("Dealer recieves %s%n", dealerCard.toString());
				hand.addCard(deck.dealCard());
			} else {
				System.out.println("Dealer recieves face down card");
			}
		}
	}
	
	public void performTestInitialDeal(Player player, Card playerCard1, 
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
		System.out.println("\nDealer is playing their turn...");
		while (hand.getHandValue() < 17 || ((BlackjackHand) hand).isSoftSeventeen()) {
			Card card = deck.dealCard();
			hand.addCard(card);
			System.out.printf("%nDealer must hit, receives: %n%s%n", card.toString());
			System.out.printf("%nDealer now has: %n%s", hand.toString());
			System.out.printf("%nDealer total: %d%n", hand.getHandValue());
		}
		if (hand.getHandValue() > 21) {
			System.out.println("Dealer busts!");
		}
		else {
			System.out.println("Dealer stands.");
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

	public boolean hasBlackjack() {
	    return ((BlackjackHand) hand).isBlackjack();
	}

	public Card getShowCard() {
		return hand.getCards().get(1);
	}
	

}
