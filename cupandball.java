import java.util.Random;
public class cupandball {
    int ballPosition;
    Random random;

    public cupandball() {
        random = new Random();
        shuffle();
    }

    public void shuffle() {
        ballPosition = random.nextInt(3);
        System.out.println("\nCups shuffled! Ball is under one of 1, 2, or 3.");
        System.out.println("Cup 1: ___ | Cup 2: ___ | Cup 3: ___");
    }

    public boolean guess(int choice) {
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid guess! Choose 1, 2, or 3.");
            return false;
        }
        boolean win = (choice - 1) == ballPosition;
        if (win) {
            System.out.println("You win! Ball was under Cup " + choice + "!");
        } else {
            System.out.println("Loss! Ball was under Cup " + (ballPosition + 1) + ".");
        }
        return win;
    }

}