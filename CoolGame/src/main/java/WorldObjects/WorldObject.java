package WorldObjects;

import java.io.File;
import java.io.IOException;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public abstract class WorldObject
{
	private final int FRAMES = 3;
	
	private static int frame = 0;
	private String imagesFilePath;
	private Point position;
	
	public WorldObject(String _imagesFilePath, Point _position)
	{
		imagesFilePath = _imagesFilePath;
		position = _position;
	}
	
	public void setPosition(Point _position)
	{
		position = _position;
	}
	
	public Point getPosition()
	{
		return position;
	}
	
	public void nextFrame()
	{
		if (frame > FRAMES - 1)
		{
			frame = 0;
		}
		else
		{
			frame++;
		}
	}
	
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