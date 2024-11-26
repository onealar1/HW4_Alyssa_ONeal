import javafx.scene.shape.Rectangle;

public class Model {
    int doodleDirX = 1, doodleDirY = 1;
    private double doodleX;
    private double doodleY;
    private final double VELOCITY = 10;
    private final double GRAVITY = 0.015;
    private Rectangle doodle;
    private Rectangle platform = new Platform(GRAVITY, GRAVITY, null);

    public Model() {
    }

    public void moveDoodle(double sceneHeight, double sceneWidth, Platform platform) {

    }

    public double getDoodleX(){
        return this.doodleX;
    }

    public double getDoodleY(){
        return this.doodleY;
    }


    public double getJumpVelocity(){
        return this.VELOCITY;
    }

    public boolean doodleHitsPlatform(){
        return doodle.intersects(platform.getBoundsInParent());
    }

    /*public void moveBall(double sceneHeight, double sceneWidth, Circle ball, Rectangle paddle) {

        // Bouncing ball
        if(centerY >= sceneHeight - radius || centerY <= radius) {
            dirY *= -1; 
            bounce_property.setValue(bounce_property.getValue() + 1); // bounce = bounce + 1;
        }

        if(centerX >= sceneWidth - radius || centerX <= radius) {
            dirX *= -1;
            bounce_property.setValue(bounce_property.getValue() + 1);
        }

        if(ballHitsPaddle(ball, paddle)) {

        }

        centerX = centerX + dirX*speed;
        centerY = centerY + dirY*speed;
    }*/
}

