import java.awt.Rectangle;

/**
 * This class is the parent class of all Herbivore Objects.  Herbivores extend
 * Fish and can eat seaweed to replenish their health when it gets too low.
 *
 * @author Carey MacDonald
 * @version 1.0
 */
public abstract class Herbivore extends Fish {

    /**
     * Constructor for Herbivore.  Sets the Herbivore's x value, y value, and
     * bounds.
     *
     * @param x the x point of this Herbivore
     * @param y the y point of this Herbivore
     * @param bounds the Rectangle that this Herbivore is bounded by
     */
    public Herbivore(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }

    /**
     * When Herbivores get below 20 health, they will eat seaweed to have their
     * health be regenerated to the full 50 points.
     */
    public void eatSeaweed() {
        if (this.getHealth() <= 20) {
            setHealth(50);
        }
    }
}
