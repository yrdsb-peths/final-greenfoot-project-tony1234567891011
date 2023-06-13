import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class transition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TransitionWorld extends World
{

    /**
     * Constructor for objects of class transition.
     * 
     */
    public TransitionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    public void act()
    {
        Label title = new Label("Level" + MC.level, 25);
        addObject(title, getWidth()/2, getHeight()/2);
        GameWorldLevel1 gameworld = new GameWorldLevel1();
        setWorld(gameworld);
    }
}
