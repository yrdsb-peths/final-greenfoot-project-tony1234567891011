import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessBoard extends World
{
    boolean onColoredSquare = false;
    int tileLength = 100;
    GreenfootImage boardImage = new GreenfootImage("images/board.jpg");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public ChessBoard()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800,800,1);
        setBackground(boardImage);
        for(int y = 1; y<=8; y++)
        {
            
            for(int x=0; x<8; x++)
            {
                
            }
        }
    }
    public void act()
    {
        
    }
}
