import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MC extends Actor
{
    GreenfootImage characterImage = new GreenfootImage("images/survivor.png");

    int mouseX, mouseY;
    public static int survivorLocationX, survivorLocationY;
    int frame = 1;
    // number of zombies left in this level.
    
    int bulletCount = 50;
    public int survivorRotation;
    
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
        Label bulletNumber = new Label("" + bulletCount, 50);
        survivorRotation = getRotation();
        mouseLocation();
        shoot(bulletNumber);
        
        survivorLocationX = getX();
        survivorLocationY = getY();
        
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
        getWorld().removeObject(bulletNumber);
    }

    public void shoot(Label x)
    {
        if(Greenfoot.getMouseInfo() != null)
        {
            if(Greenfoot.getMouseInfo().getButton() == 1)
            {
                getWorld().addObject(new Bullet(survivorRotation), getX(), getY());
                
                getWorld().addObject(x, 1100, 500);
                bulletCount = bulletCount-1;
            }
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

    public int getSurvivorX()
    {
        survivorLocationX = getX();
        return survivorLocationX;
    }

    public int getSurvivorY()
    {
        survivorLocationX = getY();
        return survivorLocationY;
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
