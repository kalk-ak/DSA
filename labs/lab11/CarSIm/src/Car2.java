// Car2.java
// Revised 10/2023

// Car2 class represents cars in the car wash simulation
// Car2 objects contain the time they were created and their service time
// Car2 objects are immediately queued in the washer queue
// Car2 objects are passive except in constructor (creation)

public class Car2 {

    // private variables

    private double arrivalTime;
    private double serviceTime;

    // constructor

    public Car2(double t, double servTime, int which) {
        arrivalTime = t;
        serviceTime = servTime;
        CarSim2.washerList[which].enter(this);
        if (!CarSim2.washerList[which].isBusy())
          new WasherEvent(servTime, which).run();  // wake-up washer if idle
    }

    public double getArrivalTime() {
        return arrivalTime;
    }
  
    public double getServiceTime() {
        return serviceTime;
    }

}  // Car2 class
