package assignment3;

/**
 * Represents a "Galg" puzzle.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class Galg {

    private static final int DEFAULT_ALLOWED_FAILS = 10;
    private static final WoordLezer READER = new WoordLezer("woorden.txt");
    private String failedGuesses;
    private String successfulGuesses;
    private int fails;
    private final String word;
    private final int failThreshold;

    /**
     * Constructor method.
     *
     * @param word The word that solves this.
     * @param allowedFails Maximum number of failed guesses.
     */
    public Galg (String word, int allowedFails) {
        this.word = word.toLowerCase();
        this.fails = 0;
        this.failThreshold = allowedFails;
        this.failedGuesses = "";
        this.successfulGuesses = "";
    }

    /**
     * Constructor method helper that takes only a word and add the default
     * allowedFails count.
     *
     * @param word The word that solves this.
     */
    public Galg (String word) {
        this(word, DEFAULT_ALLOWED_FAILS);
    }

    /**
     * Constructor method helper that uses a random word from WoordLezer.
     *
     * @param allowedFails Maximum number of failed guesses.
     */
    public Galg (int allowedFails) {
        this(READER.geefWoord(), allowedFails);
    }

    /**
     * Constructor method helper that adds the default allowedFails count.
     *
     */
    public Galg () {
        this(DEFAULT_ALLOWED_FAILS);
    }

    /**
     * Check whether the player is still alive.
     *
     * @return Whether the player still has guesses left.
     */
    public boolean isAlive () {
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
     * Getter method for this.word.
     *
     * @return this.word.
     */
    public String getWord () {
        return this.word;
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
        return String.join("\n",
                String.format("Fails: %d/%d", this.fails, this.failThreshold),
                String.format("Failed guesses: %s", this.failedGuesses),
                String.format("Successful guesses: %s", this.successfulGuesses),
                String.format("Representation: %s\n", this.getRepresentation())
        );

    }

    /**
     * Construct a string from the word replacing not yet guessed characters
     * with ".".
     *
     * @return A printable representation of the word showing only guessed
     * characters.
     */
    private String getRepresentation() {
        StringBuilder sb = new StringBuilder();
        for (char c : this.word.toCharArray()) {
            if (this.successfulGuesses.contains(String.valueOf(c))) {
                sb.append(c);
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}
