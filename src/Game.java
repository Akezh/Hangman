import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Фора on 20.07.2016.
 */
public class Game {
    public static final int MAX_MISSES = 7;
    private String answer;
    private String hits;
    private String misses;
    private List<String> words;


    public Game(String answer) {
        hits = "";
        misses = "";
        answer = answer.toLowerCase();
        this.answer = answer;
    }

    public Game() {
        hits = "";
        misses = "";
        words = new ArrayList<>(Arrays.asList("Palindrom", "Tiger", "Lion", "warface", "school", "university", "satisfaction", "radioactivity", "brain", "guard", "Spirit", "adventure", "belief", "business"));
        this.answer = words.get((int) (Math.random() * words.size())).toLowerCase();
    }

    public Game(String[] userArray) {
        hits = "";
        misses = "";
        words = new ArrayList<>(Arrays.asList(userArray));
        this.answer = words.get((int) (Math.random() * words.size())).toLowerCase();;
    }

    public Game(List<String> userWords) {
        hits = "";
        misses = "";
        words = userWords;
        this.answer = words.get((int) (Math.random() * words.size())).toLowerCase();
    }

    private char validGuess(char guess) {
        if (!Character.isLetter(guess)) {
            throw new IllegalArgumentException("You must enter the letter!!");
        }
        guess = Character.toLowerCase(guess);
        if ((hits.indexOf(guess) >= 0) || (misses.indexOf(guess) >= 0)) {
            throw new IllegalArgumentException("You should not repeat your guess word!!!");
        }
        return guess;
    }

    public boolean applyGuess(char letter) {
        boolean check = false;
        letter = validGuess(letter);
        if (answer.indexOf(letter) >= 0) {
            hits += letter;
            check = true;
        } else {
            misses += letter;
//            System.out.printf("You have %d tries to solve: %s\n", getRemainingTrice(), getCurrentProgress());
        }
        return check;
    }


    public boolean applyGuess(String word) {
        boolean lo = false;
        if (word.isEmpty())
            throw new IllegalArgumentException("You should write a letter!!!");
        if (word.equals(answer)) {
            lo = true;
            hits = answer;
        } else {
            misses = "-------";
        }
        return lo;
    }

    public String getCurrentProgress() {
        String progress = "";
            for (Character c : answer.toCharArray()) {
                if (hits.indexOf(c) >= 0) progress += c;
                else progress += "-";
        }
        return progress;
    }

    public String getAnswer() {
        return answer;
    }

    public int getRemainingTrice() {
        return MAX_MISSES - misses.length();
    }

    public boolean isSolved() {
        return getCurrentProgress().indexOf("-") == -1;
    }
}