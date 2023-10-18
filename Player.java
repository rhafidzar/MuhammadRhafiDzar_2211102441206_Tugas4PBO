import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int score = 0;
    private int speed = 3;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player() {
        setImage("player.png");
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speed);
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed, getY());
        }
        checkForCollision();
        checkGameOver();
    }
    
    public void checkForCollision() {
        Actor object = getOneIntersectingObject(SpecialObject.class);
        if (object != null) {
            increaseScore();
            getWorld().removeObject(object);
        }
    }
    
    public void increaseScore() {
        score += 10;
        getWorld().showText("Score: " + score, 50, 25);
    }
    
    public void checkGameOver() {
        if (score >= 100) {
            getWorld().showText("Game Over - You Win!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Greenfoot.stop();
        }
        
        else if (getWorld().getObjects(Player.class).isEmpty()) {
            getWorld().showText ("Game Over - You Lose!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Greenfoot.stop();
        }
    }
}


