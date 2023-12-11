package com.skilldistillery.blackjack.entities;

import java.util.Scanner;

public class Player {
	private Hand hand;

	public Player() {
		this.hand = new BlackjackHand();
	}

	public int playPlayerTurn(Dealer dealer, Scanner scanner) {
		System.out.printf("%nYour hand: %n%s%n", getHand().toString());
		int choice = 1;
		if (((BlackjackHand) hand).isBlackjack()) {
			System.out.println("Player Blackjack!!!");
			
		}
		while(hand.getHandValue() <= 21 && !((BlackjackHand) hand).isBlackjack()) {
			playerTurnMenu();
			choice = scanner.nextInt();
			if (choice != 2 && choice != 1) {
				System.out.println("Invalid choice");
			}
			else if (choice == 2) {
				System.out.println("\nYou've chosen to stand");
				break;
			} else {
				System.out.println("\nYou've chosen to hit, you recieved:");
				Card newCard = dealer.dealCard();
				getHand().addCard(newCard);
				System.out.println(newCard.toString());
			}
			System.out.printf("%nYou now have: %n%s%n", hand.toString());
		}	
		int handValue = getHand().getHandValue();
		if (handValue > 21) {
			System.out.println("Busted!!");
		} else {
			System.out.printf("Your total: %d%n", handValue);
		}
		return handValue;
	}
	
    private void playerTurnMenu() {
		System.out.println("Hit or stand: ");
        System.out.println("1. Hit");
        System.out.println("2. Stand");
    }
		
	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
}
