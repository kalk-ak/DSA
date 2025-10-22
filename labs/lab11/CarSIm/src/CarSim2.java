// CarSim2.java
// Main simulation driver
// Revised November 2019


// Uses instantiable Washer2 class and separate WasherEvent class.

// Uses PQ.java, Washer2.java, Stat2.java
// Indirectly uses or implements:
// QGen.java, Q1Gen.java, Segment.java, Event.java, NGen.java
// Washer2.java, CarMaker2.java, Car2.java, Stat2.java

public class CarSim2 {

    // public variables

    static PQ agenda = new PQ();
    public static Washer2[] washerList;

    // methods

    public static void main(String args[]) {

        washerList = new Washer2[1];  // only one washer for this simulation
        washerList[0] = new Washer2(0);    // create a car washer with queue
//        washerList[1] = new Washer2(1);    // create a car washer with queue
        
        int distArray[] = {20, 40};
        
//      First parameter to CarMaker in line below is arrival rate. 
//      Adjust arrival rate to change load on the system, determine equilibrium  
//      Middle parameter is the array of possible kinds of washes, by duration
//      Last parameter is the number of Washer2 instances
//      First event is arbitrarily scheduled for time 10.

        agenda.add(new CarMaker2(35, distArray, 1), 10);

//      adjust simulation time to determine if system is at equilibrium

        while (agenda.getCurrentTime() <= 5000) {
            agenda.remove().run();
        }

        washerList[0].printStats();  // display statistics for this washer
//        washerList[1].printStats();  // display statistics for this washer

    }  // main method
    

}  // CarSim2 class
