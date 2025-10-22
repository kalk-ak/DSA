import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A class that handles the addition of Passengers to the line on an island
 */
public class PassengerArrivalEvent implements IEvent{
    private int island;
    public PassengerArrivalEvent(int island){
        this.island = island;
    }
    public int getIsland(){
        return island;
    }
    
    // TODO: implement this method
    @Override
    public void run() {
        Passenger newPassenger = new Passenger(island);
        Random rand = new Random();
        FerrySim.lines[island].add(newPassenger);

        int waitingTime = rand.nextInt(5, 15);
        double nextArrivalTime = FerrySim.agenda.getCurrentTime() + waitingTime;
        int passengerDepartIsland = newPassenger.getDropoffIsland();
        double currentTime =  FerrySim.agenda.getCurrentTime();

        PassengerArrivalEvent event = new PassengerArrivalEvent(island);
        FerrySim.agenda.add(event, waitingTime);
        System.out.println("Passenger Event Island: " + island + ", Current time is: " + currentTime + ", Next passenger in: " + waitingTime);


    }

}
