package homework5;

import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Grid {

	public int[][] boardGrid = new int[25][25];
	final int dimensions = 25;
	public int keyNum = 0;
	int min = 0;
	int max = 24;
	int range = max - min + 1;
	Random rand;
	int xRand, yRand, bluexLocation, blueyLocation, yellowxLocation, yellowyLocation, redxLocation, redyLocation, greenxLocation, greenyLocation;
	Image blueImage, yellowImage, redImage, greenImage, tile, portal;
	ImageView blueImageView, yellowImageView, redImageView, greenImageView, tileImageView, portalImageView;
	int scale = 25;
	boolean finalReveal = false;
	public int finalxLocation = -1;
	public int finalyLocation = -1;
	int level;
	
	protected Grid(int level) {
		this.level = level;
	};
	
	public void drawGrid(ObservableList<Node> root, int scale) {
		// initialize entire grid as gray
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				tile = new Image("file:chip/textures/BlankTile.png", 25, 25, true, true);
				tileImageView = new ImageView(tile);
				tileImageView.setX(x*scale); 
				tileImageView.setY(y*scale);
				root.add(tileImageView);
				boardGrid[x][y] = 0;
			}
		}
		
		// create walls as BLACK, initialize bool as true
		if(this.level == 0) {
			for (int x = 5; x < 6; x++) {
				for (int y = 2; y < 10; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 1; x < 6; x++) {
				for (int y = 12; y < 13; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 4; x < 5; x++) {
				for (int y = 14; y < 20; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 5; x < 6; x++) {
				for (int y = 22; y < 25; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 5; x < 18; x++) {
				for (int y = 22; y < 23; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 4; x < 9; x++) {
				for (int y = 19; y < 20; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 9; x < 10; x++) {
				for (int y = 0; y < 4; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 8; x < 16; x++) {
				for (int y = 7; y < 8; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 13; x < 20; x++) {
				for (int y = 2; y < 3; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 8; x < 20; x++) {
				for (int y = 14; y < 15; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 19; x < 20; x++) {
				for (int y = 5; y < 15; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 19; x < 23; x++) {
				for (int y = 5; y < 6; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 18; x < 23; x++) {
				for (int y = 17; y < 18; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 22; x < 23; x++) {
				for (int y = 17; y < 21; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
		}
		else {
			for (int x = 3; x < 13; x++) {
				for (int y = 3; y < 4; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 21; x < 22; x++) {
				for (int y = 0; y < 4; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 5; x < 6; x++) {
				for (int y = 7; y < 14; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 6; x < 12; x++) {
				for (int y = 9; y < 10; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 2; x < 5; x++) {
				for (int y = 13; y < 14; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 2; x < 9; x++) {
				for (int y = 18; y < 19; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 7; x < 8; x++) {
				for (int y = 19; y < 23; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 16; x < 17; x++) {
				for (int y = 6; y < 14; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 22; x < 23; x++) {
				for (int y = 6; y < 14; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 15; x < 23; x++) {
				for (int y = 14; y < 15; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 11; x < 12; x++) {
				for (int y = 17; y < 25; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
			for (int x = 12; x < 23; x++) {
				for (int y = 20; y < 21; y++) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.BLACK);
					root.add(rect);
					boardGrid[x][y] = 1;
				}
			}
		}
		
		// blue key
		rand = new Random();
		bluexLocation = (int)(rand.nextInt(range)) + min;
		blueyLocation = (int)(rand.nextInt(range)) + min;
		while (boardGrid[bluexLocation][blueyLocation] != 0) {
			bluexLocation = (int)(rand.nextInt(range)) + min;
			blueyLocation = (int)(rand.nextInt(range)) + min;
		}
		boardGrid[bluexLocation][blueyLocation] = 2;
		blueImage = new Image("file:chip/textures/blueKey.png", 25, 25, true, true);
		blueImageView = new ImageView(blueImage);
		blueImageView.setX(bluexLocation*scale); 
		blueImageView.setY(blueyLocation*scale);
		root.add(blueImageView);
		
		// yellow key
		rand = new Random();
		yellowxLocation = (int)(rand.nextInt(range)) + min;
		yellowyLocation = (int)(rand.nextInt(range)) + min;
		while (boardGrid[yellowxLocation][yellowyLocation] != 0) {
			yellowxLocation = (int)(rand.nextInt(range)) + min;
			yellowyLocation = (int)(rand.nextInt(range)) + min;
		}
		boardGrid[yellowxLocation][yellowyLocation] = 2;
		yellowImage = new Image("file:chip/textures/yellowKey.png", 25, 25, true, true);
		yellowImageView = new ImageView(yellowImage);
		yellowImageView.setX(yellowxLocation*scale); 
		yellowImageView.setY(yellowyLocation*scale);
		root.add(yellowImageView);
		
		// red key
		rand = new Random();
		redxLocation = (int)(rand.nextInt(range)) + min;
		redyLocation = (int)(rand.nextInt(range)) + min;
		while (boardGrid[redxLocation][redyLocation] != 0) {
			redxLocation = (int)(rand.nextInt(range)) + min;
			redyLocation = (int)(rand.nextInt(range)) + min;
		}
		boardGrid[redxLocation][redyLocation] = 2;
		redImage = new Image("file:chip/textures/redKey.png", 25, 25, true, true);
		redImageView = new ImageView(redImage);
		redImageView.setX(redxLocation*scale); 
		redImageView.setY(redyLocation*scale);
		root.add(redImageView);
		
		// green key
		rand = new Random();
		greenxLocation = (int)(rand.nextInt(range)) + min;
		greenyLocation = (int)(rand.nextInt(range)) + min;
		while (boardGrid[greenxLocation][greenyLocation] != 0) {
			greenxLocation = (int)(rand.nextInt(range)) + min;
			greenyLocation = (int)(rand.nextInt(range)) + min;
		}
		boardGrid[greenxLocation][greenyLocation] = 2;
		greenImage = new Image("file:chip/textures/greenKey.png", 25, 25, true, true);
		greenImageView = new ImageView(greenImage);
		greenImageView.setX(greenxLocation*scale); 
		greenImageView.setY(greenyLocation*scale);
		root.add(greenImageView);
	}
	
	// check grid to see if Chip's location matches that of a key or a final spot
	public void checkGrid(ObservableList<Node> root, int x, int y) {
		if (x == bluexLocation && y == blueyLocation && boardGrid[x][y] == 2) {
			root.remove(blueImageView);
			boardGrid[bluexLocation][blueyLocation] = 0;
			keyNum++;
			Text track = new Text(715, 225, "BLUE");
			track.setFont(Font.font ("Verdana", 10));
			track.setFill(Color.BLUE);
			root.add(track);
		}
		if (x == yellowxLocation && y == yellowyLocation && boardGrid[x][y] == 2) {
			root.remove(yellowImageView);
			boardGrid[yellowxLocation][yellowyLocation] = 0;
			keyNum++;
			Text track = new Text(715, 250, "YELLOW");
			track.setFont(Font.font ("Verdana", 10));
			track.setFill(Color.GOLD);
			root.add(track);
			
		}
		if (x == redxLocation && y == redyLocation && boardGrid[x][y] == 2) {
			root.remove(redImageView);
			boardGrid[redxLocation][redyLocation] = 0;
			keyNum++;
			Text track = new Text(715, 275, "RED");
			track.setFont(Font.font ("Verdana", 10));
			track.setFill(Color.RED);
			root.add(track);
			
		}
		if (x == greenxLocation && y == greenyLocation && boardGrid[x][y] == 2) {
			root.remove(greenImageView);
			boardGrid[greenxLocation][greenyLocation] = 0;
			keyNum++;
			Text track = new Text(715, 300, "GREEN");
			track.setFont(Font.font ("Verdana", 10));
			track.setFill(Color.GREEN);
			root.add(track);
			
		}
		// reveal final spot
		if (keyNum == 4 && finalReveal == false) {
			finalxLocation = (int)(rand.nextInt(range)) + min;
			finalyLocation = (int)(rand.nextInt(range)) + min;
			while (boardGrid[finalxLocation][finalyLocation] != 0) {
				finalxLocation = (int)(rand.nextInt(range)) + min;
				finalyLocation = (int)(rand.nextInt(range)) + min;
			}
			boardGrid[greenxLocation][greenyLocation] = 5;
			portal = new Image("file:chip/textures/portal.png", 25, 25, true, true);
			portalImageView = new ImageView(portal);
			portalImageView.setX(finalxLocation*scale); 
			portalImageView.setY(finalyLocation*scale);
			root.add(portalImageView);
			Text track = new Text(765, 350, "GET TO THE PORTAL!");
			track.setFont(Font.font ("Verdana", FontWeight.BOLD, 10));
			track.setFill(Color.BLACK);
			root.add(track);
			boardGrid[x][y] = 5;
			finalReveal = true;
		}
	}
}
