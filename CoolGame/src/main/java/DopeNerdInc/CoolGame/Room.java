package DopeNerdInc.CoolGame;
import java.io.IOException;
import java.io.InputStream;

public class Room 
{
	//perhaps these values could be passed and set in constructor
	private final int roomHeight = 8;
	private final int roomWidth = 8;
	
	//holds values that determine whether you can or can't walk
	private int[][] movementArray = new int[roomWidth][roomHeight]; //where 0,0 is the top left
	
	//way the file is navigated to: temporary
	private String roomFile = "rooms/room";
	ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	
	//gigantic constructor, perhaps need to write functions to be called 
	public Room(int id)throws IOException
	{
		roomFile += (id);
		InputStream is = classloader.getResourceAsStream(roomFile);
		
		//populates the movement array with data from the specified room
		for (int i = 0; i < roomWidth ; i++)
		{
			for(int j = 0 ; j < roomHeight ; j++)
			{
				movementArray[i][j] = Character.getNumericValue(is.read());
			}
			//have to burn two -1 values that act as the return in the text file
			is.read();
			is.read();
		}
		
		//test print of array contents
		for(int i = 0; i < roomWidth ; i++)
		{
			for(int j = 0; j < roomHeight ; j++)
			{
				System.out.print(movementArray[i][j] + " ");
			}
			System.out.println(); 
		}
	}
}
