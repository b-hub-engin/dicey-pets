public class Yareal {

    // --- Constants ---
    private static final double DECAY_RATE    = 1.5;  // base stat loss per turn
    private static final double WARN_RATIO    = 0.40; // warn when stat drops below 40% of max
    private static final double FULL_RATIO    = 0.85; // penalty triggers if already above 85% when gaining
    private static final double FEED_GAIN     = 15.0; // how much feed/drink restores
    private static final double FEED_HAPPY    = 5.0;  // happiness gained from feeding/drinking
    private static final double OVERFLOW_HIT  = 5.0;  // happiness lost from overfeeding/overdrinking/overplaying
    private static final double PLAY_GAIN     = 10.0; // happiness gained from playing
    private static final double PLAY_COST     = 3.0;  // hunger/thirst lost from playing
    private static final double PLAY_OVER_COST= 5.0;  // extra cost when playing at max happiness
    private static final double AGE_HIT       = 5.0;  // happiness lost per age-up
    private static final double AGE_DECAY_INC = 0.05; // how much harder the game gets per age
    private static final int    AGE_INTERVAL  = 10;   // turns between age-ups

    // --- Fields ---
    private String name;
    private double hunger;
    private double thirst;
    private double happiness;
    private int    age;
    private double multHunger;
    private double multHappy;
    private double multthirst;
    private double agedecay;
    private boolean alive;
    private int turnsUntilAgeUp = AGE_INTERVAL;

    // --- Constructors ---
    public Yareal() {
        this("Yareal", 100.0, 100.0, 100.0, 1.0, 1.0, 1.0);
    }

    public Yareal(String name, double basehunger, double basethirst, double basehappy,
                  double multHunger, double multHappy, double multthirst) {
        this.name       = name;
        this.hunger     = basehunger;
        this.thirst     = basethirst;
        this.happiness  = basehappy;
        this.age        = 0;
        this.alive      = true;
        this.multHunger = multHunger;
        this.multHappy  = multHappy;
        this.multthirst = multthirst;
        this.agedecay   = 0.5;
    }

    // --- Private helpers ---

    // Decays a stat and reduces happiness + prints a warning if it falls below 40% of max
    private double decayAndWarn(double stat, double mult, String warning) {
        double result = Math.max(0, stat - (DECAY_RATE * mult) - agedecay);
        if (result <= WARN_RATIO * 100 * mult) {
            happiness = Math.max(0, happiness - (OVERFLOW_HIT * multHappy));
            System.out.println(name + warning);
        }
        return result;
    }

    // Adds to a stat, caps at max, and penalises happiness only if already nearly full before the gain
    private double gainStat(double stat, double mult, double gain, String overflowMsg) {
        boolean nearFull = stat >= FULL_RATIO * 100 * mult;
        stat += gain;
        if (stat > 100 * mult) {
            stat = 100 * mult;
            if (nearFull) {
                happiness = Math.max(0, happiness - (OVERFLOW_HIT * multHappy));
                System.out.println(name + overflowMsg);
            }
        }
        return stat;
    }

    // --- Public methods ---
    public void update() {
        if (!alive) return;

        hunger    = decayAndWarn(hunger, multHunger, " is getting hungry!");
        thirst    = decayAndWarn(thirst, multthirst, " is getting thirsty!");

        // Happiness decay doesn't further reduce happiness on warn — handled separately
        happiness = Math.max(0, happiness - (DECAY_RATE * multHappy) - agedecay);
        if (happiness <= WARN_RATIO * 100 * multHappy)
            System.out.println(name + " is feeling sad!");

        if (turnsUntilAgeUp <= 0) {
            ageUp();
            turnsUntilAgeUp = AGE_INTERVAL;
        } else {
            turnsUntilAgeUp--;
        }

        if (hunger <= 0 || thirst <= 0 || happiness <= 0)
            alive = false;
    }

    public void feed() {
        if (!alive) return;
        hunger    = gainStat(hunger, multHunger, FEED_GAIN * multHunger, " is too full!");
        happiness = Math.min(100 * multHappy, happiness + FEED_HAPPY * multHappy);
    }

    public void drink() {
        if (!alive) return;
        thirst    = gainStat(thirst, multthirst, FEED_GAIN * multthirst, " is overhydrated!");
        happiness = Math.min(100 * multHappy, happiness + FEED_HAPPY * multHappy);
    }

    public void play() {
        if (!alive) return;
        boolean alreadyHappy = happiness >= FULL_RATIO * 100 * multHappy;
        happiness += PLAY_GAIN * multHappy;
        if (happiness > 100 * multHappy) {
            happiness = 100 * multHappy;
            if (alreadyHappy) {
                hunger = Math.max(0, hunger - (PLAY_OVER_COST * multHunger));
                thirst = Math.max(0, thirst - (PLAY_OVER_COST * multthirst));
                System.out.println(name + " is having a great time!");
            }
        }
        hunger = Math.max(0, hunger - (PLAY_COST * multHunger));
        thirst = Math.max(0, thirst - (PLAY_COST * multthirst));
    }

    private void ageUp() {
        age++;
        happiness = Math.max(0.0, happiness - (AGE_HIT * multHappy));
        agedecay += AGE_DECAY_INC;
    }

    // --- Getters ---
    public String  getName()      { return name; }
    public double  getHunger()    { return hunger; }
    public double  getThirst()    { return thirst; }
    public double  getHappiness() { return happiness; }
    public int     getAge()       { return age; }
    public boolean isAlive()      { return alive; }

    public String getStatus() {
        if (!alive) return name + " is dead.";
        // hunger/multHunger gives 0-100% normalized — simplified from (hunger/(100*mult))*100
        return String.format(
                "%s: age %d | Hunger %.0f%% | Thirst %.0f%% | Happiness %.0f%%",
                name, age, hunger/multHunger, thirst/multthirst, happiness/multHappy);
    }
}