import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * SurgeonFish is a Herbivore/Fish that can eat seaweed to replenish its
 * health.  It lives to be a max of 200 cycles and has a starting health of
 * 50 points.
 *
 * @author Carey MacDonald
 * @version 1.0
 */
public class SurgeonFish extends Herbivore {

    /**
     * Constructor for SurgeonFish.  Sets the SurgeonFish's x value, y value,
     * and bounds, as well as defines its starting age, starting health, maxAge,
     * and image File.
     *
     * @param x the x point of this SurgeonFish
     * @param y the y point of this SurgeonFish
     * @param bounds the Rectangle that this SurgeonFish is bounded by
     */
    public SurgeonFish(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        this.age = 0;
        this.health = 50;
        this.maxAge = 200;
        this.img = new File("surgeonFish.png");
    }

    /**
     * Returns an ArrayList of new SurgeonFishs that comes from two SurgeonFishs
     * colliding.  SurgeonFish's have a 0.5% chance upon colliding to reproduce
     * and can have up to 5 babies at a time.
     *
     * @param f The Fish that this SurgeonFish will be reproducing with
     * @return An ArrayList of baby Fish to be created
     */
    public ArrayList<Fish> reproduceWithFish(Fish f) {
        Random generator = new Random();
        ArrayList<Fish> babies = new ArrayList<Fish>();
        double num = generator.nextDouble();
        if (num <= .005) {
            int num1 = generator.nextInt(6);
            for (int x = 0; x <= num1; x++) {
                babies.add(new SurgeonFish(this.x, this.y, this.bounds));
            }
        }
        return babies;
    }

    /**
     * Returns whether or not this SurgeonFish has the ability to
     * reproduce with a given Fish.
     *
     * @param f The Fish we are checking
     * @return true if this SurgeonFish can reproduce with the given Fish
     */
    public boolean canReproduceWithFish(Fish f) {
        return (f instanceof SurgeonFish);
    }

}
