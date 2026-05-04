import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            Yareal yareal = new Yareal();
            Onion onion = new Onion();
            Crawler crawler = new Crawler();
            Speedys speedy = new Speedys();

            System.out.println("Welcome to the Dicey pets!");
            System.out.println("By Thomas Andrew Gatchi");
            System.out.println("Chose your pet");
            System.out.println("Yareal (1)\nOnion Amberwing (2)\nThe Crawler (3)\nSpeedy&Simon (4)");
            int pet = scanner.nextInt();
            scanner.nextLine(); 

            switch (pet) {
                case 1:
                    System.out.println("Say hi to Yareal!");
                    System.out.println("Keep your chosen pet fed, hydrated, happy, and alive as long as possible.");
                    System.out.println("Commands: 1=Feed, 2=Drink, 3=Play, 4=Wait (pass turn), 0=Quit\n");

                    while (yareal.isAlive()) {
                        System.out.println(yareal.getStatus());

                        System.out.print("Choose action (1-4, 0=Quit): ");
                        String input = scanner.nextLine().trim();

                        switch (input) {
                            case "1":
                                yareal.feed();
                                System.out.println("Yareal ate! Yum!");
                                break;
                            case "2":
                                yareal.drink();
                                System.out.println("Yareal drank! Glug glug!");
                                break;
                            case "3":
                                System.out.println("What game do you want to play?");
                                System.out.println("Blackjack (1)\nCup & Ball (2)");
                                int game = scanner.nextInt();
                                scanner.nextLine(); // FIX: consume newline

                                switch (game) {
                                    case 1:
                                        BlackJack.playBlackJack("Yareal");
                                        for (int i = 0; i <BlackJack.getRuns(); i++) {
                                            yareal.play();
                                        }
                                        break;
                                    case 2:
                                        cupandball cupandball = new cupandball();
                                        System.out.println("Guess which cup the ball is under! (1, 2, or 3)");
                                        int guess = scanner.nextInt();
                                        scanner.nextLine(); 
                                        cupandball.guess(guess);
                                        yareal.play(); 
                                        break;
                                    default:
                                        System.out.println("Invalid input.");
                                }
                                System.out.println("You played with Yareal! Fun time!");
                                break;
                            case "4":
                                System.out.println("You wait... time passes.");
                                break;
                            case "0":
                                System.out.println("Goodbye!");
                                scanner.close();
                                return;
                            default:
                                System.out.println("Invalid input. Try again.");
                                continue;
                        }

                        yareal.update();
                    }

                    System.out.println(yareal.getStatus());
                    System.out.println("Game Over! Yareal lived " + yareal.getAge() + " days.");
                    break; // FIX: was missing, caused fall-through to case 2

                case 2:
                    System.out.println("Say hi to Onion!");
                    System.out.println("Keep your chosen pet fed, hydrated, happy, and alive as long as possible.");
                    System.out.println("Commands: 1=Feed, 2=Drink, 3=Play, 4=Wait (pass turn), 0=Quit\n");

                    while (onion.isAlive()) {
                        System.out.println(onion.getStatus());

                        System.out.print("Choose action (1-4, 0=Quit): ");
                        String input1 = scanner.nextLine().trim();

                        switch (input1) {
                            case "1":
                                onion.feed();
                                System.out.println("Onion ate! Yum!");
                                break;
                            case "2":
                                onion.drink();
                                System.out.println("Onion drank! Glug glug!");
                                break;
                            case "3":
                                System.out.println("What game do you want to play?");
                                System.out.println("Blackjack (1)\nCup & Ball (2)"); // FIX: was "/n"
                                int game = scanner.nextInt();
                                scanner.nextLine(); // FIX: consume newline

                                switch (game) {
                                    case 1:
                                        BlackJack.playBlackJack("Onion Emberwind");
                                        for (int i = 0; i <BlackJack.getRuns(); i++) {
                                            onion.play();
                                        }
                                        break;
                                    case 2:
                                        cupandball cupandball = new cupandball();
                                        System.out.println("Guess which cup the ball is under! (1, 2, or 3)");
                                        int guess = scanner.nextInt();
                                        scanner.nextLine(); // FIX: consume newline
                                        cupandball.guess(guess);
                                        break;
                                    default:
                                        System.out.println("Invalid input.");
                                }
                                onion.play();
                                System.out.println("You played with Onion! Fun time!");
                                break;
                            case "4":
                                System.out.println("You wait... time passes.");
                                break;
                            case "0":
                                System.out.println("Goodbye!");
                                scanner.close();
                                return;
                            default:
                                System.out.println("Invalid input. Try again.");
                                continue;
                        }

                        onion.update();
                    }

                    System.out.println(onion.getStatus());
                    System.out.println("Game Over! Onion lived " + onion.getAge() + " days.");
                    break; // FIX: was missing, caused fall-through to case 3

                case 3:
                    System.out.println("Say hi to The Crawler!");
                    System.out.println("Keep your chosen pet fed, hydrated, happy, and alive as long as possible.");
                    System.out.println("Commands: 1=Feed, 2=Drink, 3=Play, 4=Wait (pass turn), 0=Quit\n");

                    while (crawler.isAlive()) {
                        System.out.println(crawler.getStatus());

                        System.out.print("Choose action (1-4, 0=Quit): ");
                        String input1 = scanner.nextLine().trim();

                        switch (input1) {
                            case "1":
                                crawler.feed();
                                System.out.println("The Crawler ate! Yum!");
                                break;
                            case "2":
                                crawler.drink();
                                System.out.println("The Crawler drank! Glug glug!");
                                break;
                            case "3":
                                System.out.println("What game do you want to play?");
                                System.out.println("Blackjack (1)\nCup & Ball (2)"); // FIX: was "/n"
                                int game = scanner.nextInt();
                                scanner.nextLine(); // FIX: consume newline

                                switch (game) {
                                    case 1:
                                        BlackJack.playBlackJack("The Crawler");
                                        for (int i = 0; i <BlackJack.getRuns(); i++) {
                                            crawler.play();
                                        }
                                        break;
                                    case 2:
                                        cupandball cupandball = new cupandball();
                                        System.out.println("Guess which cup the ball is under! (1, 2, or 3)");
                                        int guess = scanner.nextInt();
                                        scanner.nextLine(); // FIX: consume newline
                                        cupandball.guess(guess);
                                        break;
                                    default:
                                        System.out.println("Invalid input.");
                                }
                                crawler.play();
                                System.out.println("You played with The Crawler! Fun time!");
                                break;
                            case "4":
                                System.out.println("You wait... time passes.");
                                break;
                            case "0":
                                System.out.println("Goodbye!");
                                scanner.close();
                                return;
                            default:
                                System.out.println("Invalid input. Try again.");
                                continue;
                        }

                        crawler.update();
                    }

                    System.out.println(crawler.getStatus());
                    System.out.println("Game Over! The Crawler lived " + crawler.getAge() + " days."); // FIX: was "Onion"
                    break; // FIX: was missing, caused fall-through to case 4

                case 4:
                    System.out.println("Say hi to Speedy & Simon!");
                    System.out.println("Keep your chosen pet fed, hydrated, happy, and alive as long as possible.");
                    System.out.println("Commands: 1=Feed, 2=Drink, 3=Play, 4=Wait (pass turn), 0=Quit\n");

                    while (speedy.isAlive()) {
                        System.out.println(speedy.getStatus());

                        System.out.print("Choose action (1-4, 0=Quit): ");
                        String input1 = scanner.nextLine().trim();

                        switch (input1) {
                            case "1":
                                speedy.feed();
                                System.out.println("Speedy ate! Yum!");
                                break;
                            case "2":
                                speedy.drink();
                                System.out.println("Speedy drank! Glug glug!");
                                break;
                            case "3":
                                System.out.println("What game do you want to play?");
                                System.out.println("Blackjack (1)\nCup & Ball (2)"); // FIX: was "/n"
                                int game = scanner.nextInt();
                                scanner.nextLine(); // FIX: consume newline

                                switch (game) {
                                    case 1:
                                        BlackJack.playBlackJack("Speedy & Simon");
                                        for (int i = 0; i <BlackJack.getRuns(); i++) {
                                            speedy.play();
                                        }
                                        break;
                                    case 2:
                                        cupandball cupandball = new cupandball();
                                        System.out.println("Guess which cup the ball is under! (1, 2, or 3)");
                                        int guess = scanner.nextInt();
                                        scanner.nextLine(); // FIX: consume newline
                                        cupandball.guess(guess);
                                        speedy.play(); // FIX: moved here so it only runs for cup&ball
                                        break;
                                    default:
                                        System.out.println("Invalid input.");
                                }
                                // FIX: removed extra speedy.play() that was double-counting
                                System.out.println("You played with Speedy! Fun time!");
                                break;
                            case "4":
                                System.out.println("You wait... time passes.");
                                break;
                            case "0":
                                System.out.println("Goodbye!");
                                scanner.close();
                                return;
                            default:
                                System.out.println("Invalid input. Try again.");
                                continue;
                        }

                        speedy.update();
                    }

                    System.out.println(speedy.getStatus());
                    System.out.println("Game Over! Speedy & Simon lived " + speedy.getAge() + " days."); 
                    break;

                default:
                    System.out.println("Invalid input. Please choose 1-4.");
            }

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
}