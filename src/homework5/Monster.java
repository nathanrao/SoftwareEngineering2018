package homework5;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Monster implements Observer{

	public int xLocation = 0;
	public int yLocation = 0;
	public Point currentLocation;
	int min = 0;
	int max = 24;
	int range = max - min + 1;
	Random rand;
	int num = 0;
	Grid grid;
	Chip chip;
	
	public Monster(Grid grid, Chip chip) {
		rand = new Random();
		this.grid = grid;
		this.chip = chip;
		xLocation = (int)(rand.nextInt(range)) + min;
		yLocation = (int)(rand.nextInt(range)) + min;
		//make sure monster isn't placed on an already used space
		while (grid.boardGrid[xLocation][yLocation] != 0 || (xLocation == 12 && yLocation == 12)) {
			xLocation = (int)(rand.nextInt(range)) + min;
			yLocation = (int)(rand.nextInt(range)) + min;
		}
		grid.boardGrid[xLocation][yLocation] = 4;
	}
	
	public Point getMonsterLocation() {
		return new Point(xLocation, yLocation);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// random method
		rand = new Random();
		num = (int)(rand.nextInt(4)) + 1;
		switch (num) {
			case 1: 
				grid.boardGrid[xLocation][yLocation] = 0;
				goEast();
				grid.boardGrid[xLocation][yLocation] = 4;
				break;
			case 2:
				grid.boardGrid[xLocation][yLocation] = 0;
				goWest();
				grid.boardGrid[xLocation][yLocation] = 4;
				break;
			case 3:
				grid.boardGrid[xLocation][yLocation] = 0;
				goNorth();
				grid.boardGrid[xLocation][yLocation] = 4;
				break;
			case 4:
				grid.boardGrid[xLocation][yLocation] = 0;
				goSouth();
				grid.boardGrid[xLocation][yLocation] = 4;
				break;
			default:
				break;
		}
	}

	
	public void goEast() {
		// TODO Auto-generated method stub
		if ((xLocation + 1) > -1 && (xLocation + 1) < 25 && grid.boardGrid[xLocation + 1][yLocation] != 1 && grid.boardGrid[xLocation + 1][yLocation] != 5 && grid.boardGrid[xLocation + 1][yLocation] != 2 && grid.boardGrid[xLocation + 1][yLocation] != 4) {
			xLocation++;
		}
	}

	public void goWest() {
		// TODO Auto-generated method stub
		if ((xLocation - 1) > -1 && (xLocation - 1) < 25 && grid.boardGrid[xLocation - 1][yLocation] != 1 && grid.boardGrid[xLocation - 1][yLocation] != 5 && grid.boardGrid[xLocation - 1][yLocation] != 2 && grid.boardGrid[xLocation - 1][yLocation] != 4) {
			xLocation--;
		}
	}

	public void goSouth() {
		// TODO Auto-generated method stub
		if ((yLocation + 1) > -1 && (yLocation + 1) < 25 && grid.boardGrid[xLocation][yLocation + 1] != 1 && grid.boardGrid[xLocation][yLocation + 1] != 5 && grid.boardGrid[xLocation][yLocation + 1] != 2 && grid.boardGrid[xLocation][yLocation + 1] != 4) {
			yLocation++;
		}
	}

	public void goNorth() {
		// TODO Auto-generated method stub
		if ((yLocation - 1) > -1 && (yLocation - 1) < 25 && grid.boardGrid[xLocation][yLocation - 1] != 1 && grid.boardGrid[xLocation][yLocation - 1] != 5 && grid.boardGrid[xLocation][yLocation - 1] != 2 && grid.boardGrid[xLocation][yLocation - 1] != 4) {
			yLocation--;
		}
	}

}
