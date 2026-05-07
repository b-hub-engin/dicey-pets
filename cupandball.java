import java.util.Random;

public class cupandball {

    private static final int CUPS        = 3;
    private static final int SHUFFLE_ROUNDS = 4; // how many times cups swap during shuffle animation

    private int    ballPosition;
    private final  Random random;
    private boolean lastWon = false;

    public cupandball() {
        random = new Random();
        shuffle();
    }

    // --- Shuffle with a simple swap animation ---
    public void shuffle() {
        ballPosition = random.nextInt(CUPS);

        System.out.println("\nWatch closely...");
        displayCups(false); // show all cups closed before shuffle

        for (int i = 0; i < SHUFFLE_ROUNDS; i++) {
            try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            // Randomly swap ball between two cups to animate movement
            if (random.nextBoolean()) {
                ballPosition = random.nextInt(CUPS);
            }
            System.out.println("*shuffle*");
        }

        System.out.println("\nWhere is the ball? Guess a cup: 1, 2, or 3");
        displayCups(false);
    }

    // --- Guess with win/loss feedback ---
    public boolean guess(int choice) {
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid guess! Choose 1, 2, or 3.");
            return false;
        }

        lastWon = (choice - 1) == ballPosition;
        displayCups(true); // reveal all cups

        if (lastWon) {
            System.out.println("Correct! The ball was under Cup " + choice + "! Your pet is happy!");
        } else {
            System.out.println("Wrong! The ball was under Cup " + (ballPosition + 1) + ". Better luck next time!");
        }

        return lastWon;
    }

    public boolean Win() {
        return lastWon;
    }

    // --- ASCII cup display ---
    // revealed = true shows where the ball actually is
    private void displayCups(boolean revealed) {
        StringBuilder tops    = new StringBuilder();
        StringBuilder bottoms = new StringBuilder();
        StringBuilder labels  = new StringBuilder();

        for (int i = 0; i < CUPS; i++) {
            boolean hasBall = (i == ballPosition);
            tops.append("  _____  ");
            bottoms.append(revealed && hasBall ? " ( @ ) " : " (   ) ");
            labels.append("  Cup ").append(i + 1).append("  ");
            if (i < CUPS - 1) {
                tops.append("  ");
                bottoms.append("  ");
                labels.append("  ");
            }
        }

        System.out.println(tops);
        System.out.println(bottoms);
        System.out.println(labels);
        System.out.println();
    }
}