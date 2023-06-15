import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KeyboardControlImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyboardControlImage extends MC
{
    /**
     * Act - do whatever the KeyboardControlImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public KeyboardControlImage()
    {
        GreenfootImage x = new GreenfootImage("keyboardcontrol.jpg");
        x.scale(x.getWidth()*25/100, x.getHeight()*25/100);
        x.setTransparency(50);
        setImage(x);
    }
    public void act()
    {
        // Add your action code here.
    }
}
