package hangman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * @author Munjal Shah
 */
public class Hangman {

    FileProcessor fileProcessor = new FileProcessor();
    List<String> wordList = new LinkedList<>();
    List<String> list = new ArrayList<>();
    Random random = new Random();

    String wordFile;

    public Hangman(String wordFile) {
        this.wordFile = wordFile;
    }

    public void startGame() {

        wordList = fileProcessor.readLine(wordFile);
        int index = random.nextInt(wordList.size() + 1);
        String word = wordList.get(index);

        System.out.println("Ready to play hangman?");
        System.out.println("Here you go, Best Luck!");
        System.out.print("\n");

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
                list.add(word.charAt(i) + " ");
            } else {
                list.add("_ ");
            }
        }
        System.out.println(list);

        int count = 6;

        while (count > 0 && list.contains("_ ")) {

            Scanner in = new Scanner(System.in);
            System.out.print("Guess a letter: ");
            String guess = in.nextLine();

            if (word.contains(guess)) {
                System.out.println("Right match");
                System.out.print("\n");
                list.set(word.indexOf(guess), guess);
            } else {
                System.out.println("Wrong guess!");
                count--;

                if (count > 0) {
                    System.out.print("\n");
                    System.out.println("You have " + count + " chance left");
                } else {
                    System.out.print("\n");
                    System.out.println("Sorry, You Loose");
                    System.out.println("The correct word was: " + word);
                    break;
                }
            }

            if (!list.contains("_ ")) {
                System.out.println("Great, You won!");
                System.out.println("The word is: " + word);
                break;
            }
            System.out.println(list);
        }
    }
}
