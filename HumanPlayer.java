/**
 * Assignment 3 - Rock Paper Scissors
 * Course: CS151
 *
 * Team 20k6
 * Members:
 * Arhaam Azhari
 * Khushi Bakshi
 * Toby Chan
 * Marco Shifflette
 */
import java.util.Scanner;

/**
 * Represents the human player.
 * Obtains choices from keyboard input.
 */
public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    /**
     * Prompts the user until a valid move is entered.
     *
     * @return the move chosen by the human player
     */
    @Override
    public Move chooseMove() {
        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("1")) {
                return Move.ROCK;
            } else if (input.equals("2")) {
                return Move.PAPER;
            } else if (input.equals("3")) {
                return Move.SCISSORS;
            } else {
                System.out.print("Invalid input. Choose again (1=rock, 2=paper, 3=scissors): ");
            }
        }
    }
}