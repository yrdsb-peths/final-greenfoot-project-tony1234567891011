import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the EndGameScreen that appears when you die.
 * 
 * @author (Tony) 
 * @June 14, 2023
 */
public class EndGameScreen extends World
{
    Label gameOver = new Label("Game Over", 25);
    
    public static int retryCount = 0;
    int highestScoreMins = Zombie.highestScore/60000;
    int highestScoreSeconds = (Zombie.highestScore%60000)/1000;
    int highestScoreMilliseconds = (Zombie.highestScore%60000)%1000;
    
    Label highestScore = new Label("Longest Survived \nbefore Death: " + highestScoreMins + " minutes " + highestScoreSeconds + " seconds " + highestScoreMilliseconds + " milliseconds.",25);
    /**
     * This is the constructor for the images within the EndGameScreen(occurs when you die).
     * This constructor also contains the labels for the highestScore that is displayed on the screen(longest time that you survived for)
     */
    public EndGameScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage("images/background.jpg");
        setBackground(bg);
        addObject(gameOver, getWidth()/2, getHeight()/2);
        
        addObject(highestScore, getWidth()/2, getHeight()/2+50);
        bg.setTransparency(10);
    }
    /**
     * This method allows the world to display the highest time survived out of all deaths and the time survived before you died
     * This method also allows the player to continue their round by pressing key X
     * This method will also count how many times the player died(how many times they reached this screen.)
     */
    public void act()
    {
        if(TransitionWorld.count == 3)
        {
            int timeMins = (GameWorldLevel3.timeSurvived)/60000;
            int timeSeconds = (GameWorldLevel3.timeSurvived%60000)/1000;
            int timeMilliseconds = (GameWorldLevel3.timeSurvived%60000)%1000;  
            Label timeSurvived = new Label("Time Survived: "+ timeMins + " minutes \n" + timeSeconds + " seconds \n" + timeMilliseconds + " milliseconds.\n", 25);
            addObject(timeSurvived, getWidth()/2, getHeight()/2+150);
        }
        else if(TransitionWorld.count == 2)
        {
            int timeMins = (GameWorldLevel2.timeSurvived)/60000;
            int timeSeconds = (GameWorldLevel2.timeSurvived%60000)/1000;
            int timeMilliseconds = (GameWorldLevel2.timeSurvived%60000)%1000;  
            Label timeSurvived = new Label("Time Survived: "+ timeMins + " minutes \n" + timeSeconds + " seconds \n" + timeMilliseconds + " milliseconds.\n", 25);
            addObject(timeSurvived, getWidth()/2, getHeight()/2+150);
        }
        else if(TransitionWorld.count == 1)
        {
            int timeMins = (GameWorldLevel1.timeSurvived)/60000;
            int timeSeconds = (GameWorldLevel1.timeSurvived%60000)/1000;
            int timeMilliseconds = (GameWorldLevel1.timeSurvived%60000)%1000;  
            Label timeSurvived = new Label("Time Survived: "+ timeMins + " minutes \n" + timeSeconds + " seconds \n" + timeMilliseconds + " milliseconds.\n", 25);
            addObject(timeSurvived, getWidth()/2, getHeight()/2+150);
        }
        
        if(Greenfoot.isKeyDown("x"))
        {
            if(TransitionWorld.count == 2)
            {
                retryCount++;
                Greenfoot.setWorld(new GameWorldLevel2());
            }
            else if(TransitionWorld.count == 1)
            {
                retryCount++;
                Greenfoot.setWorld(new GameWorldLevel1());
            }
            else if(TransitionWorld.count == 3)
            {
                retryCount++;
                Greenfoot.setWorld(new GameWorldLevel3());
            }
        }
    }
}
