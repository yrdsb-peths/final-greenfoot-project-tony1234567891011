import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    GreenfootImage animationRight[] = new GreenfootImage[8];
    String defaultFacing = "right";
    int animationCounter = 0;
    int speed = 20;
    GreenfootImage animationLeft[] = new GreenfootImage[8];
    /**
     * Act - do whatever the enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Zombie()
    {
        for(int i = 0; i<animationRight.length; i++)
        {
            animationRight[i] = new GreenfootImage("images/zombie_animation/zombie" + (i) + ".png");
            animationRight[i].scale(animationRight[i].getWidth()*50/100, animationRight[i].getHeight()*50/100);
        }
        for(int i = 0; i<animationLeft.length; i++)
        {
            animationLeft[i] = new GreenfootImage("images/zombie_animation/zombie" + (i) + ".png");
            animationLeft[i].mirrorHorizontally();
            animationLeft[i].scale(animationLeft[i].getWidth()*50/100, animationLeft[i].getHeight()*50/100);
        }
        setImage(animationRight[0]);
    }
    public void act()
    {
        if(animationCounter%speed==0)
        {
            animate();
        }
        animationCounter++;
    }
    int index = 0;
    public void animate()
    {
        if(defaultFacing.equals("right"))
        {
            setImage(animationRight[index]);
            index = (index+1)%(animationRight.length);
        }
        else
        {
            setImage(animationLeft[index]);
            index = (index+1)%(animationRight.length);
        }
    }
}
