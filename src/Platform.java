import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Platform extends Rectangle{
    private static final int PLATFORM_HEIGHT = 20;
    private static final int PLATFORM_WIDTH = 60;
    private double platformDir; 
    private Image platform_img = new Image("images\\platform.png");

    
    public Platform(double platformX, double platformY){
        super(platformX, platformY, PLATFORM_WIDTH, PLATFORM_HEIGHT);
        setFill(new ImagePattern(platform_img));
    }

    public Rectangle getPlatform(){
        return this;
    }

    public void setPlatformDir(double platformDir){
        this.platformDir = platformDir;
    }

    public double getPlatformDir() {
        return this.platformDir;
    }

    public static double getPlatformHeight(){
        return PLATFORM_HEIGHT;
    }

    public static double getPlatformWidth(){
        return PLATFORM_WIDTH;
    }

    public void setPosition(double platformX, double platformY){
        setX(platformX);
        setY(platformY);
    }

}
