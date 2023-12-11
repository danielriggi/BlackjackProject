package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;
import com.skilldistillery.blackjack.entities.Rank;
import com.skilldistillery.blackjack.entities.Suit;

public class BlackjackApp {
	Scanner scanner = new Scanner(System.in);
	Dealer dealer = new Dealer();
	List<Player> playerList = new ArrayList<>();
	
	public static void main(String[] args) {
		BlackjackApp bj = new BlackjackApp();
		bj.run();
	}
	
	public void run() {
		addPlayers(3);
		System.out.println("Welcome to Blackjack!");
		System.out.println("The dealer is dealing...");
	
		dealer.performInitialDeal(playerList);
		if (dealer.hasBlackjack()) {
			System.out.printf("%nDealer has %n%s%n", dealer.getHand().toString());
			System.out.println("\nDealer blackjack, dealer wins!");
			return;
		}
		
		int playerIndex = 1;
		for (Player currentPlayer : playerList) {
			System.out.printf("%nPlayer %d's turn:%n", playerIndex);
			System.out.printf("%nDealer is showing  %n%s%n", dealer.getShowCard().toString());
			currentPlayer.playPlayerTurn(dealer, scanner);
			playerIndex++;
		}
		
		System.out.printf("%nDealer has %n%s%n", dealer.getHand().toString());
		int dealerTotal = dealer.playDealerTurn();
		playerIndex = 1;
		for (Player currentPlayer : playerList) {
			System.out.printf("%nPlayer %d:%n", playerIndex);
			showWinner(dealerTotal, currentPlayer.getHand().getHandValue());
			playerIndex++;
		}
		
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
	
	public void addPlayers(int numPlayers) {
		for (int i = 0; i < numPlayers; i++) {
			playerList.add(new Player());
		}
	}
	
    public void printMainMenu() {
        System.out.println("===== Blackjack Menu =====");
        System.out.println("1. Start a new game");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
    }

}
