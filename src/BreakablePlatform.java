import javafx.scene.paint.Color;

public class BreakablePlatform extends Platform{

    private boolean isBroken = false;
    
    public BreakablePlatform(double x, double y){
        super(x, y, Color.RED);
    }

    @Override
    public void onBounce(){ 
        isBroken = true;
        getPlatform().setFill(Color.DARKRED); // will need to change to remove the platform from the view
    }

    public boolean getIsBroken(){
        return this.isBroken;
    }
}
