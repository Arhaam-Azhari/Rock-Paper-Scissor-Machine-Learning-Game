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
/**
 * Represents the three possible moves in Rock-Paper-Scissors.
 */
public enum Move {
    ROCK,
    PAPER,
    SCISSORS;

    /**
     * Converts the move to a cleaner display format.
     *
     * @return the move name in user-friendly form
     */
    @Override
    public String toString() {
        switch (this) {
            case ROCK:
                return "Rock";
            case PAPER:
                return "Paper";
            case SCISSORS:
                return "Scissors";
            default:
                return "";
        }
    }
}