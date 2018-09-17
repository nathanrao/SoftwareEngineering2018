package homework4;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javafx.scene.effect.Light.Point;

public class Pirate implements Observer{
	
	Point currentLocation;
	OceanMap oceanMap;
	Random rand = new Random();
	Point targetPosition;
	
	public Pirate(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
		this.currentLocation = new Point();
		currentLocation.setX(rand.nextInt(24));
		currentLocation.setY(rand.nextInt(24));
	}
	
	public Point getPirateLocation() {
		return currentLocation;
	}
	
	public void move() {
		if (targetPosition.getX() - currentLocation.getX() > 0) {
			if (oceanMap.oceanGrid[(int) this.currentLocation.getX()+1][(int) this.currentLocation.getY()] != 1) {
				this.currentLocation.setX(this.currentLocation.getX()+1);
			}
		}
		else {
			if (this.oceanMap.oceanGrid[(int) this.currentLocation.getX()-1][(int) this.currentLocation.getY()] != 1) {
				this.currentLocation.setX(this.currentLocation.getX()-1);
			}
		}
		if (targetPosition.getY() - currentLocation.getY() > 0) {
			if (oceanMap.oceanGrid[(int) this.currentLocation.getX()][(int) this.currentLocation.getY()+1] != 1) {
				this.currentLocation.setY(this.currentLocation.getY()+1);
			}
		}
		else {
			if (this.oceanMap.oceanGrid[(int) this.currentLocation.getX()][(int) this.currentLocation.getY()-1] != 1) {
				this.currentLocation.setY(this.currentLocation.getY()-1);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof Ship) {
			targetPosition = ((Ship)o).getShipLocation();
			move();
		}
	}
	
}
