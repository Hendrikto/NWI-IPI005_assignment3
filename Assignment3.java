package assignment3;

/**
 * This is the main class containing the main method.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class Assignment3 {
    /**
     * Entry point.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        GalgSolver gs;
        while (true) {
            gs = new GalgSolver(new Galg(10));
            gs.solve();
        }
    }
}
