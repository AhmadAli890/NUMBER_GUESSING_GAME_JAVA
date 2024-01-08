import java.util.Random;
import java.util.Scanner;

class NumberGuess {
    private int number;
    private int inputNumber;
    private int guesses = 0;
    private int MAX_GUESSES = 10;
    private int Warning = 1;
    private boolean warnflag = true;
    private int i = 0;
    private int index = 0;
    private int[] track = new int[11];
    public NumberGuess() {
        Random random = new Random();
        this.number = random.nextInt(1001); // Generates a random number between 1 and 1000
    }

    public boolean guessss() {//to check guesses
        System.out.println("YOU HAVE " + (MAX_GUESSES - guesses) + " GUESSES LEFT");
        if (guesses >= MAX_GUESSES) {
            System.out.println("YOU RAN OUT OF ATTEMPTS: THE NUMBER WAS " + number);
            return true;
        } else {
            return false;
        }
    }

    public void inputNumber() {//take input and handle in valid inputs
        try {
            Scanner scanner = new Scanner(System.in);
            inputNumber = scanner.nextInt();
            track[index] = inputNumber;
            i = 0;
            index++;
        } catch (Exception e) {
            if (warnflag) {
                System.out.println("INVALID INPUT: TRY AGAIN");
                Warning--;
                warnflag = false;
                i = 1;
            } else {
                i = 1;
                guesses++;
                warnflag = false;
            }
        }
    }

    public boolean isCorrect() {
        if (inputNumber < 0 || inputNumber > 1000) {
            if (warnflag) {
                System.out.println("INVALID INPUT: TRY AGAIN");
                Warning--;
                warnflag = false;
            }
            else {
                guesses++;
            }

        } else {
            if (i == 0) {
                guesses++;
                if (inputNumber == number) {
                    System.out.format("HURRAY! YOU GUESSED IT RIGHT %d\n TOTAL ATTEMPTS USED %d\n", number, guesses);
                    return true;
                } else if (inputNumber < number) {
                    System.out.println("YOUR GUESS IS SMALL: ");
                    System.out.println("TRY BIGGER ONE");
                } else {
                    System.out.println("YOUR GUESS IS LARGE");
                    System.out.println("TRY SMALLER ONE");
                }
            }
        }
        return false;
    }

    public void displayGuesses() {
        System.out.print("PREVIOUSLY GUESSED NUMBER: ");
        for (int i = 0; i < track.length; i++) {
            if (track[i] != 0) {
                System.out.print(track[i] + " ");
            }
        }
        System.out.println();
    }
}

public class NumberGuessingGame {
    public static void main(String[] args) {
        NumberGuess ng = new NumberGuess();
        boolean isGameOver = false;

        System.out.println("WELCOME TO NUMBER GUESSING GAME!");
        System.out.println("THINK OF A NUMBER BETWEEN 1-1000!");
        System.out.println("YOU HAVE 1 WARNING");
        System.out.println("YOU HAVE 10 TRIES:");

        while (!isGameOver) {
            ng.inputNumber();
            isGameOver = ng.isCorrect();
            isGameOver = ng.guessss();
            ng.displayGuesses();
        }
    }
}
