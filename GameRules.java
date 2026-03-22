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
 * Encapsulates the rules of Rock-Paper-Scissors.
 */
public class GameRules {

    /**
     * Compares two moves and returns the round result.
     *
     * @param humanMove the move chosen by the human
     * @param computerMove the move chosen by the computer
     * @return the round result
     */
    public RoundResult determineResult(Move humanMove, Move computerMove) {
        if (humanMove == computerMove) {
            return RoundResult.DRAW;
        }

        if ((humanMove == Move.ROCK && computerMove == Move.SCISSORS)
                || (humanMove == Move.PAPER && computerMove == Move.ROCK)
                || (humanMove == Move.SCISSORS && computerMove == Move.PAPER)) {
            return RoundResult.HUMAN_WIN;
        }

        return RoundResult.COMPUTER_WIN;
    }
}