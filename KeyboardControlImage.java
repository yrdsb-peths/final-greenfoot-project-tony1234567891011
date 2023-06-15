import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the greenfoot image of the keyboard W A S D keys displayed on the screen in the instructions world.
 * 
 * @Tony Lin
 * @June 14, 2023
 */
public class KeyboardControlImage extends MC
{
    /**
     * This constructor sets the greenfoot image for this subclass
     * It scales it as necessary, as it is an oversized image.
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
