import javafx.scene.paint.Color;

public class BreakablePlatform extends Platform{

    private boolean isBroken = false;
    
    public BreakablePlatform(double x, double y){
        super(x, y, Color.RED);
    }

    // this will visually make the platform disappear, but the controller will need to physically remove the platform
    // in case the doodle falls
    @Override
    public void onBounce(){ 
        isBroken = true;
        getPlatform().setFill(Color.TRANSPARENT); 
    }

    public boolean getIsBroken(){
        return this.isBroken;
    }
}
