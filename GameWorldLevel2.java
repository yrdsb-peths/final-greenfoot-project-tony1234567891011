import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the second difficulty after the passing the first level. 
 * 
 * @Tony Lin
 * @June 14, 2023
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
     * This constructor contains the background with the scaling to make sure it fits perfectly.
     * This constructor creates a main character(MC) and a starting Zombie and places it in the world.
     * This constructor also starts the timer for when the MC is still alive, and the timer for each spawn(timePerSpawn in milliseconds)
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
    /**
     * This method creates a new Zombie instance in the world randomly spawned, however will always spawn at the world border.
     * The random coordinates will be kept track through the variables randomSpawnX and randomSpawnY.
     * This method also keeps track of the surviving main character(MC) through the variable timeSurvived.
     * It also starts the scoring, by giving 1 per milliseconds survived added on by the previous world/level's score.
     * This method displays the current score(in the middle), amount of zombies left for this level(on the top left).
     */
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
        wave2Score = wave2Score+1;//adds 1 score per act method run once.
        timeSurvived = survivedTime.millisElapsed();//adds the time that the MC survived for
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
