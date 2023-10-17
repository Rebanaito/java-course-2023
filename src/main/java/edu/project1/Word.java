package edu.project1;

@SuppressWarnings("RegexpSinglelineJava")
public class Word {
    public Word(String word) {
        this.word = word;
        this.chars = word.toCharArray();
        this.guessed = new boolean[this.chars.length];
    }

    private final String word;
    private final char[] chars;
    private final boolean[] guessed;

    public String getWord() {
        return this.word;
    }

    public int tryLetter(char c) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c && !guessed[i]) {
                count++;
                guessed[i] = true;
            }
        }
        return count;
    }

    public int length() {
        return this.chars.length;
    }

    public void printGuessed() {
        System.out.print("The word: ");
        for (int i = 0; i < chars.length; i++) {
            if (guessed[i]) {
                System.out.print(chars[i]);
            } else {
                System.out.print("*");
            }
        }
        System.out.println();
    }
}
