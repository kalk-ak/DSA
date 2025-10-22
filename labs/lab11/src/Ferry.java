/**
 * A class representing a Ferry, which transports Passengers from island to island.
 * Can hold up to 60 Passengers at a time.
 */

public class Ferry {

    private Passenger[] ferry = new Passenger[60];
    private int numPassengers = 0;
    public boolean addPassenger(Passenger p) {
        if (this.isFull())
            return false;
        ferry[numPassengers++] = p;
        return true;
        }

    // TODO: implement this
    public Passenger[] removePassengersAtIsland(int island){
        Passenger[] a = new Passenger[60];
        numPassengers = 0;
        for (int i = 0; i < numPassengers; i++)
            a[i] = ferry[i];

        ferry = new Passenger[60];
        numPassengers = 0;
        return a;

    }
    
    // TODO: implement this
    public boolean isFull() { return numPassengers == ferry.length; }
    
}
