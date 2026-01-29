import java.awt.*;

public class Volvo240 extends Vehicle{

    public final static double trimFactor = 1.25;
    // Engine power of the car

    public Volvo240(){
        super(4, 100, 0, Color.black, "Volvo240");
        stopEngine();
    }

    @Override
    public double speedfactor(){
        return super.getEnginePower() * 0.01 * trimFactor;
    }

}