import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class of the mobs that is chasing the main character.
 * 
 * @Tony Lin
 * @June 14,2023
 */
public class Zombie extends Actor
{
    GreenfootImage animationRight[] = new GreenfootImage[8];
    String defaultFacing = "right";
    GreenfootSound killSound = new GreenfootSound("elephantcub.mp3");
    public int score[] = new int[10];
    public static int deathCount = 0;
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
     * This constructor creates an animation for the mob, and for both directions.
     * It set to face right by default.
     */
    public Zombie()
    {
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
    /**
     * This method manages the animation of the zombie, as it is extremely fast. Every 20 counts, it moves to the next frame.
     * This method manages the speed of the zombie off the world it is in, and generates a random speed for its movement.
     * It uses the method 'chaseSurvivor()' to automatically home the MC, chase after him.
     * This method contains the ability to kill the player if it touches it, sending the player to EndGameScreen.
     * After killing the player, it records the time that the player survived for, and after recording 10 times it saves the highest and resets the other values of the array score to 0.
     * Based off the accessible static variable in 'TransitionWorld', it takes the information of what world the player is playing in and records the information of the time elapsed of the MC in the array score.
     * The zombie tracks the MC's position and if its off the world, also automatically 'kills' the player and sends him to EndGameScreen, also recording the time survived in the array Score.
     * It also resets the array if the number of non-zero values reaches 10(it recorded the timeSurvived 10 times).
     * This method also contains the ability for a zombie to die, after a bullet hits or intersects him, it removes both the bullet from the world and the zombie, while also playing a sound.
     * After a number of zombies die, it sends you to 'TransitionWorld' and brings you to the next world chronologically.
     */
    public void act()
    {
        if(animationCounter%animationSpeed==0) // puts a delay on each frame, so the animmation does not play too fast.
        {
            animate();
        }
        if(TransitionWorld.count == 1)
        {
            mvtSpd = Greenfoot.getRandomNumber(3)+3;
        }
        else if(TransitionWorld.count == 2)
        {
            mvtSpd = Greenfoot.getRandomNumber(3)+7;
        }
        else if(TransitionWorld.count == 3)
        {
            mvtSpd = Greenfoot.getRandomNumber(7)+7;
        }
        animationCounter++;
        zombieX = getX();
        zombieY = getY();
        chaseSurvivor();
        if(isTouching(MC.class))
        {
            removeTouching(MC.class);
            deathCount++;
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
            killSound.play();
            waveCount = waveCount-1;
            if(waveCount == 0 || waveCount < 0)
            {
                if(TransitionWorld.count == 3)
                {
                    Greenfoot.setWorld(new WinGameScreen());
                    waveCount = Greenfoot.getRandomNumber(40)+10;
                }
                else 
                {
                   TransitionWorld nextWorld = new TransitionWorld();
                    Greenfoot.setWorld(nextWorld);
                    waveCount = Greenfoot.getRandomNumber(40)+10;
                    
                }
            }
            getWorld().removeObject(this);
        }
    }
    int index = 0;
    /**
     * This method is a getter method, for the position of the X and Y coordinates of the zombie.
     */
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
    /**
     * This method creates the animation, iterating through each animation image
     * This method also displays the separate series of animation based off the direction of the zombie(left or right)
     */
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
    /**
     * This method locates the survivor's position, then chases the survivor, and changes the direction including the animation based off MC's position relative to the zombie
     */
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
