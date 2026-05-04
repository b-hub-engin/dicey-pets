import java.util.Scanner;

public class Yareal {
    private String name;
    private double hunger;
    private int thirst;
    private double happiness;
    private int age;
    private double multHunger;
    private double multHappy;
    private boolean alive;
    private int turnsUntilAgeUp = 10;

    public Yareal() {
        this.name = "Yareal";
        this.hunger = 100.0;
        this.thirst = 100;
        this.happiness = 100.0;
        this.age = 0;
        this.alive = true;
        this.multHunger = 1.0;
        this.multHappy = 1.0;
    }

    public Yareal(String name, double happiness, double hunger, int thirst, double multHunger, double multHappy) {
        this.name = name;
        this.hunger = hunger;
        this.thirst = thirst;
        this.happiness = happiness;
        this.age = 0;
        this.alive = true;
        this.multHunger = multHunger;
        this.multHappy = multHappy;
    }

    // Parameterized update used by subclasses with different decay rates
    public void update(double multHunger, double multHappy) {
        if (!alive)
            return;

        hunger = Math.max(0, hunger - 2 * multHunger);
        if (hunger <= 50) {
            happiness = Math.max(0, happiness - 5 * multHappy); // FIX: was multiplicative (happiness*multHappy - 5), now consistent with no-arg version
            System.out.println(name + " is getting hungry!");
        }

        thirst = Math.max(0, thirst - 3);
        if (thirst <= 50) {
            happiness = Math.max(0, happiness - 5 * multHappy);
            System.out.println(name + " is getting thirsty!");
        }

        happiness = Math.max(0, happiness - 1 * multHappy - (age / 10));
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

        hunger = Math.max(0, this.hunger - 2);
        if (hunger <= 50) {
            happiness = Math.max(0, this.happiness - 5);
            System.out.println(name + " is getting hungry!");
        }

        thirst = Math.max(0, this.thirst - 3);
        if (thirst <= 50) {
            happiness = Math.max(0, this.happiness - 5);
            System.out.println(name + " is getting thirsty!");
        }

        happiness = Math.max(0, this.happiness - 1 - (age / 10));
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
            hunger = Math.min(100, this.hunger + 30);
            if (hunger > 80) {
                System.out.println(name + " is getting full!");
                happiness = Math.max(0, this.happiness - 5);
            }
            happiness = Math.min(100, this.happiness + 10);
        }
    }

    public void drink() {
        if (alive) {
            thirst = Math.min(100, this.thirst + 40);
            if (thirst > 80*thirst/100) { // FIX: was just thirst > 80, now also considers hunger to avoid overhydration when very hungry
                System.out.println(name + " is getting overhydrated!");
                happiness = Math.max(0, this.happiness - 5);
            }
            happiness = Math.min(100, this.happiness + 10);
        }
    }

    public void play() {
        if (alive) {
            happiness = Math.min(100, this.happiness + 25);
            if (happiness > 80) {
                System.out.println(name + " is having a great time!");
            } else {
                hunger = Math.max(0, this.hunger - 5);
                thirst = Math.max(0, this.thirst - 5);
            }
        }
    }

    private void ageUp() {
        age++;
        happiness = Math.max(0, happiness - 5);
    }

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
        return String.format(
                "%s: age %d | Hunger %.0f%% | Thirst %d%% | Happiness %.0f%%",
                name, age, hunger, thirst, happiness);
    }
}
