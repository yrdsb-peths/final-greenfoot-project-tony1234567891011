import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    //GreenfootImage bg = new GreenfootImage("map.jpg");
    int counter = 0;
    int spawnCounter = 250;
    SimpleTimer spawnTimer = new SimpleTimer();
    int timePerSpawn = 2000;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200,600,1,false);
        /*
        int height = bg.getHeight();
        int resizedHeight = (int)(height*1.5);
        bg.scale(bg.getWidth()*2, resizedHeight);
        setBackground(bg);
        */
        MC character = new MC();
        Zombie enemy = new Zombie();
        addObject(character, getWidth()/2, getHeight()/2);
        addObject(enemy, 0,300);
        spawnTimer.mark();
    }
    
    public void act()
    {
        
        Zombie spawn = new Zombie();
        int randomSpawnX = Greenfoot.getRandomNumber(1200);
        int randomSpawnY = Greenfoot.getRandomNumber(600);
        while(randomSpawnX == MC.survivorLocationX && randomSpawnY == MC.survivorLocationY && randomSpawnX == (MC.survivorLocationX + 20) && randomSpawnY == (MC.survivorLocationY+20))
        // makes sure it does not spawn on the main character or too close 
        //20 is for the range so the hitbox also does not autoend game.
        {
            randomSpawnX = Greenfoot.getRandomNumber(1200);
            randomSpawnY = Greenfoot.getRandomNumber(600);
        }
        spawnZombie(spawn, randomSpawnX, randomSpawnY);
        /*
        if(spawn.isTouching(MC.class))
        {
            removeTouching(this);
            removeObject();
        }
        */

        /*
        if(counter%10 == 0 && spawnCounter != 1 && spawnCounter >= 50)
        // makes sure zombies do not spawn too quickly, however spawn faster and faster.
        {s
            spawnCounter = spawnCounter - 1;
        }
        */
        
    }
    public void spawnZombie(Zombie z, int x, int y)
    {
        if(spawnTimer.millisElapsed() < timePerSpawn)
        {
            return;
        }
        else
        {
            spawnTimer.mark();
            addObject(z,x,y);
        }
    }
    public void endGame()
    {
        
    }
}
