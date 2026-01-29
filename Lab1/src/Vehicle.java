
import java.awt.*;


public abstract class Vehicle implements Movable {
    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;

    private double x = 0.0;
    private double y = 0.0;

    private int direction = 0;

    public Vehicle (int nrDoors, double enginePower, double currentSpeed, Color color ,String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }


    @Override
    // Visualiserar som en klocka
    public void move(){
        if(direction == 3){ // Höger (x-axeln)
            x += currentSpeed;
        }
        else if(direction == 9){ // Vänster (x-axeln)
            x-= currentSpeed;
        }

        else if(direction == 0){ // Uppåt (y-axeln)
            y+= currentSpeed;
        }
        else y -= currentSpeed; // Nedåt (y-axeln)
    }

    public int getDirection(){
        return direction;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    @Override
    public void turnLeft(){
        direction += 9;
        direction = direction % 12;
    }

    @Override
    public void turnRight(){
        direction += 3;
        direction = direction % 12;
    }

    public abstract double speedfactor();

    @Override
    public String toString(){
        return "Car[Modelname:" +  modelName + ", nrDoors:" + nrDoors + ", enginePower:" + enginePower + ", currentSpeed:" + currentSpeed + "]";
    }


    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedfactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedfactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount < 0.0 || amount > 1.0 ){
            throw new IllegalArgumentException("Gas must be between the set of interval!");
        }
        else {
        incrementSpeed(amount);
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount < 0.0 || amount > 1.0){
            throw new IllegalArgumentException("Brake must be between the set of interval!");
        }
        else{
        decrementSpeed(amount);
        }
    }
}