import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorldLevel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorldLevel2 extends World
{
    int randomSpawnX;
    int randomSpawnY;
    SimpleTimer spawnTimer = new SimpleTimer();
    SimpleTimer survivedTime = new SimpleTimer();
    public static int timeSurvived = 0;
    public static int wave2Score = GameWorldLevel1.score;
    int timePerSpawn = 1500;
    /**
     * Constructor for objects of class GameWorldLevel2.
     * 
     */
    public GameWorldLevel2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1); 
        GreenfootImage bg = new GreenfootImage("map.jpg");
        int height = bg.getHeight();
        int resizedHeight = (int)(height*1.5);
        bg.scale(bg.getWidth()*2, resizedHeight);
        setBackground(bg);
        showText("Level 2", 100,150);
        
        MC character = new MC();
        Zombie enemy = new Zombie();
        
        addObject(character, getWidth()/2, getHeight()/2);
        addObject(enemy, 0,300);
        spawnTimer.mark();
        survivedTime.mark();
    }
    public void act()
    {
        Zombie spawn = new Zombie();
        showText("Zombies Left: " + Zombie.waveCount, 100,55);
        showText("Score: " + wave2Score, getWidth()/2, getHeight()/5);
        int randomSpawnGenerator = Greenfoot.getRandomNumber(3);
        // piece of code always makes sure its random, however spawns at the borders.
        // 4 different possibilities, each for each side of the border
        if(randomSpawnGenerator == 0)
        {
            randomSpawnX = 1200;
            randomSpawnY = Greenfoot.getRandomNumber(600);
        }
        else if(randomSpawnGenerator == 1)
        {
            randomSpawnX = 0;
            randomSpawnY = Greenfoot.getRandomNumber(600);
        } 
        else if(randomSpawnGenerator == 2)
        {
            randomSpawnX = Greenfoot.getRandomNumber(1200);
            randomSpawnY = 0;
        }
        else if(randomSpawnGenerator == 3)
        {
            randomSpawnY = 600;
            randomSpawnX = Greenfoot.getRandomNumber(1200);
        }
        spawnZombie(spawn, randomSpawnX, randomSpawnY);
        wave2Score = wave2Score+1;
        timeSurvived = survivedTime.millisElapsed();
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
            timePerSpawn = timePerSpawn-1;
            addObject(z,x,y);
        }
    }
}
