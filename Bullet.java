import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    int speed = 10; // bullet speed
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Bullet(int rotation)
    {
        GreenfootImage bulletImage = new GreenfootImage("images/bullet.png");
        setImage(bulletImage);
        bulletImage.scale(bulletImage.getWidth()*50/100, bulletImage.getHeight()*50/100);
        setRotation(rotation);
    }
    public void act()
    {
        // Add your action code here.
        move(speed);
        removeOffScreen();
    }
    public void removeOffScreen() // removes buillet of screen when
    // it leaves the world or touches the boundary
    {
        if(getX() >= getWorld().getWidth()-1)
        {
            getWorld().removeObject(this);
        }
        else if(getX() < 1)
        {
            getWorld().removeObject(this);
        }
        else if(getY() >= getWorld().getHeight()-1)
        {
            getWorld().removeObject(this);
        }
        else if(getY()<1)
        {
            getWorld().removeObject(this);
        }
    }
}
