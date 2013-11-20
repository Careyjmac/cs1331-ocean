import java.awt.Rectangle;

/**
 * This class is the parent class of all Carnivore Objects.  Carnivores extend
 * Fish and can eat other Fish.
 *
 * @author Carey MacDonald
 * @version 1.0
 */
public abstract class Carnivore extends Fish {

    /**
     * Constructor for Carnivore.  Sets the Carnivore's x value, y value, and
     * bounds
     *
     * @param x the x point of this Carnivore
     * @param y the y point of this Carnivore
     * @param bounds the Rectangle that this Carnivore is bounded by
     */
    public Carnivore(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }

    /**
     * Has this Carnivore eat the given Fish, setting that Fish's health to 0
     * and increasing the health of the Carnivore by the health of the Fish
     * that it ate.
     *
     * @param f The Fish to be eaten
     */
    public void eatFish(Fish f) {
        setHealth(getHealth() + f.getHealth());
        f.setHealth(0);
    }

    /**
     * Returns a boolean that says whether or not this Carnivore can eat the
     * given Fish
     *
     * @param f The Fish we want to see if this Carnivore can eat or not
     * @return true if this Carnivore can eat the given Fish
     */
    public abstract boolean canEatFish(Fish f);
}
