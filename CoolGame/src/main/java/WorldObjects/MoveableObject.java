package WorldObjects;

import java.awt.Point;
import java.io.File;

public abstract class MoveableObject extends WorldObject
{
	private String input;
	
	public MoveableObject(String _imagesFilePath, Point _position, int _frames)
	{
		super(_imagesFilePath, _position, _frames);
		input = "";
	}
	
	private void setAnimation(String _imagesFilePath)
	{
		imagesFilePath = _imagesFilePath;
		frame = 0;
	}
	
	//Checks if movement needs a new animation
	public void movement(String _input)
	{
		if (!input.equals(_input))
		{
			//Checks if the animation exists
			if (new File(ROOT_ANIMATION_FILE + "/" + this.getClass().getSimpleName() + input).exists())
			{
				input = _input;
				setAnimation(ROOT_ANIMATION_FILE + "/" + this.getClass().getSimpleName() + input);
			}
		}
	}
}