package homework4;
import java.util.Random;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OceanExplorer extends Application{

	Pane root;
	final int dimensions = 25;
	final int islandCount = 10;
	final int scalingFactor = 20;
	Image shipImage;
	ImageView shipImageView;
	Image pirateImage1;
	ImageView pirateImageView1;
	Image pirateImage2;
	ImageView pirateImageView2;
	OceanMap oceanMap;
	Scene scene;
	Ship ship;
	Pirate pirate1;
	Pirate pirate2;
	Random rand = new Random();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		// TODO Auto-generated method stub
		oceanMap = new OceanMap(dimensions, islandCount);
		
		root = new AnchorPane();
		drawMap();
		ship = new Ship(oceanMap);
		loadShipImage();
		
		pirate1 = new Pirate(oceanMap);
		pirate2 = new Pirate(oceanMap);
		loadPirateImage();
		
		ship.addObserver(pirate1);
		ship.addObserver(pirate2);
		
		scene = new Scene(root, 500, 500);
		oceanStage.setTitle("Christopher Columbus Sails the Ocean Blue");
		oceanStage.setScene(scene);
		oceanStage.show();
		startSailing();
		
	}
	
	public void loadShipImage() {
		Image shipImage = new Image("file:///Users/nrao/eclipse-workspace/ColumbusGame/src/ColumbusShip.png",20,20,true,true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(this.ship.getShipLocation().getX()*scalingFactor);
		shipImageView.setY(this.ship.getShipLocation().getY()*scalingFactor);
		root.getChildren().add(shipImageView);
	}
	
	public void loadPirateImage() {
		Image pirateImage1 = new Image("file:///Users/nrao/eclipse-workspace/ColumbusGame/src/pirateship.gif",20,20,true,true);
		pirateImageView1 = new ImageView(pirateImage1);
		pirateImageView1.setX(this.pirate1.getPirateLocation().getX()*scalingFactor);
		pirateImageView1.setY(this.pirate1.getPirateLocation().getX()*scalingFactor);
		root.getChildren().add(pirateImageView1);
		Image pirateImage2 = new Image("file:///Users/nrao/eclipse-workspace/ColumbusGame/src/pirateship.gif",20,20,true,true);
		pirateImageView2 = new ImageView(pirateImage2);
		pirateImageView2.setX(this.pirate2.getPirateLocation().getX()*scalingFactor);
		pirateImageView2.setY(this.pirate2.getPirateLocation().getX()*scalingFactor);
		root.getChildren().add(pirateImageView2);
	}
	
	public void drawMap() {
		this.oceanMap.drawMap(this.root.getChildren(), this.scalingFactor);		
	}
	
	public void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()) {
					case RIGHT:
						ship.goEast();
						break;
					case LEFT:
						ship.goWest();
						break;
					case UP:
						ship.goNorth();
						break;
					case DOWN:
						ship.goSouth();
						break;
					default:
						break;
				}
				shipImageView.setX(ship.getShipLocation().getX()*scalingFactor);
				shipImageView.setY(ship.getShipLocation().getY()*scalingFactor);
				pirateImageView1.setX(pirate1.getPirateLocation().getX()*scalingFactor);
				pirateImageView1.setY(pirate1.getPirateLocation().getY()*scalingFactor);
				pirateImageView2.setX(pirate2.getPirateLocation().getX()*scalingFactor);
				pirateImageView2.setY(pirate2.getPirateLocation().getY()*scalingFactor);
			}
		});
	}

}
