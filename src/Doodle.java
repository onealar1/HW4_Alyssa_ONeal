import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Doodle extends Rectangle{

    private static final double DOODLE_WIDTH = 20;
    private static final double DOODLE_HEIGHT = 50;
    private double velocityY = 0;
    private double doodleX = 150;
    private double doodleY = 250;
    private static final double GRAVITY = 100;
    private static final double REBOUND_VELOCITY = -200;
    private static final double DURATION = 0.015;
    
    public Doodle(){
        super(DOODLE_WIDTH, DOODLE_HEIGHT);
        setX(doodleX);
        setY(doodleY);
        this.setFill(Color.GREEN);
    }

    public static double getDoodleWidth(){
        return DOODLE_WIDTH;
    }

    public static double getDoodleHeight(){
        return DOODLE_HEIGHT;
    }

    public Rectangle getDoodle(){
        return this;
    }

    public void applyGravity(){
        velocityY += GRAVITY * DURATION;
        doodleY += velocityY * DURATION;
        this.setY(doodleY);
    }

    public void platformJump(){
        velocityY += REBOUND_VELOCITY;
    }

    public boolean intersectsPlatform(Platform platform){
        return getBoundsInParent().intersects(platform.getBoundsInParent());
    }

    public double getVelocityY(){
        return this.velocityY;
    }

    public void setVelocityY(double velocityY){
        this.velocityY = velocityY;
    }

    public double getDoodleY(){
        return this.doodleY;
    }
}
