/**
 * A class that represents a FerryEvent, which handles boarding, deboarding, and transport of Passengers
 */
public class FerryEvent implements IEvent{

  private  int curIsland;
  private Ferry ship;
  // What two attributes will we need to keep track of?
  
  // We should create a constructor that takes in those attributes and sets them.

  // TODO: implement this
  @Override
  public void run() {
    ship.removePassengersAtIsland(curIsland);

    for (int i = 0; i < shi)
    // Check if there are passengers to deboard.
    // If there are, deboard them and create a new FerryEvent with the same 
    //   island and ferry. The time will be the amount of time it takes to
    //   deboard these passengers.
    
    // If there aren't any passengers to deboard, let's check if we can board 
    //   passengers. If there's passengers who want to board and space on the 
    //   ferry, then let's board. Keep track of the number of passengers that
    //   board, because we'll once again be adding another FerryEvent to allow
    //   for the time that passed, just like for deboarding.
    
    // If there is no deboarding and no boarding, then it's time for the ferry 
    //   to move on. We'll add a new FerryEvent to the agenda, this time with 
    //   the next island (remember that the ferry goes 0->1->2->0...), and the 
    //   time as the amount of time it takes to travel to the next island.
       
  }
}
