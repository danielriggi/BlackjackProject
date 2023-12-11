package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Hand;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {
	Scanner scanner = new Scanner(System.in);
	Dealer dealer = new Dealer();
	Player player1 = new Player();
	Player player2 = new Player();
	Player player3 = new Player();
	List<Player> playerList = new ArrayList<>();
	
	public static void main(String[] args) {
		BlackjackApp bj = new BlackjackApp();
		bj.run();
	}
	
	public void run() {

		
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		System.out.println("Welcome to Blackjack!");
		System.out.println("The dealer is dealing...");
//		Card card1 = new Card(Suit.CLUBS, Rank.ACE);
//		Card card2 = new Card(Suit.DIAMONDS, Rank.TWO);
//		Card card3 = new Card(Suit.SPADES, Rank.ACE);
//		Card card4 = new Card(Suit.DIAMONDS, Rank.KING);
//		dealer.performInitialDeal(player, card1, card2, card3, card4);
		
		dealer.performInitialDeal(playerList);
		Hand dealerHand = dealer.getHand();
		if (isDealerBlackjack()) {
			System.out.println("\nDealer blackjack, dealer wins!");
			return;
		}
		int playerIndex = 1;
		for (Player currentPlayer : playerList) {
			System.out.printf("%nPlayer %d's turn:%n", playerIndex);
			currentPlayer.playerTurn(dealer, scanner );
			playerIndex++;
		}
		
		System.out.printf("%nDealer has %n%s%n", dealer.getHand().toString());
		int dealerTotal = dealer.playDealerTurn();
		playerIndex = 0;
		for (Player currentPlayer : playerList) {
			System.out.printf("%nPlayer %d:%n", playerIndex);
			showWinner(dealerTotal, currentPlayer.getHand().getHandValue());
			playerIndex++;
		}
		
	}
	
	
	public void playHand() {
		
	}
	
	public void showWinner(int dealerTotal, int playerTotal) {
		if (playerTotal > 21) { 
			System.out.println("Player loses!");
		} else if (dealerTotal > 21) {
			System.out.println("Player wins!");
		} else if (playerTotal > dealerTotal) {
			System.out.println("Player wins!");
		} else if (dealerTotal > playerTotal) {
			System.out.println("Dealer wins!");
		} else {
			System.out.println("Push!");
		}
		
	}
	
	public boolean isDealerBlackjack() {
	    return ((BlackjackHand) dealer.getHand()).isBlackjack();
	}

    public void printMainMenu() {
        System.out.println("===== Blackjack Menu =====");
        System.out.println("1. Start a new game");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
    }

}
