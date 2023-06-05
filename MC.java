import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MC extends Actor
{
    GreenfootImage characterImage = new GreenfootImage("112769.png");
    
    int mouseX, mouseY;
    int frame = 1;
    /**
     * Act - do whatever the MC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MC()
    {
        characterImage.scale(characterImage.getWidth()*25/100, characterImage.getHeight()*25/100);
        
    }
    public void act()
    {
        // Add your action code here.
        setImage(characterImage);
        
        mouseLocation();
        
        if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY()-10);
        }
        else if(Greenfoot.isKeyDown("s")) 
        {
            super.setLocation(getX(), getY()+10);
            
        }
        else if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX()-10, getY());
            
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            setLocation(getX()+10, getY());
        }
    }
    public void mouseLocation() // makes character face the mouse location.
    {
        if(Greenfoot.getMouseInfo() != null)
        {
            mouseX = Greenfoot.getMouseInfo().getX();
            mouseY = Greenfoot.getMouseInfo().getY();
            turnTowards(mouseX,mouseY);
        
            
        }
    }
    public void animate()
    {
        if(frame == 1)
        {
            frame++;
            
        }
        else if(frame ==2)
        {
            frame--;
        }
    }
}
