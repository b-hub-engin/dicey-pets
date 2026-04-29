import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        Yareal yareal = new Yareal();
        Onion onion = new Onion();
        Crawler crawler = new Crawler();
        Speedys speedy = new Speedys();
        int pet;
        String Playagain = "";
        
        System.out.println("Welcome to the Dicey pets!");
        System.out.println("By Thomas Andrew Gatchi");
        System.out.println("Chose you pet");
        System.out.println("Yareal (1)/nOnion Amberwing (2)/nThe Crawler(3)/nSpeedy&Simon (4)");
        pet = scanner.nextInt(); // Wait for user input before starting
        
        
        switch (pet) {
            case 1:
                System.out.println("Say hi to Yareal! ");
                System.out.println("Keep your chosen pet fed, hydrated, happy, and alive as long as possible.");
                System.out.println("Commands: 1=Feed, 2=Drink, 3=Play, 4=Wait (pass turn), 0=Quit\n");

                while (yareal.isAlive()) {
                    System.out.println(yareal.getStatus());
                    if (!yareal.isAlive())
                    break;

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
                    yareal.play();
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

                yareal.update(); // Process turn
        }

                System.out.println(yareal.getStatus());
                System.out.println("Game Over! Yareal lived " + yareal.getAge() + " days.");
                System.out.println("want to play again? (y/n)");
                String playAgain = scanner.nextLine().trim().toLowerCase();
                if ( playAgain == "y"){
                    System.out.println("Welcome to the tommus andrew gatchy!");
                    System.out.println("chossing between Yareal (1) and onion amberwing (2)...");
                    pet = scanner.nextInt(); // Wait for user input before starting
                } else {
                    System.out.println("Thanks for playing! Goodbye!");
                    scanner.close();
                    return;
                }
            

        
            case 2:
                System.out.println("Say hi to Onion! ");
                System.out.println("Keep your chosen pet fed, hydrated, happy, and alive as long as possible.");
                System.out.println("Commands: 1=Feed, 2=Drink, 3=Play, 4=Wait (pass turn), 0=Quit\n");

            while (onion.isAlive()) {
                System.out.println(onion.getStatus());
                if (!onion.isAlive())
                    break;

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

                onion.update(); // Process turn
            }

            System.out.println(onion.getStatus());
            System.out.println("Game Over! Onion lived " + onion.getAge() + " days.");
            System.out.println("want to play again? (y/n)");
            playAgain = scanner.nextLine().trim().toLowerCase();
            if ( playAgain == "y"){
                System.out.println("Welcome to the tommus andrew gatchy!");
                System.out.println("chossing between Yareal (1) and onion amberwing (2)...");
                pet = scanner.nextInt(); // Wait for user input before starting
            }
            else if ( playAgain == "n"){
                System.out.println("Thanks for playing! Goodbye!");
                scanner.close();
                return;
            }
            else {
                System.out.println("Invalid input. try again.");
                playAgain = scanner.nextLine().trim().toLowerCase();
            }
            
            
            case 3:
                System.out.println("Say hi to The Crawler!");
                System.out.println("Keep your chosen pet fed, hydrated, happy, and alive as long as possible.");
                System.out.println("Commands: 1=Feed, 2=Drink, 3=Play, 4=Wait (pass turn), 0=Quit\n");

            while (crawler.isAlive()) {
                System.out.println(crawler.getStatus());
                if (!crawler.isAlive())
                    break;

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

                crawler.update(); // Process turn
            }

            System.out.println(crawler.getStatus());
            System.out.println("Game Over! Onion lived " + crawler.getAge() + " days.");
            System.out.println("want to play again? (y/n)");
            playAgain = scanner.nextLine().trim().toLowerCase();
            if ( playAgain == "y"){
                System.out.println("Welcome to the tommus andrew gatchy!");
                System.out.println("chossing between Yareal (1) and onion amberwing (2)...");
                pet = scanner.nextInt(); // Wait for user input before starting
            }
            else if ( playAgain == "n"){
                System.out.println("Thanks for playing! Goodbye!");
                scanner.close();
                return;
            }
            else {
                System.out.println("Invalid input. try again.");
                playAgain = scanner.nextLine().trim().toLowerCase();
            }
            case 4:
                System.out.println("Say hi to speedy & !");
                System.out.println("Keep your chosen pet fed, hydrated, happy, and alive as long as possible.");
                System.out.println("Commands: 1=Feed, 2=Drink, 3=Play, 4=Wait (pass turn), 0=Quit\n");

            while (speedy.isAlive()) {
                System.out.println(speedy.getStatus());
                if (!speedy.isAlive())
                    break;

                    System.out.print("Choose action (1-4, 0=Quit): ");
                    String input1 = scanner.nextLine().trim();

                switch (input1) {
                    case "1":
                        speedy.feed();
                        System.out.println("The Crawler ate! Yum!");
                        break;
                    case "2":
                        speedy.drink();
                        System.out.println("The Crawler drank! Glug glug!");
                        break;
                    case "3":
                        speedy.play();
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

                speedy.update(); // Process turn
            }

            System.out.println(speedy.getStatus());
            System.out.println("Game Over! Onion lived " + speedy.getAge() + " days.");
            System.out.println("want to play again? (y/n)");
            playAgain = scanner.nextLine().trim().toLowerCase();
            if ( playAgain == "y"){
                System.out.println("Welcome to the tommus andrew gatchy!");
                System.out.println("chossing between Yareal (1) and onion amberwing (2)...");
                pet = scanner.nextInt(); // Wait for user input before starting
            }
            else if ( playAgain == "n"){
                System.out.println("Thanks for playing! Goodbye!");
                scanner.close();
                return;
            }
            else {
                System.out.println("Invalid input. try again.");
                playAgain = scanner.nextLine().trim().toLowerCase();
            }
        
            default: 
                System.out.println("invaled imput");
                System.out.println("chossing between Yareal (1) and onion amberwing (2)...");
                pet = scanner.nextInt();  
        }
    
  
    
    
  
    
    
    }
}