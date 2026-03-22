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
 *
 * Description:
 * Interface for any strategy that chooses a move for the computer player.
 */
public interface ChoiceAlgorithm {
    Move makeChoice();
    void recordRound(Move humanMove, Move computerMove);
}