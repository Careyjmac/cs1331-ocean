import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * ParrotFish is a Herbivore/Fish that can eat seaweed to replenish its
 * health.  It lives to be a max of 200 cycles and has a starting health of
 * 50 points.
 *
 * @author Carey MacDonald
 * @version 1.0
 */
public class ParrotFish extends Herbivore {

    /**
     * Constructor for ParrotFish.  Sets the ParrotFish's x value, y value,
     * and bounds, as well as defines its starting age, starting health, maxAge,
     * and image File.
     *
     * @param x the x point of this ParrotFish
     * @param y the y point of this ParrotFish
     * @param bounds the Rectangle that this ParrotFish is bounded by
     */
    public ParrotFish(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        this.age = 0;
        this.health = 50;
        this.maxAge = 200;
        this.img = new File("parrotFish.png");
    }

    /**
     * Returns an ArrayList of new ParrotFishs that comes from two ParrotFishs
     * colliding.  ParrotFish's have a 2% chance upon colliding to reproduce
     * and can have only 1 baby at a time.
     *
     * @param f The Fish that this ParrotFish will be reproducing with
     * @return An ArrayList of baby Fish to be created
     */
    public ArrayList<Fish> reproduceWithFish(Fish f) {
        Random generator = new Random();
        ArrayList<Fish> babies = new ArrayList<Fish>();
        double num = generator.nextDouble();
        if (num <= .02) {
            babies.add(new ParrotFish(this.x, this.y, this.bounds));
        }
        return babies;
    }

    /**
     * Returns whether or not this ParrotFish has the ability to
     * reproduce with a given Fish.
     *
     * @param f The Fish we are checking
     * @return true if this ParrotFish can reproduce with the given Fish
     */
    public boolean canReproduceWithFish(Fish f) {
        return (f instanceof ParrotFish);
    }


}
