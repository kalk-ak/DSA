public class Bike implements Drivable{

    @Override
    public void movingForward() {
        System.out.println("Bike moving forward");
    }

    @Override
    public void movingBackward() {
        System.out.println("Bike moving backward");

    }
    public Bike() {}

}
