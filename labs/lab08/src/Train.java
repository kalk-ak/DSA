public class Train extends Vehicle{

    public Train(double mpg){
        this.mpg = mpg;
        nVehicles++;
    }
    public Train(){
        mpg = 470.0;
        nVehicles++;
    }
    @Override
    public void movingForward() {
        System.out.println("Train moving Forward");
    }

    @Override
    public void movingBackward() {
        System.out.println("Train moving Backward.");
    }

    @Override
    public double getMPG() {
        return mpg;
    }
    public void enteringStation(){
        System.out.println("Train Entering station");
    }
    public void leavingStation(){
        System.out.println("Train leaving station");
    }
    @Override
    public String toString() {
        return "Train: " + this.getMPG();
    }
    private double mpg;
}
