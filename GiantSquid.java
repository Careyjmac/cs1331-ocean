import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;

/**
 * GiantSquid is a Carnivore/Fish that can eat any other Fish but cannot
 * reproduce.  It lives to be a max of 1000 cycles and has a starting health of
 * 300 points.
 *
 * @author Carey MacDonald
 * @version 1.0
 */
public class GiantSquid extends Carnivore {

    /**
     * Constructor for GiantSquid.  Sets the GiantSquid's x value, y value, and
     * bounds, as well as defines its starting age, starting health, maxAge,
     * and image File.
     *
     * @param x the x point of this GiantSquid
     * @param y the y point of this GiantSquid
     * @param bounds the Rectangle that this GiantSquid is bounded by
     */
    public GiantSquid(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        this.age = 0;
        this.health = 300;
        this.maxAge = 1000;
        this.img = new File("giantSquid.png");
        this.rec.setSize(67, 75);
    }

    /**
     * Returns a boolean that says whether or not this GiantSquid can eat the
     * given Fish (which is always, unless the other Fish is also a GiantSquid).
     *
     * @param f The Fish we want to see if this GiantSquid can eat or not
     * @return true if this GiantSquid can eat the given Fish
     */
    public boolean canEatFish(Fish f) {
        if (f instanceof GiantSquid) { return false; }
        return true;
    }

    /**
     * Returns null because a GiantSquid cannot reproduce.
     *
     * @param f The Fish that this GiantSquid would be reproducing with
     * @return An ArrayList of baby Fish to be created (or in this case null)
     */
    public ArrayList<Fish> reproduceWithFish(Fish f) {
        return null;
    }

    /**
     * Returns whether or not this GiantSquid has the ability to
     * reproduce with a given Fish.  Will always return false since a
     * GiantSquid cannot reproduce.
     *
     * @param f The Fish we are checking
     * @return false since GiantSquid's cannot reproduce
     */
    public boolean canReproduceWithFish(Fish f) {
        return false;
    }

}
