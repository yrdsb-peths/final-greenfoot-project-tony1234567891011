import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionWorld extends World
{
    Label title = new Label("Rules:",50);
    Label rule1 = new Label("- Movement:WASD for Up, Left, Down, Right respectively.",25);
    Label rule2 = new Label("Press LEFT MOUSE Click to shoot the enemies in front of you.",25);
    Label rule3 = new Label("-Kill your foes without dying as much as possible.\n Each death loses score.", 25);
    int textSpacing = 75;
    Label proceed = new Label("Press <  the key X  > to start playing the game.",25);
    /**
     * Constructor for objects of class InstructionWorld.
     * 
     */
    public InstructionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(600, 400, 1);
        ZombieImage image = new ZombieImage();
        
        addObject(image, 450,335);
        
        KeyboardControlImage keyImage = new KeyboardControlImage();
        addObject(keyImage,250,170);
        MouseControlImage mouseImage = new MouseControlImage();
        addObject(mouseImage, 250, 255);
        Color outline = Color.WHITE;
        outline = outline.darker();
        Color firstRule = Color.GREEN;
        Color secondRule = Color.YELLOW;
        Color thirdRule = Color.RED;
        addObject(title, getWidth()/5,getHeight()/10);
        
        addObject(rule1, getWidth()/2, getHeight()/10 + textSpacing);
        rule1.setFillColor(firstRule);
        rule1.setLineColor(outline);
        addObject(rule2, getWidth()/2, getHeight()/10 + textSpacing*2 + (int)(textSpacing/2));
        rule2.setFillColor(secondRule);
        rule2.setLineColor(outline);
        addObject(rule3, getWidth()/2, getHeight()/10 + (textSpacing*2+(int)(textSpacing/2))+textSpacing);
        rule3.setFillColor(thirdRule);
        rule3.setLineColor(outline);
        addObject(proceed, getWidth()/2, getHeight()-10);
        proceed.setFillColor(Color.YELLOW);
        proceed.setLineColor(Color.BLACK);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("x"))
        {
            TransitionWorld gameworld = new TransitionWorld();
            Greenfoot.setWorld(gameworld);
        }
    }
}
