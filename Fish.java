import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * This class is the parent class of all Fish Objects.  Each Fish has a health,
 * age, maxAge, x point value, y point value, bounding Rectangle, img image
 * File, and a backing Rectangle
 *
 * @author Carey MacDonald
 * @version 1.0
 */
public abstract class Fish {
    protected int health;
    protected int age;
    protected int maxAge;
    protected int x;
    protected int y;
    protected Rectangle bounds;
    protected File img;
    protected Rectangle rec;

    /**
     * Constructor for Fish.  Sets the Fish's x value, y value, and bounds, as
     * well as defines its backing Rectangle.
     *
     * @param x the x point of this Fish
     * @param y the y point of this Fish
     * @param bounds the Rectangle that this Fish is bounded by
     */
    public Fish(int x, int y, Rectangle bounds) {
        this.x = x;
        this.y = y;
        this.bounds = bounds;
        this.rec = new Rectangle(x, y, 75, 75);
    }

    /**
     * Returns the current health of this Fish.
     *
     * @return this Fish's current health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets this Fish's health to a given value.
     *
     * @param health the new health we want this Fish to have
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Returns the current age of this Fish.
     *
     * @return this Fish's current age
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the maximum age of this Fish.
     *
     * @return this Fish's maxAge
     */
    public int getMaxAge() {
        return maxAge;
    }

    /**
     * Increments the age of this Fish by one.
     */
    public void incrementAge() {
        age++;
    }

    /**
     * Returns the Rectangle backing up the current Fish.
     *
     * @return this Fish's backing Rectangle
     */
    public Rectangle getRec() {
        return rec;
    }

    /**
     * Returns the x point of this Fish.
     *
     * @return this Fish's x point value
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y point of this Fish.
     *
     * @return this Fish's y point value
     */
    public int getY() {
        return y;
    }

    /**
     * Moves this Fish to a new semi-random, semi-adjacent spot in the Ocean.
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
        if (x >= 525) {
            x = 525;
        } else if (x <= 0) {
            x = 0;
        }
        if (y >= 525) {
            y = 525;
        } else if (y <= 0) {
            y = 0;
        }
        rec.setLocation(x, y);
    }

    /**
     * Draws the image of this Fish on the given Graphics Object.
     *
     * @param g The Graphics object we are to draw our Fish on
     */
    public void draw(Graphics g) {
        BufferedImage b = null;
        try {
            b = ImageIO.read(this.img);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(b, x, y, null);
    }

    /**
     * Returns a boolean that says whether or not this Fish and the given Fish
     * have collided, or are currently overlapping.
     *
     * @param other The Fish we want to see if this Fish is colliding with
     * @return true if this Fish has collided with the given Fish
     */
    public boolean collidesWithFish(Fish other) {
        return getRec().intersects(other.getRec());
    }

    /**
     * Returns an ArrayList of new Fish that comes from two Fish
     * colliding.  The amount and type of Fish in the ArrayList depends on
     * the implementation of it in the subclasses.
     *
     * @param f The Fish that this Fish will be reproducing with
     * @return An ArrayList of baby Fish to be created
     */
    public abstract ArrayList<Fish> reproduceWithFish(Fish f);

    /**
     * Returns whether or not this Fish has the ability to
     * reproduce with a given Fish.
     *
     * @param f The Fish we are checking
     * @return true if this Fish can reproduce with the given Fish
     */
    public abstract boolean canReproduceWithFish(Fish f);

}
