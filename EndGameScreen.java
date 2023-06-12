import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class endGameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGameScreen extends World
{
    Label gameOver = new Label("Game Over", 25);
    int timeMins = (GameWorld.timeSurvived)/60000;
    int timeSeconds = (GameWorld.timeSurvived%60000)/1000;
    int timeMilliseconds = (GameWorld.timeSurvived%60000)%1000;
    Label timeSurvived = new Label("Time Survived: "+ timeMins + " minutes " + timeSeconds + " seconds " + timeMilliseconds + " milliseconds.", 25);
    /**
     * Constructor for objects of class endGameScreen.
     * 
     */
    public EndGameScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage("images/background.jpg");
        setBackground(bg);
        addObject(gameOver, getWidth()/2, getHeight()/2);
        addObject(timeSurvived, getWidth()/2, getHeight()/2+100);
        bg.setTransparency(10);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("x"))
        {
            GameWorld retry = new GameWorld();
            Greenfoot.setWorld(retry);
        }
    }
}
