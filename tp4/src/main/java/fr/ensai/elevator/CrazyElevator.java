package fr.ensai.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrazyElevator extends Elevator {

    /**
     * A spooky Elevator
     */

    private static final Logger logger = LogManager.getLogger(CrazyElevator.class);
    private static Random random = new Random();


    public CrazyElevator(int id, int startFloor, int capacity) {
        super(id,startFloor,capacity);
    }
    /**
     * Chosse the next move according, at even probability:
     * -remain stationary
     * -skip the first destination
     * -go to the next destination as a regular elevator
     * If the elevator is full, the passengers disappear
     */
    @Override
    public void move(){
        int x=random.nextInt(3);
        if (isFull()){
            this.passengers = new ArrayList<>();
        }
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
    @Override
    public int unloadPassengers(Floor floor) {
        /**
     * Unload the passengers regulary half the time
     */
        int x=random.nextInt(2);
        if (x==1){
            this.lastUnloaded.clear();

            List<Person> remaining = new ArrayList<>();

            for (Person p : this.passengers) {
                if (p.getTargetFloor() == floor.getNumber()) {
                    this.lastUnloaded.add(p);
                    logger.info("Floor {}: {}{} leaves Elevator {}",
                            floor.getNumber(),
                            p.getNickname(),
                            p.getTargetFloor(),
                            this.id);
                } else {
                    remaining.add(p);
                }
            }
            this.passengers = remaining;
            return this.lastUnloaded.size();
        }
        return 0;
    }
    
}
