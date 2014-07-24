package WorldObjects;

import java.io.File;
import java.io.IOException;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public abstract class WorldObject
{
	//TBD
	protected static final String ROOT_ANIMATION_FILE = "";
	
	//Number of frames of animation
	private int frames;
	//Current frame
	protected int frame;
	protected String imagesFilePath;
	private Point position;
	
	public WorldObject(String _imagesFilePath, Point _position, int _frames)
	{
		imagesFilePath = _imagesFilePath;
		position = _position;
		frames = _frames;
		frame = 0;
	}
	
	public void setPosition(Point _position)
	{
		position = _position;
	}
	
	public Point getPosition()
	{
		return position;
	}
	
	//Advances the animation frame
	public void nextFrame()
	{
		if (frame < frames - 1)
		{
			frame++;
		}
		else
		{
			frame = 0;
		}
	}
	
	//Returns the animation for the current frame
	public BufferedImage animate()
	{
		try
		{
			return ImageIO.read(new File(imagesFilePath + "/" + frame + ".jpg"));
		}
		catch (IOException exc)
		{
			System.err.println("Sprite Not Found");
			return null;
		}
	}
}