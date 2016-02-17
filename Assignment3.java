package assignment3;

/**
 * This is the main class containing the main method.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class Assignment3 {
    private static final WoordLezer READER = new WoordLezer("woorden.txt");

    /**
     * Entry point.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Galg g = new Galg(READER.geefWoord(), 10);
        System.out.println(g);
        g.guess("e");
        System.out.println(g);
    }
}
