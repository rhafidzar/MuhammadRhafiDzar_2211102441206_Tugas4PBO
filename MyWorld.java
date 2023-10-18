import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int SpecialObjectDelay = 50;
    private int SpecialObjectCounter = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(600, 400, 1);
        prepare();
    }
    
    public void act() {
        if (SpecialObjectCounter >= SpecialObjectDelay) {
            spawnSpecialObject();
            SpecialObjectCounter = 0;
        } else {
            SpecialObjectCounter++;
        }
    }
    
    public void prepare() {
        addObject(new Player(), getWidth() / 2, getHeight() - 200);
        addObject(new Enemy(), getWidth() / 2, getHeight() - 100);
        addObject(new SpecialObject(),
        Greenfoot.getRandomNumber(getWidth()),
        Greenfoot.getRandomNumber(getHeight()));
    }
    
    private void nextLevel() {
        
    }
    
    private void spawnSpecialObject() {
        Random random = new Random();
        int x = random.nextInt(getWidth());
        int y = 0;
        SpecialObject specialobject = new SpecialObject();
        addObject(specialobject, x, y);
    }
}
