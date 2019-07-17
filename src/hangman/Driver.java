package hangman;

/*
 * @author Munjal Shah
 */
public class Driver {
    public static void main(String[] args) {
        String wordFile = "words.txt";
        Hangman hangman = new Hangman(wordFile);
    }
}
