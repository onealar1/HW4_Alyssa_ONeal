import javafx.scene.paint.Color;

// this platform moves left and right, so it will override the update method
public class MovingPlatform extends Platform{

    private double speed;
    
    public MovingPlatform(double x, double y) {
        super(x, y, Color.BLUE);
    }

    @Override
    public void update(){

    }
}
