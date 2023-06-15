import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the world that helps players prepare for the next difficulty.
 * 
 * @Tony Lin 
 * @June 14, 2023
 */
public class TransitionWorld extends World
{
    SimpleTimer delayTimer = new SimpleTimer();
    public static int count = 0;
    /**
     * This is the constructor for the world in between the completion of each level.
     * It displays labels to warn them they are moving to the next difficulty. 
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
    /**
     * This method allows the players to continue to the next level chronologically. (ex level 1-> 2, level 2 -> 3)
     * This method includes a timer to allow players to prepare.
     * This method also utilizes a variable that keeps track of the current world/difficulty level and that is accessible from the other actors and methods in order to create functionality.
     */
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
