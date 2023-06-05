import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Shooters game",50);
    
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        GreenfootImage bg = new GreenfootImage("images/bathroom-tile.jpg");
        bg.scale(bg.getWidth()*15/100, bg.getHeight()*15/100);
        setBackground(bg);
        
        Color fontColor = Color.BLACK;
        titleLabel.setFillColor(fontColor);
        addObject(titleLabel, getWidth()/2, getHeight()/2);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
        Label label = new Label("Press <Space> to continue", 40);
        Color fontColor = Color.BLACK;
        label.setLineColor(fontColor);
        addObject(label,306,273);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            InstructionWorld instructions = new InstructionWorld();
            Greenfoot.setWorld(instructions);
        }
        
    }
}
