public class Car extends Vehicle{

    public Car(double mpg){
        this.mpg = mpg;
        nVehicles++;
    }
    public Car(){
        mpg = 30.0;
        nVehicles++;
    }
    @Override
    public void movingForward() {
        System.out.println("Car moving forward.");
    }

    @Override
    public void movingBackward() {
        System.out.println("Car moving backward.");
    }

    @Override
    public double getMPG() {
        return mpg;
    }

    @Override
    public String toString() {
        return "Car: " + this.getMPG();
    }

    private double mpg;
}
