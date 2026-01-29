import org.junit.jupiter.api.Test;

import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

// Olika tester

class VehicleTest {
    Vehicle testCar1 = new Saab95();
    Vehicle testCar2 = new Volvo240();

    @Test
    void move() {
        testCar1.turnRight();
        assertEquals(3,testCar1.getDirection());
    }

    @Test
    void turnLeft() {
      testCar1.turnLeft();
      testCar2.turnLeft();
      testCar2.turnLeft();

      assertEquals(9, testCar1.getDirection());
      assertEquals(6, testCar2.getDirection());
    }

    @Test
    void turnRight() {
       testCar1.turnRight();
       testCar2.turnRight();
       testCar2.turnRight();

       assertEquals(3, testCar1.getDirection());
       assertEquals(6, testCar2.getDirection());
    }

    @Test
    void gas() {
        double oldSpeed = testCar1.getCurrentSpeed();
        testCar1.gas(1);
        assertTrue(testCar1.getCurrentSpeed() > oldSpeed);
    }

    @Test
    void brake() {
        testCar1.gas(1);
        double oldSpeed = testCar1.getCurrentSpeed();
        testCar1.brake(0.5);
        assertTrue(testCar1.getCurrentSpeed() < oldSpeed);
    }

    @Test
    void nrDoors(){
        testCar1.getNrDoors();
        assertEquals(2, testCar1.getNrDoors());

        testCar2.getNrDoors();
        assertEquals(4, testCar2.getNrDoors());
    }

    @Test
    void color(){
        testCar1.getColor();
        assertEquals(Color.red, testCar1.getColor());
    }

    @Test
    void entireMoveFunction(){
        testCar1.gas(1);
        testCar1.move();
        assertEquals(1.25, testCar1.getY());
        testCar1.turnRight();
        testCar1.move();
        assertEquals(1.25, testCar1.getX());
        testCar1.turnLeft();
    }
}