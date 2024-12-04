
// this platform moves left and right, so it will override the update method

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class MovingPlatform extends Platform{

    private final double SPEED = 3;
    private int platformDir = 1;
    private double leftBoundary, rightBoundary;
    private Image platform_img = new Image("images\\moving-platform.png");

    public MovingPlatform(double x, double y, double leftBoundary, double rightBoundary) {
        super(x, y);
        this.setFill(new ImagePattern(platform_img));
        this.leftBoundary = leftBoundary;
        this.rightBoundary = rightBoundary;
    }

    public void movePlatform(){

        if (getX() <= leftBoundary || getX() >= rightBoundary) {
            platformDir *= -1;
        }

        setX(getX() + (platformDir * SPEED));
    }
}
