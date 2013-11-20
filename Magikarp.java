import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * Magikarp is a Herbivore/Fish that can eat seaweed to replenish its
 * health.  It evolves into Gyarados if it can survive for 100 cycles.
 * Magikarp cannot reproduce until it becomes Gyarados.  It has a starting
 * health of 50.
 *
 * @author Carey MacDonald
 * @version 1.0
 */
public class Magikarp extends Herbivore {

    /**
     * Constructor for Magikarp.  Sets the Magikarp's x value, y value,
     * and bounds, as well as defines its starting age, starting health, maxAge,
     * and image File.
     *
     * @param x the x point of this Magikarp
     * @param y the y point of this Magikarp
     * @param bounds the Rectangle that this Magikarp is bounded by
     */
    public Magikarp(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        this.age = 0;
        this.health = 50;
        this.maxAge = 100;
        this.img = new File("magikarp.png");
        this.rec.setSize(96, 96);
    }

    /**
     * Returns null because a Magikarp cannot reproduce.
     *
     * @param f The Fish that this Magikarp would be reproducing with
     * @return An ArrayList of baby Fish to be created (or in this case null)
     */
    public ArrayList<Fish> reproduceWithFish(Fish f) {
        return null;
    }

    /**
     * Returns whether or not this Magikarp has the ability to
     * reproduce with a given Fish.  Will always return false since a
     * Magikarp cannot reproduce.
     *
     * @param f The Fish we are checking
     * @return false since Magikarp's cannot reproduce
     */
    public boolean canReproduceWithFish(Fish f) {
        return false;
    }

    /**
     * Moves this Magikarp to a new semi-random, semi-adjacent spot in the
     * Ocean.  We are overriding it here because Magikarp's image is slightly
     * larger than the standard fish, so we need additional constraints to
     * make sure they cannot go off the screen.
     */
    public void move() {
        Random generator = new Random();
        int num1 = generator.nextInt(4);
        if (num1 == 0) {
            x -= 5;
            y -= 5;
        } else if (num1 == 1) {
            x -= 5;
            y += 5;
        } else if (num1 == 2) {
            x += 5;
            y -= 5;
        } else {
            x += 5;
            y += 5;
        }
        if (x >= 504) {
            x = 504;
        } else if (x <= 0) {
            x = 0;
        }
        if (y >= 504) {
            y = 504;
        } else if (y <= 0) {
            y = 0;
        }
        rec.setLocation(x, y);
    }

}
