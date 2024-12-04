import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Doodle extends Rectangle{

    private static final double DOODLE_WIDTH = 50;
    private static final double DOODLE_HEIGHT = 50;
    private double velocityY = 0, velocityX = 0;
    private static final double SPEED = 10;
    private double doodleX = 150;
    private double doodleY = 250;
    private static final double GRAVITY = 200;
    private static final double REBOUND_VELOCITY = -200;
    private static final double DURATION = 0.030;
    private boolean isGameOver = false;
    private IntegerProperty score = new SimpleIntegerProperty(0);
    private Image doodleImage_right = new Image("images\\doodle-right.png");
    private Image doodleImage_left = new Image("images\\doodle-left.png");
    
    public Doodle(){
        super(DOODLE_WIDTH, DOODLE_HEIGHT);

        this.setFill(new ImagePattern(doodleImage_right)); 

        setX(doodleX);
        setY(doodleY);
    }

    public static double getDoodleWidth(){
        return DOODLE_WIDTH;
    }

    public IntegerProperty getScore(){
        return this.score;
    }

    public static double getDoodleHeight(){
        return DOODLE_HEIGHT;
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
        return (platform.getBoundsInParent().intersects(getBoundsInParent()) && (getDoodleY() + getDoodleHeight() - 5 <= platform.getY()));
    }

    public double getVelocityY(){
        return this.velocityY;
    }

    public void setVelocityY(double velocityY){
        this.velocityY = velocityY;
    }

    public void setDoodleY(double doodleY){
        this.doodleY = doodleY;
        setY(doodleY);
    }

    public double getDoodleY(){
        return this.doodleY;
    }

    public void setDoodleX(double doodleX) {
        this.doodleX = doodleX;
        setX(doodleX);
    }

    public double getDoodleX(){
        return this.doodleX;
    }

    public double getDoodleVelocityX() {
        return this.velocityX;
    }

    public void move(double sceneWidth, double sceneHeight, ArrayList<Platform> platforms){
        applyGravity();

        if(doodleY > sceneHeight){
            setY(sceneHeight);
            velocityY = 0;
            isGameOver = true;
        }

        if(getDoodleX() < 0){
            this.setDoodleX(sceneWidth);
        }
        else if (getDoodleX() > sceneWidth){
            this.setDoodleX(0);
        }
        else {
            this.setDoodleX(this.getDoodleX() + getDoodleVelocityX());
        }

        if(velocityY > 0){
            for(Platform platform : platforms){
                if(intersectsPlatform(platform) && velocityY > 0){
                    score.setValue(score.getValue() + 1);

                    if(platform instanceof BouncePlatform){
                        Image platform_bounce_img = new Image("images\\bounced-on-platform.png");
                        BouncePlatform bounce = (BouncePlatform) platform;
                        velocityY = bounce.getBoost();
                        bounce.setWidth(80);
                        bounce.setFill(new ImagePattern(platform_bounce_img));
                    }
                    else if (platform instanceof BreakablePlatform) {
                        BreakablePlatform breakable = (BreakablePlatform) platform;

                        Image platform_broken_img = new Image("images\\platform5a.png");
                        breakable.setFill(new ImagePattern(platform_broken_img));

                        if (breakable.getIsBroken()) {
                            break;
                        }
                        else{
                            breakable.setIsBroken(true);
                            setVelocityY(-200);
                        }
                    }
                    else{
                        velocityY = -200;
                    }
                }
            }
        }
    }

    public void moveDirection(int direction){
        if(direction == -1){
            this.setFill(new ImagePattern(doodleImage_left)); 
        }
        else{
            this.setFill(new ImagePattern(doodleImage_right));
        }

        velocityX = direction * SPEED;
    }

    public boolean getIsGameOver(){
        return this.isGameOver;
    }
}
