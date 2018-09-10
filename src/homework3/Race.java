package homework3;

import java.util.Vector;

public class Race {

	public Vector<String> horseNames;
	public Vector<Double> horseMaxSpeed;
	public Vector<Double> horseSpeed;
	public Vector<Strategy> horseStrat;
	public Vector<Double> horsePos;
	public String winner;
	public int time;
	
	public Race() {
		horseNames = new Vector<String>();
		horseMaxSpeed = new Vector<Double>();
		horseSpeed = new Vector<Double>();
		horseStrat = new Vector<Strategy>();
		horsePos = new Vector<Double>();	
	};
	
	public void addHorse(String name, Integer lane, Double speed, Strategy strat) {
		horseNames.add(name);
		horseMaxSpeed.add(speed);
		horseSpeed.add(speed);
		horseStrat.add(strat);
		horsePos.add(0.0);
	}
	
	//change speed dependent on current horse position
	public void changeSpeed() {
		int horses = horseNames.size();
		for(int i = 0; i < horses; i++) {
			horseSpeed.set(i, horseStrat.elementAt(i).abstractMethod(horseMaxSpeed.elementAt(i), horsePos.elementAt(i)));
		}
	}
	
	public void runRace(){
		int time = 0;
		int horses = horseNames.size();
		changeSpeed();
		
		//loop for the race
		while(time > -1 && winner == null) {
			if(time == 0) { //open gun
				System.out.println("And they're off!");
			}
			
			for(int i = 0; i < horses; i++) { //update position
				horsePos.set(i, horsePos.elementAt(i) + horseSpeed.elementAt(i));
			}
			
			for(int i = 0; i < horses; i++) { //find the winner
				if(horsePos.elementAt(i) >= 10) {
					winner = horseNames.elementAt(i);
					System.out.println(' ');
					System.out.println(winner + " has won!" + winner + " had a final time of: " + time + " seconds.");
					System.out.println("Final distances for all horses:");
					for(int j = 0; j < horses; j++) {
						System.out.println(horseNames.elementAt(j) + " ran " + horsePos.elementAt(i) + " miles.");
					}
					break;
				}
				else {
					continue;
				}
			}
			
			if (((time % 20) == 0) && (time > 0)) { //output the positions mid race
				for(int i = 0; i < horses; i++) {
					System.out.println(horseNames.elementAt(i) + " has run " + horsePos.elementAt(i) + " miles.");
					System.out.println(horseNames.elementAt(i) + " speed: " + horseSpeed.elementAt(i));
					System.out.println(horseNames.elementAt(i) + " strategy: " + horseStrat.elementAt(i));
				}
			}
		
			//changeSpeed();
			time += 1;
		}
	}
	
	public String giveWinner() {
		return winner;
	}
	
	public void newStrat(int lane, Strategy strategy) {
		horseStrat.set(lane, strategy);
	}
	
}
