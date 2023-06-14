import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    GreenfootImage animationRight[] = new GreenfootImage[8];
    String defaultFacing = "right";
    public int score[] = new int[10];
    public static int highestScore = 0;
    public static int waveCount = 2;
    public static int zombieX;
    public static int zombieY;
    int animationCounter = 0;
    int animationSpeed = 20;
    int mvtSpd = 3;
    //200 ms is the default time for the first spawn, will go down.
    GreenfootImage animationLeft[] = new GreenfootImage[8];
    /**
     * Act - do whatever the enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Zombie()
    {
        if(TransitionWorld.count == 1)
        {
            mvtSpd = 3;
        }
        else if(TransitionWorld.count == 2)
        {
            mvtSpd = 10;
        }
        else if(TransitionWorld.count == 3)
        {
            mvtSpd = 15;
        }
        for(int i = 0; i<animationRight.length; i++)
        {
            animationRight[i] = new GreenfootImage("images/zombie_animation/zombie" + (i) + ".png");
            animationRight[i].setTransparency(150);
            animationRight[i].scale(animationRight[i].getWidth()*50/100, animationRight[i].getHeight()*50/100);
        }
        for(int i = 0; i<animationLeft.length; i++)
        {
            animationLeft[i] = new GreenfootImage("images/zombie_animation/zombie" + (i) + ".png");
            animationLeft[i].mirrorHorizontally();
            animationLeft[i].setTransparency(150);
            animationLeft[i].scale(animationLeft[i].getWidth()*50/100, animationLeft[i].getHeight()*50/100);
        }
        setImage(animationRight[0]);
    }
    public void act()
    {
        if(animationCounter%animationSpeed==0) // puts a delay on each frame, so the animmation does not play too fast.
        {
            animate();
        }
        animationCounter++;
        zombieX = getX();
        zombieY = getY();
        chaseSurvivor();
        if(isTouching(MC.class))
        {
            removeTouching(MC.class);
            if(EndGameScreen.retryCount == 10) // resets array when it is full
            // retains highest score, however resets all other values back to 0 so its a infinite array
            {
                for(int i = 0; i<score.length; i++) // iterates through the elements of the array.
                {
                    if(i==0)
                    {
                        score[i] = highestScore;
                    }
                    else
                    {
                        score[i] = 0;
                    }
                }
            }
            if(TransitionWorld.count == 1)
            {
                score[EndGameScreen.retryCount%10] = GameWorldLevel1.timeSurvived;
            }
            else if(TransitionWorld.count == 2)
            {
                score[EndGameScreen.retryCount%10] = GameWorldLevel2.timeSurvived;
            }
            else if(TransitionWorld.count == 3)
            {
                score[EndGameScreen.retryCount%10] = GameWorldLevel3.timeSurvived;
            }
            
            
            for(int i = 0; i<score.length; i++)
            {
                if(highestScore<score[i])
                { 
                    highestScore = score[i];
                    for(int j = 0; j<score.length; j++) // resets the array so that you can infinitely have a new high score.
                    {
                        score[j] = 0;
                    }
                }
            }
            EndGameScreen endgame = new EndGameScreen();
            Greenfoot.setWorld(endgame);
        }
        else if((MC.survivorLocationX>1200 ||MC.survivorLocationX<0) || (MC.survivorLocationY<0 || MC.survivorLocationY>600))
        //end game if you touch the boundaries
        {
            removeTouching(MC.class);
            if(EndGameScreen.retryCount%10 == 0) // resets array when it is full
            // retains highest score, however resets all other values back to 0 so its a infinite array
            {
                for(int i = 0; i<score.length; i++)
                {
                    if(i==0)
                    {
                        score[i] = highestScore;
                    }
                    else
                    {
                        score[i] = 0;
                    }
                }
            }
            score[EndGameScreen.retryCount%10] = GameWorldLevel1.timeSurvived;
            
            for(int i = 0; i<score.length; i++)
            {
                if(highestScore<score[i])
                {
                    highestScore = score[i];
                    for(int j = 0; j<score.length; j++) // resets the array so that you can infinitely have a new high score.
                    {
                        score[j] = 0;
                    }
                }
            }
            EndGameScreen endgame = new EndGameScreen();
            Greenfoot.setWorld(endgame);
        }
        Actor bullet = getOneIntersectingObject(Bullet.class); // check if bullet intersects an object
        if(bullet != null) // if it returns something, remove it from the world
        {
            getWorld().removeObject(bullet);
            waveCount = waveCount-1;
            if(waveCount == 0 || waveCount < 0)
            {
                if(TransitionWorld.count == 3)
                {
                    Greenfoot.setWorld(new WinGameScreen());
                }
                TransitionWorld nextWorld = new TransitionWorld();
                Greenfoot.setWorld(nextWorld);
                waveCount = 2;
            }
            getWorld().removeObject(this);
        }
    }
    int index = 0;
    public int getXCoord()
    {
        zombieX = getX();
        return zombieX;
    }
    public int getYCoord()
    {
        zombieY = getY();
        return zombieY;
    }
    public void animate()
    {
        if(defaultFacing.equals("right"))
        {
            setImage(animationRight[index]);
            index = (index+1)%(animationRight.length);
        }
        else
        {
            setImage(animationLeft[index]);
            index = (index+1)%(animationRight.length);
        }
    }
    public void chaseSurvivor()
    {
      if(MC.survivorLocationX < zombieX && MC.survivorLocationY > zombieY)
        {
            defaultFacing = "left";
            setLocation(zombieX-mvtSpd, zombieY+mvtSpd);
        }
        else if(MC.survivorLocationX < zombieX && MC.survivorLocationY < zombieY)
        {
            defaultFacing = "left";
            setLocation(zombieX-mvtSpd, zombieY-mvtSpd);
        }
        else if(MC.survivorLocationX > zombieX && MC.survivorLocationY > zombieY)
        {
            defaultFacing = "right";
            setLocation(zombieX+mvtSpd, zombieY+mvtSpd);
        }
        else if(MC.survivorLocationX > zombieX && MC.survivorLocationY < zombieY)
        {
            defaultFacing = "right";
            setLocation(zombieX+mvtSpd, zombieY-mvtSpd);
        }
        else if(MC.survivorLocationX < zombieX)
        {
            defaultFacing = "left";
            setLocation(zombieX-mvtSpd, zombieY);
        }
        else if(MC.survivorLocationX > zombieX)
        {
            defaultFacing = "right";
            setLocation(zombieX+mvtSpd, zombieY);
        }
        else if(MC.survivorLocationY > zombieY)
        {
            setLocation(zombieX, zombieY+mvtSpd);
        }
        else if(MC.survivorLocationY < zombieY)
        {
            setLocation(zombieX, zombieY-mvtSpd);
        }
       
    }
}
