import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Platform {
    private int platformHeight;
    private int platformWidth;
    private double platformX;
    private double platformY;
    private Rectangle platform;

    public Platform(double platformX, double platformY, Color color){
        this.platformHeight = 20;
        this.platformWidth = 60;
        this.platformX = platformX;
        this.platformY = platformY;
        platform = new Rectangle(platformX, platformY, color);
        platform.setFill(color);
    }

    public Rectangle getPlatform(){
        return this.platform;
    }

    public double getPlatformHeight(){
        return this.platformHeight;
    }

    public double getPlatformWidth(){
        return this.platformWidth;
    }

    public double getPlatformX(){
        return this.platformX;
    }

    public double getPlatformY(){
        return this.platformY;
    }

    public void setPosition(double platformX, double platformY){
        this.platformX = platformX;
        this.platformY = platformY;
        platform.setX(platformX);
        platform.setY(platformY);
    }

    public boolean collidesWith(double doodleX, double doodleY, int doodleHeight, int doodleWidth){
        return platform.getBoundsInParent().intersects(doodleX, doodleY, doodleHeight, doodleWidth);
    }

    public void update(){} // for overriding moving platforms methods (moving platform)

    public void onBounce(){} // for overriding special effect platforms methods (breakable platform & bouncy platform)
}
