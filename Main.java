import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            clearScreen();
            System.out.println("Welcome to the Dicey pets!");
            System.out.println("By Thomas Andrew Gatchi");
            System.out.println("Choose your pet:");
            System.out.println("Yareal (1)\nOnion Amberwing (2)\nThe Crawler (3)\nSpeedy & Simon (4)");

            int pet = scanner.nextInt();
            scanner.nextLine();

            Yareal chosen = null;
            switch (pet) {
                case 1: 
                chosen = new Yareal();   
                break;
                case 2: 
                chosen = new Onion();    
                break;
                case 3: 
                chosen = new Crawler();  
                break;
                case 4: 
                chosen = new Speedys();  
                break;
                default:
                    System.out.println("Invalid input. Please choose 1-4.");
                    continue;
            }

            clearScreen();
            playGame(chosen, scanner);

            clearScreen();
            System.out.println("Want to play again? (y/n)");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (playAgain.equals("y")) {
                playing = true;
            } else {
                playing = false;
                System.out.println("Thanks for playing! Goodbye!");
            }
        }

        scanner.close();
    }

    private static void playGame(Yareal pet, Scanner scanner) {
        String name = pet.getName();

        System.out.println("Say hi to " + name + "!");
        System.out.println("Keep your chosen pet fed, hydrated, happy, and alive as long as possible.");
        System.out.println("Commands: 1=Feed, 2=Drink, 3=Play, 4=Wait (pass turn), 0=Quit\n");
        System.out.println("Press Enter to start...");
        scanner.nextLine();

        while (pet.isAlive()) {
            clearScreen();
            System.out.println(pet.getStatus());
            System.out.print("Choose action (1-4, 0=Quit): ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    pet.feed();
                    System.out.println(name + " ate! Yum!");
                    break;
                case "2":
                    pet.drink();
                    System.out.println(name + " drank! Glug glug!");
                    break;
                case "3":
                    System.out.println("What game do you want to play?");
                    System.out.println("Blackjack (1)\nCup & Ball (2)");
                    int game = scanner.nextInt();
                    scanner.nextLine();

                    switch (game) {
                        case 1:
                            BlackJack.playBlackJack(name);
                            for (int i = 0; i < BlackJack.getRuns(); i++) {
                                pet.play();
                            }
                            break;
                        case 2:
                            cupandball cupandball = new cupandball();
                            System.out.println("Guess which cup the ball is under! (1, 2, or 3)");
                            int guess = scanner.nextInt();
                            scanner.nextLine();
                            cupandball.guess(guess);
                            pet.play();
                            break;
                        default:
                            System.out.println("Invalid input.");
                    }
                    System.out.println("You played with " + name + "! Fun time!");
                    break;
                case "4":
                    System.out.println("You wait... time passes.");
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Try again.");
                    continue;
            }

            // Pause so the player can read feedback before the screen clears
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();

            pet.update();
        }

        clearScreen();
        System.out.println(pet.getStatus());
        System.out.println("Game Over! " + name + " lived " + pet.getAge() + " days.");
    }

    private static void clearScreen() {
    for (int i = 0; i < 50; i++) System.out.println();
}
}