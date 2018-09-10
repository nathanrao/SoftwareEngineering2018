package homework3;
import org.junit.Test;

public class raceTest1 {
	@Test
	public void test(){
		Race race = new Race(); //race 1
		race.addHorse("Citation", 0, 0.2, new early());
		race.addHorse("Secretariat", 1, 0.25, new slow());
		race.addHorse("Affirmed", 2, 0.3, new early());
		race.addHorse("American Pharaoh", 3, 0.35, new slow());
		race.addHorse("Justify", 4, 0.4, new steady());
		race.runRace();
		assert(race.giveWinner() == "Justify");
		
		Race race1 = new Race(); //race 2
		race1.addHorse("Citation", 0, 1.0, new early());
		race1.addHorse("Secretariat", 1, 0.75, new slow());
		race1.addHorse("Affirmed", 2, 1.2, new early());
		race1.addHorse("American Pharaoh", 3, 0.85, new slow());
		race1.addHorse("Justify", 4, 1.1, new steady());
		race1.runRace();
		assert(race1.giveWinner() == "Affirmed");
		
		Race race2 = new Race();
		race2.addHorse("Citation", 0, 0.5, new early());
		race2.addHorse("Secretariat", 1, 0.5, new slow());
		race2.addHorse("Affirmed", 2, 0.5, new steady());
		race2.addHorse("American Pharaoh", 3, 0.49, new slow());
		race2.addHorse("Justify", 4, 0.49, new steady());
		race2.runRace();
		assert(race2.giveWinner() == "Citation");
	}
}
