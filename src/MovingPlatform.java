import javafx.scene.paint.Color;

// this platform moves left and right, so it will override the update method
public class MovingPlatform extends Platform{

    private double speed;
    private double platformX = getPlatformX();
    private double platformY = getPlatformY();
    private double platformWidth = getPlatformWidth();
    private double platformHeight = getPlatformHeight();
    private double platformDir = getPlatformDir();
    
    public MovingPlatform(double x, double y) {
        super(x, y, Color.BLUE);
    }

    @Override
    public void update(){
        
    }

    /*public void movePlatform(double platformDir){
        if (platformX >= 0 && platformX + getPlatformWidth() <= getPlatformHeight()) {
            platformX = platformX + platformDir * speed;
        }
        else if (platformX < 0){
            platformX = 0;
        }
        else if (platformX + platformWidth > sceneWidth) {
            paddleX = sceneWidth - paddleWidth;
        }
    }*/
}
