package fr.ensai.elevator;

import org.junit.jupiter.api.Test;

public class ElevatorTest {
    @Test
    void isFullFalse(){
        Elevator elev=new Elevator(1,0,2);
        assert(!elev.isFull());
    }
    @Test
    void isFullTrue(){
        Elevator elev=new Elevator(1,0,2);
        elev.fill(0);
        assert(elev.isFull());
    }
    @Test
    void addDestinationTest(){
        Elevator elev=new Elevator(1,0,2);
        elev.addDestination(1);
        assert(elev.containDestination(1));
    }
}
