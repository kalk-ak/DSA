import java.awt.Color;
import java.lang.Math;
public class Rectangle {
    private double xUpperLeft;
    private double yUpperLeft;
    private double width;
    private double height;
    private Color color;

    /**
     * Rectangle class constructor
     * @param xPos x position of upper left corner
     * @param yPos y position of upper left corner
     * @param wid the width of the rectangle
     * @param heit the height of the triangle
     */

    public Rectangle(double xPos, double yPos, double wid, double heit){
        this.xUpperLeft = xPos;
        this.yUpperLeft = yPos;
        this.width = wid;
        this.height = heit;
    }
    /**
     * Calculates and returns the perimeter of the Rectangle
     */
    public double calculatePerimeter(){
        return (2 * width) + (2 * height);
    }

    /**
     * Calculates the area of the rectangle
     * @return Area of the rectangle
     */
    public double calculateArea(){
        return height * width;
    }

    public void setColor(Color c){ this.color = c; }

    /**
     * sets the x and y position of the upper left corner of the rectangle
     * @param xPos the x position of the upper left corner
     * @param yPos the y position of the upper left corner
     */
    public void setPos(double xPos, double yPos){
        this.xUpperLeft = xPos;
        this.yUpperLeft = yPos;
    }
    public void setHeight(double h){ height = h; }

    public void setWidth(double wid){ width = wid;}

    public Color getColor(){ return color; }

    public double getXPos(){ return xUpperLeft; }

    public double getYPos(){ return yUpperLeft; }

    public double getHeight() { return height; }

    public double getWidth() { return width; }
}

