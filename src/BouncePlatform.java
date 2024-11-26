import javafx.scene.paint.Color;

public class BouncePlatform extends Platform{
    
    public BouncePlatform(double x, double y){
        super(x, y, Color.GREEN);
    }

    @Override
    public void onBounce(){
        // implement higher jump
    }
}
