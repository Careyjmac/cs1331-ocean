import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * Gyarados is a Carnivore/Fish that can eat any other Fish, including
 * GiantSquids and Sharks, as long as those don't eat it first.  Gyarados can
 * either be created by selecting it OR evolving from Magikarp.  It lives to be
 * a max of 1000 cycles and has a starting health of 250 points.
 *
 * @author Carey MacDonald
 * @version 1.0
 */
public class Gyarados extends Carnivore {

    /**
     * Constructor for Gyarados.  Sets the Gyarados's x value, y value, and
     * bounds, as well as defines its starting age, starting health, maxAge,
     * and image File.
     *
     * @param x the x point of this Gyarados
     * @param y the y point of this Gyarados
     * @param bounds the Rectangle that this Gyarados is bounded by
     */
    public Gyarados(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        this.age = 0;
        this.health = 250;
        this.maxAge = 1000;
        this.img = new File("gyarados.png");
        this.rec.setSize(184, 180);
    }

    /**
     * Returns a boolean that says whether or not this Gyarados can eat the
     * given Fish (which is always, unless the other Fish is also a Gyarados, or
     * Gyarados's baby Magikarp).
     *
     * @param f The Fish we want to see if this Gyarados can eat or not
     * @return true if this Gyarados can eat the given Fish
     */
    public boolean canEatFish(Fish f) {
        if (f instanceof Gyarados || f instanceof Magikarp)  { return false; }
        return true;
    }

    /**
     * Returns an ArrayList of new Magikarps that comes from two Gyarados
     * colliding.  Gyarados's have a 1% chance upon colliding to reproduce
     * and can have only 1 baby at a time.
     *
     * @param f The Fish that this Gyarados will be reproducing with
     * @return An ArrayList of baby Fish to be created
     */
    public ArrayList<Fish> reproduceWithFish(Fish f) {
        Random generator = new Random();
        ArrayList<Fish> babies = new ArrayList<Fish>();
        double num = generator.nextDouble();
        if (num <= .01) {
            babies.add(new Magikarp(this.x, this.y, this.bounds));
        }
        return babies;
    }

    /**
     * Returns whether or not this Gyarados has the ability to
     * reproduce with a given Fish.
     *
     * @param f The Fish we are checking
     * @return true if this Gyarados can reproduce with the given Fish
     */
    public boolean canReproduceWithFish(Fish f) {
        return (f instanceof Gyarados);
    }

    /**
     * Moves this Gyarados to a new semi-random, semi-adjacent spot in the
     * Ocean.  We are overriding it here because Gyarados's image is much
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
        if (x >= 416) {
            x = 416;
        } else if (x <= 0) {
            x = 0;
        }
        if (y >= 420) {
            y = 420;
        } else if (y <= 0) {
            y = 0;
        }
        rec.setLocation(x, y);
    }

}
