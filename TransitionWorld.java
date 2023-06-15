import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class transition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TransitionWorld extends World
{
    SimpleTimer delayTimer = new SimpleTimer();
    public static int count = 0;
    int oldRetryCount = 0;
    /**
     * Constructor for objects of class transition.
     * 
     */
    public TransitionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        delayTimer.mark();
        
        
        Label title = new Label("New Wave " + ", \nGood luck ", 100);
        addObject(title, getWidth()/2, getHeight()/2);
        title.setFillColor(Color.RED);
        
    }
    
    public void act()
    {
        if(delayTimer.millisElapsed()>2000)
        {
            if(count == 0)
            {
                count = 1;
            }
            else if(count == 1)
            {
                count = 2;
            }
            else if(count == 2)
            {
                count = 3;
            }
            else if(count == 3)
            {
                count = 1;
            }
            if(count == 1)
            {
                Greenfoot.setWorld(new GameWorldLevel1());
            }
            else if(count == 2)
            {
                Greenfoot.setWorld(new GameWorldLevel2());
            }
            else if(count == 3)
            {
                Greenfoot.setWorld(new GameWorldLevel3());
            }
        }
        
    }
}
