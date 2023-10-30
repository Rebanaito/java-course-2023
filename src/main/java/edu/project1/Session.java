package edu.project1;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

@SuppressWarnings("RegexpSinglelineJava")
public class Session {
    public Session() {
        Random rand = new Random();
        int index = rand.nextInt(DICTIONARY.length);
        this.answer = new Word(DICTIONARY[index]);
        this.lettersLeft = DICTIONARY[index].length();
    }

    public Session(String[] words) {
        Random rand = new Random();
        int index = rand.nextInt(words.length);
        this.answer = new Word(words[index]);
        this.lettersLeft = words[index].length();
    }

    private final static Logger LOGGER = Logger.getLogger("LOGGER");
    private final static int MAX_MISTAKES = 5;
    private final static int LONGEST_WORD = 45;
    private final static String[] DICTIONARY = {"prandial", "jocundity", "superfluous", "exuberant"};
    private final Word answer;
    private int lettersLeft;
    private int mistakesMade = 0;

    int play() {
        if (gameOver()) {
            result();
            return 1;
        }
        Scanner scanner = new Scanner(System.in);
        String in;
        if (answer.length() == 0 || answer.length() > LONGEST_WORD) {
            LOGGER.info("Invalid word");
            return 1;
        }
        while (!gameOver()) {
            System.out.println("Guess a letter:");
            try {
                in = scanner.nextLine();
            } catch (NoSuchElementException exc) {
                System.out.println("Exiting the game");
                return 0;
            }
            tryInput(in);
        }
        result();
        return 0;
    }

    boolean gameOver() {
        return haveLost() || haveWon();
    }

    boolean haveWon() {
        return lettersLeft == 0;
    }

    boolean haveLost() {
        return mistakesMade == MAX_MISTAKES;
    }

    private void result() {
        if (haveWon()) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost!");
        }
    }

    void tryInput(String in) {
        if (in.length() != 1) {
            return;
        }
        int opened = answer.tryLetter(in.charAt(0));
        if (opened == 0) {
            mistakesMade++;
            System.out.printf("Miss %d out of %d!\n", mistakesMade, MAX_MISTAKES);
        } else {
            System.out.println("Hit!\n");
            lettersLeft -= opened;
        }
        answer.printGuessed();
    }

//    public static void main(String[] args) {
//        var sesh = new Session();
//        sesh.play();
//    }
}
