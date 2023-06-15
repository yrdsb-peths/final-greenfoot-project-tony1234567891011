import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the titlescreen, where the type of game is introduced to you.
 * 
 * @Tony Lin 
 * @June 14, 2023
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Survival game",50);
    /**
     * This constructor is for the titlescreen.
     * The type of game is displayed, "Survival Game" in the centre.
     * A label is included to help players continue to the instructions screen.
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
     * This method sets the label that helps the player continue to the instructions screen on how to play.
     */
    private void prepare()
    {
        
        Label label = new Label("Press <Space> to continue", 40);
        Color fontColor = Color.BLACK;
        label.setLineColor(fontColor);
        addObject(label,306,273);
    }
    /**
     * This method sets the player to the instructions screen after pressing the space bar.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            InstructionWorld instructions = new InstructionWorld();
            Greenfoot.setWorld(instructions);
        }
    }
}
