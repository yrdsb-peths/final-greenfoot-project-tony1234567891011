import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MouseControlImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MouseControlImage extends MC
{
    /**
     * Act - do whatever the MouseControlImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MouseControlImage()
    {
        GreenfootImage y = new GreenfootImage("th.jpg");
        y.scale(y.getWidth()*25/100, y.getHeight()*25/100);
        //y.setTransparency(50);
        setImage(y);
    }
    public void act()
    {
        // Add your action code here.
    }
}
