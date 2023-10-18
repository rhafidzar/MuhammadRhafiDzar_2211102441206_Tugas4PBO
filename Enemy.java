import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor {
    private int speed = 2;

    public Enemy() {
        GreenfootImage EnemyImage = new GreenfootImage("enemy.png");
        EnemyImage.scale(50, 50);
        setImage(EnemyImage); // Perbaikan di sini, seharusnya setImage(EnemyImage)
    }

    public void act() {
        Actor player = getWorld().getObjects(Player.class).get(0);

        if (player != null) {
            int playerX = player.getX();
            int playerY = player.getY();
            int deltaX = playerX - getX();
            int deltaY = playerY - getY();
            int angle = (int) Math.toDegrees(Math.atan2(deltaY, deltaX));
            setRotation(angle);
            int dx = (int) (Math.cos(Math.toRadians(angle)) * speed);
            int dy = (int) (Math.sin(Math.toRadians(angle)) * speed);
            setLocation(getX() + dx, getY() + dy);

            if (isTouching(Player.class)) {
                getWorld().showText("Game Over You Lose!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                Greenfoot.stop(); // Hentikan permainan ketika Enemy menyentuh Player
            }
        }
    }
}
