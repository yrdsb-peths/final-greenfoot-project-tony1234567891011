import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the greenfoot image for the zombie in the instructions screen.
 * 
 * @Tony Lin 
 * @June 14, 2023
 */
public class ZombieImage extends Zombie
{
    /**
     * This constructor is for the greenfoot image of the zombie and sets it to the actor.
     * It also resizes the image as it is an oversized image.
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
