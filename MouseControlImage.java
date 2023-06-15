import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This greenfoot image tells the player in the instructions world what each mouse button is, and shows indication which button is which.
 * 
 * @Tony Lin 
 * @June 14, 2023
 */
public class MouseControlImage extends MC
{
    /**
     * This constructor is for the mouse control section of the instructions world.
     * The constructor also resizes the oversized image.
     */
    public MouseControlImage()
    {
        GreenfootImage y = new GreenfootImage("th.jpg");
        y.scale(y.getWidth()*25/100, y.getHeight()*25/100);
        setImage(y);
    }
    public void act()
    {
        // Add your action code here.
    }
}
