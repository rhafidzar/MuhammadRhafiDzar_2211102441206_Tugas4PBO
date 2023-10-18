import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpecialObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialObject extends Actor {
    private GreenfootSound collectSound = new GreenfootSound("soundscollect.wav");

    public SpecialObject() {
        setImage("object.png");
    }

    public void act() {
        moveDown();
        checkForCollision();
        checkOutOfBounds();
    }

    public void moveDown() {
        setLocation(getX(), getY() + 1);
    }

    public void checkForCollision() {
        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null) {
            player.increaseScore();
            getWorld().removeObject(this);
            playCollectSound();
        } else if (getY()<=0) {
            getWorld().removeObject(this);
        }
    }

    public void checkOutOfBounds() {
        if (getY() >= getWorld().getHeight() - 1) {
            getWorld().removeObject(this);
        }
    }

    public void playCollectSound() {
            collectSound.play();
    }
}

