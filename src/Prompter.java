import java.util.Scanner;

/**
 * Created by Фора on 20.07.2016.
 */
public class Prompter {
    private Game game;


    public void play() {
        while (!game.isSolved() && game.getRemainingTrice() > 0) {
            displayProgress();
            promptGuess();
        }
        if (game.isSolved()) System.out.println("Congratulations!! You guess the word");
        else System.out.println("You did not guess the word. The word was " + game.getAnswer());
    }

    public Prompter(Game game) {
        this.game = game;
    }

    private boolean promptGuess() {
        Scanner s = new Scanner(System.in);
        boolean isValidGuess = false;
        boolean check = false;
        while (!isValidGuess) {
            System.out.println("Enter a letter/word: ");
            String tr = s.nextLine();

            try {
                if (tr.length() == 1)
                    check = game.applyGuess(tr.charAt(0));
                else
                    check = game.applyGuess(tr);
                isValidGuess = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Please try again!");
                System.out.println(e.getMessage());
            }
        }
        return check;
    }

    public void displayProgress() {
        System.out.printf("You have %d tries to solve: %s\n", game.getRemainingTrice(), game.getCurrentProgress());
    }
}
