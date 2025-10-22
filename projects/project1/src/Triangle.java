import java.awt.Color;
import java.lang.Math;
public class Triangle {
    private double xLowLeft;
    private double yLowLeft;
    private double width;
    private double height;
    private Color color;

    /**
     * Constructor for the Triangle class
     * @param x the x position of the bottom left corner of the triangle
     * @param y the y position of the bottom left corner of the triangle
     * @param wid the width of the triangle
     * @param hit the height of the triangle
     */
    public Triangle(double x, double y, double wid, double hit){
        this.xLowLeft = x;
        this.yLowLeft = y;
        this.width = wid;
        this.height = hit;
    }

    /**
     * Calculates the perimeter of the triangle
     * @return the perimeter of the triangle
     */
    public double calculatePerimeter(){
        double lenSide = Math.sqrt((height * height) + ((width / 2) * (width / 2)));
        return lenSide;
    }

    /**
     * calculates the Area of the triangle
     * @return the Area of the triangle
     */
    public double calculateArea(){
        return 0.5 * width * height;
    }

    public void setColor(Color c){ this.color = c; }

    /**
     * sets the x and y position of the bottom left corners of the triangle
     * @param x x position of th bottom left corner
     * @param y y position of the bottom left corner
     */
    public void setPos(double x, double y){
        this.xLowLeft = x;
        this.yLowLeft = y;
    }

    public void setHeight(double h){ height = h; }

    public void setWidth(double wid){ width = wid; }

    public Color getColor(){ return color; }

    public double getXPos(){ return xLowLeft; }

    public double getYPos(){return yLowLeft; }

    public double getHeight(){return  height;}

    public double getWidth(){ return width; }

}

