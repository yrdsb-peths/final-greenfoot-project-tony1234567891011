import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class for the main character that is controlled by the player.
 * 
 * @Tony Lin
 * @June 14, 2023
 */
public class MC extends Actor
{
    GreenfootImage characterImage = new GreenfootImage("images/survivor.png");

    int mouseX, mouseY;
    public static int survivorLocationX, survivorLocationY;
    // number of zombies left in this level.
    
    int bulletCount = 50;
    public int survivorRotation;
    
    /**
     * This constructor creates the Image of the survivor/main character, facing right as default.
     */
    public MC()
    {
        characterImage.scale(characterImage.getWidth()*25/100, characterImage.getHeight()*25/100);
    }
    /**
     * This method is responsible for setting the image each time it is run.
     * It gets the degree of rotation of the survivor at all times in order for the bullet to shoot in the correct angle.
     * the angle of rotation is recieved after the main character turns towards the mouse.
     * It recieves the coordinates of the MC at all times and is responsible for the ability to move in all directions
     */
    public void act()
    {
        // Add your action code here.
        setImage(characterImage);
        mouseLocation();
        survivorRotation = getRotation();
        shoot();
        
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
    }
    /**
     * This method allows the main character to shoot by clicking on left mouse button.
     * It creates a new bullet object every time the left mouse click is executed.
     */
    public void shoot()
    {
        if(Greenfoot.getMouseInfo() != null)
        {
            if(Greenfoot.getMouseInfo().getButton() == 1)
            {
                getWorld().addObject(new Bullet(survivorRotation), getX(), getY());
            }
        }
    }
    /**
     * This method is repsonsible for the MC turning in the location of the cursor
     * This method also checks if the cursor is within the world so it can turn towards it
     */
    public void mouseLocation() // makes character face the mouse location.
    {
        if(Greenfoot.getMouseInfo() != null)
        {
            mouseX = Greenfoot.getMouseInfo().getX();
            mouseY = Greenfoot.getMouseInfo().getY();
            turnTowards(mouseX,mouseY);

        }
    }

    /**
     * These methods are getter methods- responsible for getting the location of the survivor/MC.
     */
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
}
