package fr.ensai.elevator;

import java.util.List;
import java.util.Random;


public class CrazyElevator extends Elevator {

    private static Random random = new Random();


    public CrazyElevator(int id, int startFloor, int capacity) {
        super(id,startFloor,capacity);
    }
    @Override
    public void move(){
        int x=0;
        x=random.nextInt(3);
        if (!this.destinationQueue.isEmpty()){
            if (x==1){
                this.currentFloor = this.destinationQueue.removeFirst();
            }
            if (x==2 && this.destinationQueue.size()>=2){
                this.destinationQueue.removeFirst();
                this.currentFloor = destinationQueue.removeFirst();
            }
            if (x==2 && this.destinationQueue.size()<2){
                this.destinationQueue.removeFirst();
            }
        }
        
    }
}
