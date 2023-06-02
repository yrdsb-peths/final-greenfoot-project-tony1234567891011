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
    Label rule1 = new Label("- Movement:\n Pawns can move 1 tile up.\n Bishop can move diagonally, up to 8 tiles.\nKing can move 1 tile in any direction \nQueen can move in any direction, up to 8 tiles.\nRook can move vertically and horizontally.",25);
    Label rule2 = new Label("- When a piece is in vision/targetting of the King, \nyou must move the King.",25);
    Label rule3 = new Label("- Checkmate:\n When your King cannot legally move in any squares\nwithout the vision of enemy pieces, you lose.\n When you checkmate the opponent King, you win.", 25);
    int textSpacing = 75;
    Label proceed = new Label("Press <  space  > to continue to game",25);
    /**
     * Constructor for objects of class InstructionWorld.
     * 
     */
    public InstructionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(600, 400, 1);
        GreenfootImage bg = new GreenfootImage("instructionScreenBg.jpg");
        setBackground(bg);
        bg.setTransparency(10);
        bg.scale(bg.getWidth()*25/100, bg.getHeight()*25/100);
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
        if(Greenfoot.isKeyDown("space"))
        {
            ChessBoard gameworld = new ChessBoard();
            Greenfoot.setWorld(gameworld);
        }
    }
}
