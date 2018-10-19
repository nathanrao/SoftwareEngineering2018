package homework5;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainGame extends Application {

	Pane root;
	int dimensions = 25;
	Grid grid;
	int width = 1000;
	int height = 625;
	int scale = 25;
	Scene scene;
	Chip chip;
	Monster mon1, mon2, mon3, mon4, mon5;
	Image chipImage, mon1Image, mon2Image, mon3Image, mon4Image, mon5Image;
	ImageView chipImageView, mon1ImageView, mon2ImageView, mon3ImageView, mon4ImageView, mon5ImageView;
	ObservableList<Node> ObservableList;
	boolean endGame = false;
	Button btn;
	int level = 0;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Stage stage = primaryStage;
		grid = new Grid(this.level);
		chip = new Chip(grid);
		root = new AnchorPane();
		ObservableList = root.getChildren();
		grid.drawGrid(ObservableList, scale);
		mon1 = new Monster(grid, chip);
		mon2 = new Monster(grid, chip);
		mon3 = new Monster(grid, chip);
		mon4 = new Monster(grid, chip);
		mon5 = new Monster(grid, chip);
		chip.addObserver(mon1);
		chip.addObserver(mon2);
		chip.addObserver(mon3);
		chip.addObserver(mon4);
		chip.addObserver(mon5);
	
		// add initial images
		chipImage = new Image("file:chip/textures/chipDown.png", 25, 25, true, true);
		chipImageView = new ImageView(chipImage);
		chipImageView.setX(chip.getChipLocation().x*scale); 
		chipImageView.setY(chip.getChipLocation().y*scale);
		root.getChildren().add(chipImageView);
		
		mon1Image = new Image("file:chip/textures/bugUp.png", 25, 25, true, true);
		mon1ImageView = new ImageView(mon1Image);
		mon1ImageView.setX(mon1.getMonsterLocation().x*scale); 
		mon1ImageView.setY(mon1.getMonsterLocation().y*scale);
		root.getChildren().add(mon1ImageView);
		
		mon2Image = new Image("file:chip/textures/bugUp.png", 25, 25, true, true);
		mon2ImageView = new ImageView(mon2Image);
		mon2ImageView.setX(mon2.getMonsterLocation().x*scale); 
		mon2ImageView.setY(mon2.getMonsterLocation().y*scale);
		root.getChildren().add(mon2ImageView);
		
		mon3Image = new Image("file:chip/textures/bugUp.png", 25, 25, true, true);
		mon3ImageView = new ImageView(mon3Image);
		mon3ImageView.setX(mon3.getMonsterLocation().x*scale); 
		mon3ImageView.setY(mon3.getMonsterLocation().y*scale);
		root.getChildren().add(mon3ImageView);
		
		mon4Image = new Image("file:chip/textures/bugUp.png", 25, 25, true, true);
		mon4ImageView = new ImageView(mon4Image);
		mon4ImageView.setX(mon4.getMonsterLocation().x*scale); 
		mon4ImageView.setY(mon4.getMonsterLocation().y*scale);
		root.getChildren().add(mon4ImageView);
		
		mon5Image = new Image("file:chip/textures/bugUp.png", 25, 25, true, true);
		mon5ImageView = new ImageView(mon5Image);
		mon5ImageView.setX(mon5.getMonsterLocation().x*scale); 
		mon5ImageView.setY(mon5.getMonsterLocation().y*scale);
		root.getChildren().add(mon5ImageView);
		
		btn = new Button("Reset");
		btn.setLayoutX(945);
		btn.setLayoutY(600);
		root.getChildren().add(btn);
		
		// dashboard
		Text title = new Text(715, 100, "CHIPS CHALLENGE");
		title.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
		title.setFill(Color.GREEN);
		root.getChildren().add(title);
		
		Text rules = new Text(715, 150, "Collect all of the keys and avoid monsters!");
		rules.setFont(Font.font ("Verdana", 10));
		rules.setFill(Color.GREEN);
		root.getChildren().add(rules);
		
		Text track = new Text(715, 200, "Keys collected:");
		track.setFont(Font.font ("Verdana", FontWeight.BOLD, 10));
		track.setFill(Color.GREEN);
		root.getChildren().add(track);
		
		// begin game
		scene = new Scene(root, width, height);
		stage.setScene(scene);
		stage.setTitle("Chip's Challenge");
		stage.show();
		startGame(stage);	
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				stage.close();
				try {
					endGame = false;
					start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	private void startGame(Stage stage) {
	
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()){
					case RIGHT: 
						chip.goEast();
						root.getChildren().remove(chipImageView);
						right right = new right();
						chipImageView = right.abstractMovement();
						grid.checkGrid(ObservableList, chip.getChipLocation().x, chip.getChipLocation().y);
						grid.boardGrid[chip.getChipLocation().x][chip.getChipLocation().y] = 3;
						break; 
					case LEFT:
						chip.goWest();
						root.getChildren().remove(chipImageView);
						left left = new left();
						chipImageView = left.abstractMovement();
						grid.checkGrid(ObservableList, chip.getChipLocation().x, chip.getChipLocation().y);
						grid.boardGrid[chip.getChipLocation().x][chip.getChipLocation().y] = 3;
						break; 
					case UP:
						chip.goNorth();
						root.getChildren().remove(chipImageView);
						up up = new up();
						chipImageView = up.abstractMovement();
						grid.checkGrid(ObservableList, chip.getChipLocation().x, chip.getChipLocation().y);
						grid.boardGrid[chip.getChipLocation().x][chip.getChipLocation().y] = 3;
						break; 
					case DOWN:
						chip.goSouth();
						root.getChildren().remove(chipImageView);
						down down = new down();
						chipImageView = down.abstractMovement();
						grid.checkGrid(ObservableList, chip.getChipLocation().x, chip.getChipLocation().y);
						grid.boardGrid[chip.getChipLocation().x][chip.getChipLocation().y] = 3;
						break;
					case ESCAPE:
						endGame = true;
						root.getChildren().clear();
						stage.close();
						break;
					default:
						break;			
					}
					if (endGame == false) {
						chipImageView.setX(chip.getChipLocation().x*scale); 
						chipImageView.setY(chip.getChipLocation().y*scale);
						root.getChildren().add(chipImageView);
					
						root.getChildren().remove(mon1ImageView);
						mon1ImageView.setX(mon1.getMonsterLocation().x*scale); 
						mon1ImageView.setY(mon1.getMonsterLocation().y*scale);
						root.getChildren().add(mon1ImageView);
					
						root.getChildren().remove(mon2ImageView);
						mon2ImageView.setX(mon2.getMonsterLocation().x*scale); 
						mon2ImageView.setY(mon2.getMonsterLocation().y*scale);
						root.getChildren().add(mon2ImageView);
						
						root.getChildren().remove(mon3ImageView);
						mon3ImageView.setX(mon3.getMonsterLocation().x*scale); 
						mon3ImageView.setY(mon3.getMonsterLocation().y*scale);
						root.getChildren().add(mon3ImageView);
					
						root.getChildren().remove(mon4ImageView);
						mon4ImageView.setX(mon4.getMonsterLocation().x*scale); 
						mon4ImageView.setY(mon4.getMonsterLocation().y*scale);
						root.getChildren().add(mon4ImageView);
						
						root.getChildren().remove(mon5ImageView);
						mon5ImageView.setX(mon5.getMonsterLocation().x*scale); 
						mon5ImageView.setY(mon5.getMonsterLocation().y*scale);
						root.getChildren().add(mon5ImageView);
						
						if (chip.getChipLocation().x == grid.finalxLocation && chip.getChipLocation().y == grid.finalyLocation) {
							Text win = new Text(775, 390, "WINNER");
							Text level2 = new Text(775, 390, "LEVEL 2");
							if (level == 0) {
								stage.close();
								level += 1;
								setLevel(level);
								try {
									endGame = false;
									start(stage);
								} catch (Exception e) {
									e.printStackTrace();
								}
								level2.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
								level2.setFill(Color.RED);
								root.getChildren().add(level2);
							}
							else {
								root.getChildren().remove(level2);
								win.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
								win.setFill(Color.RED);
								root.getChildren().add(win);
								root.getChildren().remove(chipImageView);
								endGame = true;
							}
						}
						if ((chip.getChipLocation().x == mon1.getMonsterLocation().x && chip.getChipLocation().y == mon1.getMonsterLocation().y) || (chip.getChipLocation().x == mon2.getMonsterLocation().x && chip.getChipLocation().y == mon2.getMonsterLocation().y) || (chip.getChipLocation().x == mon3.getMonsterLocation().x && chip.getChipLocation().y == mon3.getMonsterLocation().y) || (chip.getChipLocation().x == mon4.getMonsterLocation().x && chip.getChipLocation().y == mon4.getMonsterLocation().y) || (chip.getChipLocation().x == mon5.getMonsterLocation().x && chip.getChipLocation().y == mon5.getMonsterLocation().y)) {
							Text loss = new Text(700, 390, "A monster caught you!");
							loss.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
							loss.setFill(Color.RED);
							root.getChildren().add(loss);
							endGame = true;
						}	
					}
				}	
		});	
	}
}
