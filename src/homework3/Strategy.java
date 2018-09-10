package homework3;

public interface Strategy {
	public double abstractMethod(Double speed, Double pos);
}

//different strategies set different speeds depending on different horse positions in-race
class early implements Strategy{
	@Override
	public double abstractMethod(Double speed, Double pos) {
		double newSpeed = speed;
		if(pos > 2.0) {
			newSpeed = 0.75 * speed;
		}
		return newSpeed;
	}
}

class steady implements Strategy{
	@Override
	public double abstractMethod(Double speed, Double pos) {
		double newSpeed = 0.8 * speed;
		return newSpeed;
	}
}

class slow implements Strategy{
	@Override
	public double abstractMethod(Double speed, Double pos) {
		double newSpeed = speed;
		if(pos <= 6.0) {
			newSpeed = 0.75 * speed;
		}
		else if (pos > 6.0 && pos <= 0.9) {
			newSpeed = 0.9 * speed;
		}
		return newSpeed;
	}
}