import javafx.scene.paint.Color;

public class BouncePlatform extends Platform{
    private double boost;
    
    public BouncePlatform(double x, double y){
        super(x, y, Color.GREEN);
    }

    @Override
    public void onBounce(){
        
    }

    /*public void jumpHigher(Doodle doodle){
        doodle.setVelocityY(-doodle.getJumpVelocity() - boost);
    }*/
}
