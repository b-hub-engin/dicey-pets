import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        Yareal yareal = new Yareal();
        Onion onion = new Onion();
        int pet;
        
        System.out.println("Welcome to the Thomas Andrew Gatchy!");
        System.out.println("chossing between Yareal (1) and onion amberwing (2)...");
        pet = scanner.nextInt(); // Wait for user input before starting
        
        
        if (pet == 1) {
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
    }
    
    
    if (pet == 2) {
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
        String playAgain = scanner.nextLine().trim().toLowerCase();
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
    }
    
    
    if (pet == 3 || pet == 4) {
        System.out.println("coming soon...");
        System.out.println("chossing between Yareal (1) and onion amberwing (2)...");
        pet = scanner.nextInt();
    }
    
    
    if (pet != 1 && pet != 2 && pet != 3 && pet != 4){
        System.out.println("invaled imput");
        System.out.println("chossing between Yareal (1) and onion amberwing (2)...");
        pet = scanner.nextInt();
    }
}
}