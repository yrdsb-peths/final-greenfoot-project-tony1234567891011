import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class indicatorRange here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IndicatorRange extends Actor
{
    SimpleTimer remove = new SimpleTimer();
    /**
     * Act - do whatever the indicatorRange wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public IndicatorRange()
    {
        GreenfootImage indicatorImage = new GreenfootImage("images/indicator.jpg");
        setImage(indicatorImage);
        indicatorImage.scale(indicatorImage.getWidth()*150/100, indicatorImage.getHeight()*150/100);
        indicatorImage.setTransparency(0);
        remove.mark();
    }
    public void act()
    {
        setLocation(MC.survivorLocationX, MC.survivorLocationY);
        /*
        if(remove.millisElapsed() > 200)
        {
            getWorld().removeObject(this);
            remove.mark();
        }
        
        if(remove.millisElapsed()>100)
        {
            getWorld().addObject(new IndicatorRange(),MC.survivorLocationX, MC.survivorLocationY);
            
        }*/
    }
}
