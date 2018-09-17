package homework4;
import java.util.Observable;

import javafx.scene.effect.Light.Point;

public class Ship extends Observable{

	Point currentLocation;
	OceanMap oceanMap;
	
	public Ship(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
		this.currentLocation = new Point();
		currentLocation.setX(10);
		currentLocation.setY(10);
	}
	
	public Point getShipLocation() {
		return currentLocation;
	}
	
	public void goEast() {
		if(oceanMap.oceanGrid[(int) this.currentLocation.getX()+1][(int) this.currentLocation.getY()] != 1 || this.currentLocation.getX()+1 == 25) {
			this.currentLocation.setX(this.currentLocation.getX()+1);
		}
		setChanged();
		notifyObservers();
	}
	
	public void goWest() {
		if(oceanMap.oceanGrid[(int) this.currentLocation.getX()-1][(int) this.currentLocation.getY()] != 1 || this.currentLocation.getX()-1 == -1) {
			this.currentLocation.setX(this.currentLocation.getX()-1);
		}
		setChanged();
		notifyObservers();
	}
	
	public void goNorth() {
		if(oceanMap.oceanGrid[(int) this.currentLocation.getX()][(int) this.currentLocation.getY()-1] != 1 || this.currentLocation.getY()-1 == -1) {
			this.currentLocation.setY(this.currentLocation.getY()-1);
		}
		setChanged();
		notifyObservers();
	}
	
	public void goSouth() {
		if(oceanMap.oceanGrid[(int) this.currentLocation.getX()][(int) this.currentLocation.getY()+1] != 1 || this.currentLocation.getY()+1 == 25) {
			this.currentLocation.setY(this.currentLocation.getY()+1);
		}
		setChanged();
		notifyObservers();
	}
	
}
