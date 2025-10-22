import java.sql.SQLOutput;

public class Helicopter extends Vehicle{

    public Helicopter(double mpg){
        this.mpg = mpg;
        nVehicles++;
    }
    public Helicopter(){
        mpg = 0.3;
        nVehicles++;
    }

    @Override
    public void movingForward() {
        System.out.println("Helicopter moving forward.");
    }

    @Override
    public void movingBackward() {
        System.out.println("Helicopter moving backward.");
    }

    @Override
    public double getMPG() {
        return mpg;
    }
    public void movingUp(){
        System.out.println("Helicopter Moving Up.");
    }
    public void movingDown(){
        System.out.println("Helicopter moving Down");
    }
    @Override
    public String toString() {
        return "Helicopter: " + this.getMPG();
    }

    private double mpg;

}
