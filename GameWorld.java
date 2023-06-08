import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    //GreenfootImage bg = new GreenfootImage("map.jpg");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200,600,1,false);
        /*
        int height = bg.getHeight();
        int resizedHeight = (int)(height*1.5);
        bg.scale(bg.getWidth()*2, resizedHeight);
        setBackground(bg);
        */
        MC character = new MC();
        Zombie enemy = new Zombie();
        addObject(character, getWidth()/2, getHeight()/2);
        addObject(enemy, 0,300);
    }
    public void act()
    {
        
    }
}
