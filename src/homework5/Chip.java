package homework5;

import java.awt.Point;
import java.util.Observable;

public class Chip extends Observable{

	public int xLocation = 0;
	public int yLocation = 0;
	public Point currentLocation;
	Grid grid;
	
	public Chip(Grid grid){
		xLocation = 12;
		yLocation = 12;
		currentLocation = new Point(xLocation, yLocation);
		this.grid = grid;
		grid.boardGrid[xLocation][yLocation] = 3;
	}
	
	public Point getChipLocation() {
		return new Point(xLocation, yLocation);
	}

	public void goEast() {
		// TODO Auto-generated method stub
		if ((xLocation + 1) > -1 && (xLocation + 1) < 25 && grid.boardGrid[xLocation + 1][yLocation] != 1) {
			grid.boardGrid[xLocation][yLocation] = 0;
			xLocation++;
			setChanged();
			notifyObservers();
		}
	}

	public void goWest() {
		// TODO Auto-generated method stub
		if ((xLocation - 1) > -1 && (xLocation - 1) < 25 && grid.boardGrid[xLocation - 1][yLocation] != 1) {
			grid.boardGrid[xLocation][yLocation] = 0;
			xLocation--;
			setChanged();
			notifyObservers();
		}
	}

	public void goSouth() {
		// TODO Auto-generated method stub
		if ((yLocation + 1) > -1 && (yLocation + 1) < 25 && grid.boardGrid[xLocation][yLocation + 1] != 1) {
			grid.boardGrid[xLocation][yLocation] = 0;
			yLocation++;
			setChanged();
			notifyObservers();
		}
	}

	public void goNorth() {
		// TODO Auto-generated method stub
		if ((yLocation - 1) > -1 && (yLocation - 1) < 25 && grid.boardGrid[xLocation][yLocation - 1] != 1) {
			grid.boardGrid[xLocation][yLocation] = 0;
			yLocation--;
			setChanged();
			notifyObservers();
		}
	}
}
