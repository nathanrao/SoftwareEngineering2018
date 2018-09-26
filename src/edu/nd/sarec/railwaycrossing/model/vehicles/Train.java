package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the train entity object
 * @author jane
 *
 */
public class Train extends Observable implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	private int speed = 0;
	
	public Train(int x, int y, int speed){
		this.currentX = x;
		this.currentY = y;
		this.speed = speed;
		originalX = x;
		img = new Image("file:src/images/Train.PNG",120,trainLength,false,false);
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		currentX-=speed;
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
	
	public boolean offScreen(){
		if (currentX < -200 || currentX > 1400)
			return true;
		else
			return false;				
	}
	
	public void reset(){
		currentX = originalX;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
}