import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ZombieImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZombieImage extends Zombie
{
    /**
     * Act - do whatever the ZombieImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ZombieImage()
    {
        GreenfootImage zombieImage = new GreenfootImage("zombie_animation/zombie0.png");
        zombieImage.scale(zombieImage.getWidth()*35/100, zombieImage.getHeight()*35/100);
        setImage(zombieImage);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
