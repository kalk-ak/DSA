// Segment.java

// Priority Queue and Simulation
// Segment class used in priority queue (PQ.java)
// Uses the queue interface QGen.java
// Uses linked node queue implementation Q1Gen.java
// Modified 10/2023

public class Segment {

    // private variables

    private double time;
    private QGen<Event> q;
    private Segment next;

    // constructor

    public Segment(double t) {
        time = t;
        q = new Q1Gen<Event>();
        next = null;
    }

    // methods

    public double getTime() {
        return time;
    }

    public QGen<Event> getEvents() {
        return q;
    }

    public Segment getNext() {
        return next;
    }

    public void setNext(Segment nextSegment) {
        next = nextSegment;
    }

}  // Segment class
