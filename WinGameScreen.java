import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the screen that displays the results and the achievement you earned based off your score after beating level 3.
 * 
 * @Tony Lin
 * @June 14, 2023
 */
public class WinGameScreen extends World
{
    GreenfootImage lost = new GreenfootImage("R.png");
    GreenfootImage reward1 = new GreenfootImage("image.png");
    GreenfootImage reward2 = new GreenfootImage("wp1875926.jpg");
    int highestScoreMins = Zombie.highestScore/60000;
    int highestScoreSeconds = (Zombie.highestScore%60000)/1000;
    int highestScoreMilliseconds = (Zombie.highestScore%60000)%1000;
    Label tips = new Label("*Tips: " + "\n stall out and allow more zombies to spawn more to gain more score.", 20);
    Label tips2 = new Label("Tips: \n try staying in \nthe center so \n you can get the\nmost amount of points.", 30);
    int finalScore = GameWorldLevel3.wave3Score - 500*Zombie.deathCount;
    /**
     * This is the constructor for the game winning screen.
     * It creates a world 600x400.
     */
    public WinGameScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        
    }
    /**
     * This method sets the images corresponding to the final score after difficulty 3(beating difficulty 3 completes the game.)
     * This method displays the current score you have, and the longest time you survived for. 
     * If you did not score higher then 1000, it displays the image and includes a label to help you get a higher score.
     * If you scored higher but less then 3000, it displays the corresponding image and another label as a tip to get a higher score.
     * If you scored 3000+, it displays the corresponding image that you won the highest of honor.
     * This method also allows the ability to continue back to level 1 immediately by pressing Key X on the keyboard.
     */
    public void act()
    {
        if(finalScore< 1000)
        {
            lost.scale(getWidth(), getHeight());
            lost.setTransparency(10);
            setBackground(lost);
            showText("Unfortunate loss", getWidth()/2, 25);
            showText("Score Reached: " + finalScore, getWidth()/5, 210);
            showText("Longest time survived before dying:" + highestScoreMins + " min,\n" + highestScoreSeconds + " seconds, \n" + highestScoreMilliseconds + " milliseconds.", getWidth()/2, getHeight()*4/5+35);
            Label label = new Label("git gud, *Minimize your deaths!", 50);
            addObject(label,300,80);
            addObject(tips2,451,174);
        }
        else if(finalScore > 1000 && finalScore< 3000)
        {
            showText("You Win! \n Click Reset to play again~!", getWidth()/2, 25);
            showText("Score Reached: " + finalScore, getWidth()/4-10, 200);
            showText("Longest time survived before dying: " + highestScoreMins + " min,\n" + highestScoreSeconds + " seconds, \n" + highestScoreMilliseconds + " milliseconds.", getWidth()/2, getHeight()*4/5-15);
            Label label = new Label("Unfortunate git gud", 50);
            reward1.scale(getWidth()*120/100, getHeight()*115/100);
            reward1.setTransparency(10);
            setBackground(reward1);
            Label title = new Label("Here is a", 50);
            addObject(title,273,146);
            addObject(tips,getWidth()/2,370);
        }
        else if(finalScore>3000)
        {
            reward2.scale(getWidth()*120/100, getHeight());
            reward2.setTransparency(10);
            setBackground(reward2);
            Label label = new Label("Congrats your a winner!", 50);
            addObject(label,290,89);
            Label label2 = new Label("Thanks for playing!", 35);
            addObject(label2,451,172);
        }
        if(Greenfoot.isKeyDown("x"))
        {
            Greenfoot.setWorld(new TransitionWorld());
        }
    }
}
