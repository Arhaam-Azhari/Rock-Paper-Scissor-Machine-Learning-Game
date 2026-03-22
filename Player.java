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
 * Abstract superclass for all players in the game.
 */
public abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    /**
     * Gets the player's name.
     *
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Each player must provide a way to choose a move.
     *
     * @return the chosen move
     */
    public abstract Move chooseMove();
}