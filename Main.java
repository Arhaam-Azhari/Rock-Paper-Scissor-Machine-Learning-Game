/**
 * Assignment 4 - Rock Paper Scissors
 * Course: CS151
 *
 * Team 20k6
 * Members:
 * Arhaam Azhari
 * Khushi Bakshi
 * Toby Chan
 * Marco Shifflette
 */
/**
 * Entry point for the Rock-Paper-Scissors program.
 */
public class Main {
    public static void main(String[] args) {
        String mode = "-r";

        if (args.length > 0) {
            mode = args[0];
        }

        RPSGame game = new RPSGame(mode);
        game.playGame();
    }
}