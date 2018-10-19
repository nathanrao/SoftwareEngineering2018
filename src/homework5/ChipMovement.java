package homework5;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface ChipMovement {
	public ImageView abstractMovement();
}

class up implements ChipMovement {

	@Override
	public ImageView abstractMovement() {
		Image chipImage = new Image("file:chip/textures/chipUp.png", 25, 25, true, true);
		ImageView chipImageView = new ImageView(chipImage);
		return chipImageView;
		
	}
	
}

class down implements ChipMovement {

	@Override
	public ImageView abstractMovement() {
		// TODO Auto-generated method stub
		Image chipImage = new Image("file:chip/textures/chipDown.png", 25, 25, true, true);
		ImageView chipImageView = new ImageView(chipImage);
		return chipImageView;
	}
	
}

class left implements ChipMovement {

	@Override
	public ImageView abstractMovement() {
		// TODO Auto-generated method stub
		Image chipImage = new Image("file:chip/textures/chipLeft.png", 25, 25, true, true);
		ImageView chipImageView = new ImageView(chipImage);
		return chipImageView;
	}
	
}

class right implements ChipMovement {

	@Override
	public ImageView abstractMovement() {
		// TODO Auto-generated method stub
		Image chipImage = new Image("file:chip/textures/chipRight.png", 25, 25, true, true);
		ImageView chipImageView = new ImageView(chipImage);
		return chipImageView;
	}
	
}
