import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * Shark is a Carnivore/Fish that can eat any other Fish except GiantSquids.
 * It lives to be a max of 700 cycles and has a starting health of
 * 200 points.
 *
 * @author Carey MacDonald
 * @version 1.0
 */
public class Shark extends Carnivore {

    /**
     * Constructor for Shark.  Sets the Shark's x value, y value, and
     * bounds, as well as defines its starting age, starting health, maxAge,
     * and image File.
     *
     * @param x the x point of this Shark
     * @param y the y point of this Shark
     * @param bounds the Rectangle that this Shark is bounded by
     */
    public Shark(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        this.age = 0;
        this.health = 200;
        this.maxAge = 700;
        this.img = new File("shark.png");
    }

    /**
     * Returns a boolean that says whether or not this Shark can eat the
     * given Fish (which is always, unless the other Fish is also a Shark or
     * is a mythical GiantSquid).
     *
     * @param f The Fish we want to see if this Shark can eat or not
     * @return true if this Shark can eat the given Fish
     */
    public boolean canEatFish(Fish f) {
        if (f instanceof GiantSquid) { return false; }
        if (f instanceof Shark) { return false; }
        return true;
    }

    /**
     * Returns an ArrayList of new Sharks that comes from two Sharks
     * colliding.  Shark's have a 1% chance upon colliding to reproduce
     * and can have 1 or 2 babies at a time.
     *
     * @param f The Fish that this Shark will be reproducing with
     * @return An ArrayList of baby Fish to be created
     */
    public ArrayList<Fish> reproduceWithFish(Fish f) {
        Random generator = new Random();
        ArrayList<Fish> babies = new ArrayList<Fish>();
        double num = generator.nextDouble();
        if (num <= .01) {
            int num1 = generator.nextInt(2);
            for (int x = 0; x <= num1; x++) {
                babies.add(new Shark(this.x, this.y, this.bounds));
            }
        }
        return babies;
    }

    /**
     * Returns whether or not this Shark has the ability to
     * reproduce with a given Fish.
     *
     * @param f The Fish we are checking
     * @return true if this Shark can reproduce with the given Fish
     */
    public boolean canReproduceWithFish(Fish f) {
        return (f instanceof Shark);
    }

}
