import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * This is the third difficulty after passing the second level. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorldLevel3 extends World
{
    int randomSpawnX;
    int randomSpawnY;
    SimpleTimer spawnTimer = new SimpleTimer();
    SimpleTimer survivedTime = new SimpleTimer();
    public static int timeSurvived = 0;
    public static int wave3Score = GameWorldLevel2.wave2Score;
    int timePerSpawn = 1000;
    /**
     * This constructor contains the background with the scaling to make sure it fits perfectly.
     * This constructor creates a main character(MC) and a starting Zombie and places it in the world.
     * This constructor also starts the timer for when the MC is still alive, and the timer for each spawn(timePerSpawn in milliseconds)
     */
    public GameWorldLevel3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1); 
        GreenfootImage bg = new GreenfootImage("map.jpg");
        int height = bg.getHeight();
        int resizedHeight = (int)(height*1.5);
        bg.scale(bg.getWidth()*2, resizedHeight);
        setBackground(bg);
        showText("Level 3", 100,150);
        
        MC character = new MC();
        Zombie enemy = new Zombie();
        
        addObject(character, getWidth()/2, getHeight()/2);
        addObject(enemy, 0,300);
        spawnTimer.mark();
        survivedTime.mark();
    }
    /**
     * This method creates a new Zombie instance in the world randomly spawned, however will always spawn at the world border.
     * The random coordinates will be kept track through the variables randomSpawnX and randomSpawnY.
     * This method also keeps track of the surviving main character(MC) through the variable timeSurvived.
     * It also starts the scoring, by giving 1 per milliseconds survived added on by the previous world/level's score(Level 2).
     * This method displays the current score(in the middle), amount of zombies left for this level(on the top left).
     */
    public void act()
    {
        Zombie spawn = new Zombie();
        showText("Zombies Left: " + Zombie.waveCount, 100,55);
        int randomSpawnGenerator = Greenfoot.getRandomNumber(3);
        showText("Score: " + wave3Score, getWidth()/2, getHeight()/5);
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
        wave3Score++;
        spawnZombie(spawn, randomSpawnX, randomSpawnY);
        timeSurvived = survivedTime.millisElapsed();
    }
    /**
     * This method allows us to add the zombies class to the world at a certain rate(starts at 2000 milliseconds)
     * This method decreases the time per zombie spawned, by 10 milliseconds each zombie spawned for level 1.
     * It takes in 3 paramaters, the zombie, and the coordinates that it will be spawned in.
     */
    public void spawnZombie(Zombie z, int x, int y)
    {
        if(spawnTimer.millisElapsed() < timePerSpawn)
        {
            return;
        }
        else
        {
            spawnTimer.mark();
            timePerSpawn = timePerSpawn-15;
            addObject(z,x,y);
        }
    }
}
