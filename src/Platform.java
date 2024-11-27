import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Platform extends Rectangle{
    private static final int PLATFORM_HEIGHT = 20;
    private static final int PLATFORM_WIDTH = 60;
    private double platformDir; // for moving platform

    public Platform(double platformX, double platformY, Color color){
        super(PLATFORM_WIDTH, PLATFORM_HEIGHT, color);
        setX(platformX);
        setY(platformY);
    }

    public Rectangle getPlatform(){
        return this;
    }

    public void setPalatformDir(double platformDir){
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

    public boolean collidesWith(double doodleX, double doodleY, int doodleHeight, int doodleWidth){
        return getBoundsInParent().intersects(doodleX, doodleY, doodleHeight, doodleWidth);
    }

    public void update(){} // for overriding moving platforms methods (moving platform)

    public void onBounce(){} // for overriding special effect platforms methods (breakable platform & bouncy platform)
}
