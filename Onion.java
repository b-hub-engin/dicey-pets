public class Onion {
    private String name;
    private int hunger;
    private int thirst;
    private int happiness;
    private int age;
    private boolean alive;
    private int turnsUntilAgeUp = 10; // Age up every 10 turns

    public Onion() {
        this.name = "onion amberwing";
        this.hunger = 100;
        this.thirst = 100;
        this.happiness = 100;
        this.age = 0;
        this.alive = true;
    }

    public void update() {
        if (!alive)
            return;

        hunger = Math.max(0, hunger - 5); // Hunger decays by 2 per turn
        if (hunger <= 50) {
            happiness = Math.max(0, happiness - 5); // If hunger is low, happiness decays faster
            System.out.println(name + " is getting hungry!");
        }
        thirst = Math.max(0, thirst - 5); // Thirst decays faster by 3
        if (thirst <= 50) {
            happiness = Math.max(0, happiness - 5); // If thirst is low, happiness decays faster
            System.out.println(name + " is getting thirsty!");
        }
        happiness = Math.max(0, happiness - 4 - (age / 10)); // Happiness decays, faster with age
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
            hunger = Math.min(100, hunger + 25);
            if (hunger > 80) {
                System.out.println(name + " is getting full!");
                happiness = Math.max(0, happiness - 5); // Overfeeding reduces happiness
            }
            happiness = Math.min(100, happiness + 10);
        }
    }

    public void drink() {
        if (alive) {
            thirst = Math.min(100, thirst + 30);
            if (thirst > 80) {
                System.out.println(name + " is getting overhydrated!");
                happiness = Math.max(0, happiness - 5); // Overhydration reduces happiness
            }
            happiness = Math.min(100, happiness + 10);
        }
    }

    public void play() {
        if (alive) {
            happiness = Math.min(100, happiness + 30);
            if (happiness > 80) {
                System.out.println(name + " is having a great time!");
            }
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

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getHappiness() {
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
