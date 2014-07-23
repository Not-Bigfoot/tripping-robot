package DopeNerdInc.CoolGame;

public class App 
{
    public static void main( String[] args )
    {
    	//variables used for timing frames
    	boolean gameRunning = true;
    	long lastLoop = System.nanoTime();
    	long currentTime;
    	long loopLength;
    	long timeSinceLastFrame = 0;
    	int count = 0;
    	
    	final int TARGET_FPS = 30;
    	final long FRAME_LENGTH = 1000000000 / TARGET_FPS; 
    	
    	//variables used to find time elapsed for testing purposes
    	long startTime = lastLoop;
    	long endTime;
    	
    	//will loop until told to stop
        while(gameRunning)
        {
        	//determine the amount of time that has passed since last loop
        	currentTime = System.nanoTime();
        	loopLength = currentTime - lastLoop;
        	lastLoop = currentTime;
        	
        	//determine amount of time since last frame
        	timeSinceLastFrame += loopLength;
        	
        	//if it is time to make a frame, make it 
        	if (timeSinceLastFrame >= FRAME_LENGTH)
        	{
        		//game logic
        		//render
        		count ++;
        		System.out.println("Frame " + count);
        		if (count >= 300)
        		{
        			gameRunning = false;
        			endTime = System.nanoTime();
        			System.out.println("Time elapsed is: " + (endTime - startTime)/1000000000.0 + " seconds");
        		}
        		timeSinceLastFrame = 0;
        	}
    	}
    }
}
