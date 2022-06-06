package com.dangi.TextAdventureGame;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// System Objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();

		// Game variable
		String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assassin" };
		int maxEnemeyHealth = 75;
		int enemyAttackDamage = 25;

		// Player variable
		int health = 100;
		int attackDamage = 50; // enemies can attack that much damage to the player
		int numHealthPotions = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50; // player can do that much damage to the enemies health

		boolean running = true;

		System.out.println("Welcome to the Cave!");

		GAME: // (Lable) name of this while loop and could be using it the below part.
		while (running) {
			System.out.println("------------------------------------------------------------");

			int enemyHealth = rand.nextInt(maxEnemeyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " has appeared! #\n");

			while (enemyHealth > 0) {
				System.out.println("\tYour Health: " + health);
				System.out.println("\t" + enemy + "'s Health: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink Health Potion");
				System.out.println("\t3. Run!");

				String input = in.nextLine();
				if (input.equals("1")) {
					int damageDone = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);

					enemyHealth -= damageDone;
					health -= damageTaken;

					System.out.println("\t> You strike the " + enemy + " for " + damageDone + " damage.");
					System.out.println("\t> You recieve " + damageTaken + " in retaliation!");

					if (health < 1) {
						System.out.println("\\ You have taken too much damage, can't contiune!");
					}

				} else if (input.equals("2")) {
					if (numHealthPotions > 0) {
						
						if(health<101) {
							health += healthPotionHealAmount;
							numHealthPotions--;
						}
					
						System.out.println("\t> You drink a Health Potion, healing yourself for "
								+ healthPotionHealAmount + "." + "\n\t> You now have " + health + "HP."
								+ "\n\t> You have " + numHealthPotions + " health potions left.\n");

					} else {
						System.out.println(
								"\t> You have no. Heath Potions left! " + "Defeat enemies for a chance to get one!");
					}

				} else if (input.equals("3")) {

					System.out.println("\t You run away form the " + enemy + "!");

					continue GAME; // here we use the game lable to go to outer while loop(Game) not this while
									// loop(inside the Game while loop)

				} else {
					System.out.println("\t Invalid Command!");
				}
			}

			// here we check why we break out the while loop if enemy is defeated or player
			// is defeated

			if (health < 1) {
				System.out.println("You have no. health remaining , taken out of the cave on Stretcher");
				break;
			}

			System.out.println("------------------------------------------------------------");
			System.out.println(" # " + enemy + " was defeated! #");
			System.out.println(" # You have " + health + " HP left. #");
			if(rand.nextInt(100)<healthPotionDropChance) {
				numHealthPotions++;
				System.out.println(" # The "+enemy+ " dropeed a health potion #");
				System.out.println(" # You now have "+ numHealthPotions + " health potion(s). #");
			}
			
			System.out.println("------------------------------------------------------------");
			System.out.println("What would you like to do now!");
			System.out.println("1. continue fighting");
			System.out.println("2. Exit Cave");
			
			String input= in.nextLine();
			while(! input.equals("1")&& !input.equals("2")) {
				System.out.println("Invalid command!");
				input=in.nextLine();
			}
			if(input.equals("1")) {
				System.out.println("You continue on your advanture!");
			}
			else if(input.equals("2")) {
				System.out.println("You exit the Cave, successful from the advantures!");
				break;
			}
		}
		System.out.println("#######################");
		System.out.println("# THANKS FOR PLAYING! #");
		System.out.println("#######################");
	}

}
