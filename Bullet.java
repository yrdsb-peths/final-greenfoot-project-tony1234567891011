import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the Bullet class that the MC shoots at the zombies.
 * 
 * @Tony Lin
 * @June 14, 2023
 */
public class Bullet extends Actor
{
    int speed; // bullet speed
    /**
     * This constructor creates the image of the bullet and resizes it appropriately.
     * This constructor sets the speed of the bullet
     * It also takes in 1 parameter, which is the rotation from 0 degrees of the MC is turning at
     */
    public Bullet(int rotation)
    {   
        GreenfootImage bulletImage = new GreenfootImage("images/bullet.png");
        setImage(bulletImage);
        speed = 50;
        bulletImage.scale(bulletImage.getWidth()*50/100, bulletImage.getHeight()*50/100);
        setRotation(rotation);
    }
    /**
     * This method allows the bullet to move across the screen
     * It uses the method 'removeOffScreen' to remove the bullet when it collides with the borders.
     */
    public void act()
    {
        // Add your action code here.
        move(speed);
        removeOffScreen();
    }
    public void removeOffScreen()
    /**
     * This method is responsible for removing the bullet that is fired off the screen when it hits the walls of the world.
     * It gets the position of the bullet, and checks if its above or below the world in both X and Y direction.
     */
    // removes bullet of screen when
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
