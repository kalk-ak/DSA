import java.awt.Color;
import java.lang.Math;
public class Circle {
    private double xPos;
    private double yPos;
    private double radius;
    private Color color; //---------------------

    /**
     * Constructor of the circle class
     *
     * @param x the x position of the circle
     * @param y the y position of the circe
     * @param rad the radius of the circe */
    public Circle(double x, double y, double rad){
        this.xPos = x;
        this.yPos = y;
        this.radius = rad;
    }

    /**
     * Calculates the perimeter of the circle to the
     * @return the perimeter of the circle object.
     */
    public double calcPerimeter(){
        double perimeter = Math.PI * 2 * radius;
        return perimeter;
    }

    /**
     * Calculates the Area of the circle object
     * @return the Area of the circle
     */
    public double calcArea() {
        return (Math.PI * radius * radius);
    }

    public void setColor(Color c){ this.color = c; }

    public void setPos(double x, double y){
        this.xPos = x;
        this.yPos = y;
    }

    public void setRadius(double rad){ radius = rad; }

    public Color getColor(){ return color; }

    public double getXPos(){ return xPos; }

    public double getYPos(){return yPos; }

    public double getRadius(){ return radius; }
}

