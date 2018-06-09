import java.util.ArrayList;
import java.util.List;

public class Hangman {
    public static void main(String[] args) {
        String[] mas = {"joker", "panda", "marcelo"};
        List<String> myList = new ArrayList<>();
        myList.add("panda");
        myList.add("micro");
        myList.add("lion");

        Game hang = new Game(myList);
        Prompter man = new Prompter(hang);
        man.play();
    }
}
