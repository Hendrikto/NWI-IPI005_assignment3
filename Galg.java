package assignment3;

/**
 * Represents a "Galg" puzzle.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class Galg {
    private String failedGuesses;
    private String successfulGuesses;
    private int fails;
    private final String word;
    private final int failThreshold;

    /**
     * Constructor method.
     *
     * @param word The word that solves this.
     * @param allowedFails The number of times the user is allowed to guess
     * wrong.
     */
    public Galg (String word, int allowedFails) {
        this.word = word;
        this.fails = 0;
        this.failThreshold = allowedFails;
        this.failedGuesses = "";
        this.successfulGuesses = "";
    }

    /**
     * Check whether the player is still alive.
     *
     * @return Whether the player still has guesses left.
     */
    public boolean alive () {
        return this.fails < this.failThreshold;
    }

    /**
     * Check whether the galg is solved.
     *
     * @return Whether there are still letters left to guess for this galg.
     */
    public boolean isSolved () {
        return !this.getRepresentation().contains(".");
    }

    /**
     * Make a guess.
     *
     * @param s The character to guess.
     * @return Whether the try was successful.
     */
    public boolean guess (String s) {
        if (this.failedGuesses.contains(s)
                || this.successfulGuesses.contains(s)) {
            this.fails++;
            return false;
        }
        if (this.word.contains(s)) {
            this.successfulGuesses = this.successfulGuesses += s;
            return true;
        } else {
            this.failedGuesses = this.failedGuesses += s;
            this.fails++;
            return false;
        }
    }

    /**
     * Get printable representation of the current state.
     *
     * @return Printable representation of the current state.
     */
    @Override
    public String toString () {
        return new StringBuilder()
                .append(String.format("Fails: %d/%d\n", this.fails, this.failThreshold))
                .append(String.format("Failed guesses: %s\n", this.failedGuesses))
                .append(String.format("Successful guesses: %s\n", this.successfulGuesses))
                .append(String.format("Representation: %s\n", this.getRepresentation()))
                .toString();
    }

    /**
     * Construct a string from the word replacing not yet guessed characters
     * with ".".
     *
     * @return A printable representation of the word showing only guessed
     * characters.
     */
    private String getRepresentation () {
        StringBuilder sb = new StringBuilder();
        for (char c: this.word.toCharArray()) {
            if (this.successfulGuesses.contains(String.valueOf(c))) {
                sb.append(c);
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}
