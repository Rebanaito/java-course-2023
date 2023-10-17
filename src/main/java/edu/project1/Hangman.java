package edu.project1;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
	private final static String[] dictionary = {"atom", "biscuit", "strength", "reconnaissance"};
	private final static int MISTAKE_LIMIT = 5;
	public static void main(String[] args) {
		var word = new Word();
		word.chooseWord();
		Scanner scanner = new Scanner(System.in);
		int mistakes = 0;
		while (mistakes < MISTAKE_LIMIT) {
			System.out.println("Guess a letter:");
			String in = scanner.nextLine();
			if (in.length() != 1) {
				continue;
			}
			if (word.checkLetter(in.charAt(0))) {
				System.out.println("Hit!");
			} else {
				mistakes++;
				System.out.printf("Missed, mistake %d out of %d\n", mistakes, MISTAKE_LIMIT);
			}
			word.printGuessed();
			if (word.checkStatus()) {
				System.out.println("You won!");
				return;
			}
		}
		System.out.println("You lost!");
	}

	private static class Word {
		private Word() {
		}

		String string;
		char[] word;
		boolean[] guessed;
		int left;

		private void chooseWord() {
			Random rand = new Random();
			int index = rand.nextInt(dictionary.length);
			this.string = dictionary[index];
			this.word = this.string.toCharArray();
			this.guessed = new boolean[this.word.length];
			this.left = this.guessed.length;
		}

		private boolean checkLetter(char letter) {
			boolean match = false;
			for (int i = 0; i < this.guessed.length; i++) {
				if (this.word[i] == letter) {
					match = true;
					this.guessed[i] = true;
					left--;
				}
			}
			return match;
		}

		private void printGuessed() {
			System.out.print("The word: ");
			for (int i = 0; i < this.word.length; i++) {
				if (this.guessed[i]) {
					System.out.print(this.word[i]);
				} else {
					System.out.print('*');
				}
			}
			System.out.println("\n");
		}

		private boolean checkStatus() {
			return this.left == 0;
		}

		private String getString() {
			return this.string;
		}
	}
}