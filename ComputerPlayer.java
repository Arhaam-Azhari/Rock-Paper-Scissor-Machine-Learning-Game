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
 * Represents the computer player in the game.
 * Uses a choice algorithm to decide moves.
 */
public class ComputerPlayer extends Player {
    private ChoiceAlgorithm chooser;

    public ComputerPlayer(String name, ChoiceAlgorithm chooser) {
        super(name);
        this.chooser = chooser;
    }

    @Override
    public Move chooseMove() {
        return chooser.makeChoice();
    }

    public void recordRound(Move humanMove, Move computerMove) {
        chooser.recordRound(humanMove, computerMove);
    }

    public void saveLearningData() {
        if (chooser instanceof MLChoiceAlgorithm) {
            ((MLChoiceAlgorithm) chooser).saveData();
        }
    }
}