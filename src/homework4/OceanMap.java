package homework4;
import java.util.Random;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanMap {

	int[][] oceanGrid = new int[25][25];
	final int ocean = 0;
	final int island = 1;
	final int ship = 2;
	int dimensions = 25;
	int scalingFactor;
	int islandCount;
	Random rand = new Random();
	
	public OceanMap(int dimens, int numIslands) {
		this.dimensions = dimens;
		this.islandCount = numIslands;
	}
	
	public void drawMap(ObservableList<Node> root, int scale) {
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				oceanGrid[x][y] = ocean;
			}
		}
		for(int i = 0; i < islandCount; i++) {
			int xPos = rand.nextInt(24);
			int yPos = rand.nextInt(24);
			if(xPos != 10 || yPos != 10) {
				placeIslands(root, scale, xPos, yPos);
			}
			else {
				i--;
				continue;
			}
			
		}		
	}
	
	public void placeIslands(ObservableList<Node> root, int scale, int x, int y) {
		if(oceanGrid[x][y] == ocean) {
					oceanGrid[x][y] = island;
					Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.GREEN);
					root.add(rect);			
		}
		
	}
	
}
