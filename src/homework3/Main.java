package homework3;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Race Race = new Race();
		Race.addHorse("Citation", 0, 0.01, new early());
		Race.addHorse("Secretariat", 1, 0.012, new slow());
		Race.addHorse("Affirmed", 2, 0.014, new steady());
		Race.addHorse("American Pharaoh", 3, 0.016, new steady());
		Race.addHorse("Justify", 4, 0.018, new slow());
		Race.runRace();
	}

}
