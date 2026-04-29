import java.util.Scanner;
public class Yareal {
    private String name;
    private double hunger;
    private int thirst;
    private double happiness;
    private int age;
    private boolean alive;
    private int turnsUntilAgeUp = 10; // Age up every 10 turns
    Scanner scanner = new Scanner(System.in); 
    public Yareal() {
        this.name = "Yareal";
        this.hunger = 100.0;
        this.thirst = 100;
        this.happiness = 100.0;
        this.age = 0;
        this.alive = true;
    }

    public Yareal(String name, double happiness) {
        this.name = name;
        this.hunger = 100;
        this.thirst = 100;
        this.happiness = happiness;
        this.age = 0;
        this.alive = true;
    }

    public void update(double multHunger, double multHappy) {
        if (!alive)
            return;

        hunger = Math.max(0, hunger - 2*multHunger); // Hunger decays by 2 per turn
        if (hunger <= 50) {
            happiness = Math.max(0, happiness*multHappy - 5); // If hunger is low, happiness decays faster
            System.out.println(name + " is getting hungry!");
        }
        thirst = Math.max(0, thirst - 3); // Thirst decays faster by 3
        if (thirst <= 50) {
            happiness = Math.max(0, happiness - 5*multHappy); // If thirst is low, happiness decays faster
            System.out.println(name + " is getting thirsty!");
        }
        happiness = Math.max(0, happiness - 1*multHappy - (age / 10)); // Happiness decays, faster with age
        if (happiness <= 50) {
            System.out.println(name + " is feeling sad!");
        }

        if (turnsUntilAgeUp <= 0) {
            ageUp();
            turnsUntilAgeUp = 10;
        } else {
            turnsUntilAgeUp--;
        }

        if (hunger <= 0 || thirst <= 0 || happiness <= 0) {
            alive = false;
        }
    }




    public void update() {
        if (!alive)
            return;

        hunger = Math.max(0, hunger - 2); // Hunger decays by 2 per turn
        if (hunger <= 50) {
            happiness = Math.max(0, happiness - 5); // If hunger is low, happiness decays faster
            System.out.println(name + " is getting hungry!");
        }
        thirst = Math.max(0, thirst - 3); // Thirst decays faster by 3
        if (thirst <= 50) {
            happiness = Math.max(0, happiness - 5); // If thirst is low, happiness decays faster
            System.out.println(name + " is getting thirsty!");
        }
        happiness = Math.max(0, happiness - 1 - (age / 10)); // Happiness decays, faster with age
        if (happiness <= 50) {
            System.out.println(name + " is feeling sad!");
        }

        if (turnsUntilAgeUp <= 0) {
            ageUp();
            turnsUntilAgeUp = 10;
        } else {
            turnsUntilAgeUp--;
        }

        if (hunger <= 0 || thirst <= 0 || happiness <= 0) {
            alive = false;
        }
    }



    public void feed() {
        if (alive) {
            hunger = Math.min(100, hunger + 30);
            if (hunger > 80) {
                System.out.println(name + " is getting full!");
                happiness = Math.max(0, happiness - 5); // Overfeeding reduces happiness
            }
            happiness = Math.min(100, happiness + 10);
        }
    }

    public void drink() {
        if (alive) {
            thirst = Math.min(100, thirst + 40);
            if (thirst > 80) {
                System.out.println(name + " is getting overhydrated!");
                happiness = Math.max(0, happiness - 5); // Overhydration reduces happiness
            }
            happiness = Math.min(100, happiness + 10);
        }
    }

    public void play() {
        if (alive) {
            System.out.println("what game do you want to play");
            System.out.println("blackjack(1)/nCup&Ball(2)");
            int game = scanner.nextInt();
            switch(game){
            case 1:
            System.out.println("who are you playing against");
            System.out.println("Yereal(1)/nSpeedy&Simon(2)/nCrawler(3)/nOnion");
            int opp = scanner.nextInt();
            
            case 2:
            System.out.println("who are you playing against");
            System.out.println("Yereal(1)/nSpeedy&Simon(2)/nCrawler(3)/nOnion(4)");
            int op = scanner.nextInt();

            }
            happiness = Math.min(100, happiness + 25);
            if (happiness > 80) {
                System.out.println(name + " is having a great time!");
                hunger = Math.max(0, hunger + 5); // Playing more negates costs
                thirst = Math.max(0, thirst + 5);
            }
            hunger = Math.max(0, hunger - 5); // Play costs some hunger
            thirst = Math.max(0, thirst - 5);
        }
    }

    private void ageUp() {
        age++;
        happiness = Math.max(0, happiness - 5); // Aging reduces happiness
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public double getHappiness() {
        return happiness;
    }

    public int getAge() {
        return age;
    }

    public boolean isAlive() {
        return alive;
    }

    public String getStatus() {
        if (!alive)
            return name + " is dead.";
        return String.format("%s: Age %d days | Hunger %d%% | Thirst %d%% | Happiness %d%%", name, age, hunger, thirst,
                happiness);
    }
}
