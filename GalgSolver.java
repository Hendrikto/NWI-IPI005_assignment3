package assignment3;

import java.util.Scanner;

/**
 * Contains user interaction for solving galgs.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class GalgSolver {

    private static final Scanner SCANNER = new Scanner(System.in);
    private final Galg galg;

    /**
     * Constructor method.
     *
     * @param galg The galg this tries to solve.
     */
    public GalgSolver(Galg galg) {
        this.galg = galg;
    }

    /**
     * Repeatedly ask the user for input and try to solve the galg with that.
     *
     * @return Whether the galg has successfully been solved.
     */
    public boolean solve() {
        while (galg.isAlive() && !galg.isSolved()) {
            System.out.print("\n" + galg);
            System.out.print("Enter a letter: ");
            galg.guess(getNextLetter());
        }
        return informUser(galg.isSolved());
    }

    /**
     * Get a char from the user, convert it to a String and turn it to lower
     * case.
     *
     * @return One char long String consisting of a lower case letter.
     */
    private static String getNextLetter() {
        return String.valueOf(SCANNER.nextLine().charAt(0)).toLowerCase();
    }

    /**
     * Inform the user whether he has solved the galg.
     *
     * @param solved Whether the user has solved the galg.
     */
    private boolean informUser(boolean solved) {
        if (solved) {
            System.out.println("You solved the word: " + this.galg.getWord());
        } else {
            System.out.println("You did not solve the word: " + this.galg.getWord());
        }
        return solved;
    }

}
