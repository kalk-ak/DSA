// FractalDrawer class draws a fractal of a shape indicated by user input
import javax.print.DocFlavor;
import java.awt.Color;
import java.util.Scanner;
import java.util.Random;

public class FractalDrawer {
    private double totalArea = 0;  // member variable for tracking the total area

    public FractalDrawer() {
    }  // constructor


    Color[] colors = new Color[]{Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.ORANGE, Color.RED};

    Random random = new Random();


    /**
     * method draws either circles, rectangles,or triangles depending on the input.
     * @param type the shape to be drawn. Either "triangle", "cicle" or "rectangle"
     * @return The total area of all the shapes drawn
     */
    public double drawFractal(String type) {
        Canvas drawing = new Canvas(1200, 1200);
        int randomIndex = random.nextInt(colors.length);


        if (type.equals("triangle")) {

            this.drawTriangleFractal(25, 25, 600, 600, colors[randomIndex], drawing, 15);
        } else if (type.equals("circle")) {
            this.drawCircleFractal(300, 400, 400, colors[randomIndex], drawing, 15);
        } else {
            this.drawRectangleFractal(500, 400, 400, 400, colors[randomIndex], drawing, 15);
        }

        return totalArea;
    }


    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Random random = new Random();
        if (level >= 0) {
            Triangle myTriangle = new Triangle(x, y, width, height);
            myTriangle.setColor(c);
            can.drawShape(myTriangle);
            this.totalArea += myTriangle.calculateArea();

            int randomIndex = random.nextInt(colors.length);

            drawTriangleFractal(width , height, x + width, y, colors[randomIndex], can, level - 1);
            drawTriangleFractal(width , height, x - (width), y, colors[randomIndex], can, level - 1);
            drawTriangleFractal(width, height, x, y - height, colors[randomIndex], can, level - 1);

        } else {
            return;
        }
    }


    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        if (level >= 0) {
            Circle myCircle = new Circle(x, y, radius);
            myCircle.setColor(c);
            can.drawShape(myCircle);
            this.totalArea += myCircle.calcArea();

            int randomIndex = random.nextInt(colors.length);

            drawCircleFractal(radius / 1.5, x + (radius / 1.5), y + (radius / 1.5), colors[randomIndex], can, level - 1);
            drawCircleFractal(radius / 1.5, x - (radius / 1.5), y + (radius / 1.5), colors[randomIndex], can, level - 1);
            drawCircleFractal(radius / 1.5, x + (radius / 1.5), y - (radius / 1.5), colors[randomIndex], can, level - 1);
            drawCircleFractal(radius / 1.5, x - (radius / 1.5), y - (radius / 1.5), colors[randomIndex], can, level - 1);

        } else {
            return;
        }
    }


    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        if (level >= 0) {
            Rectangle myRectangle = new Rectangle(x, y, width, height);
            myRectangle.setColor(c);
            can.drawShape(myRectangle);
            this.totalArea += myRectangle.calculateArea();

            int randomIndex = random.nextInt(colors.length);

            drawRectangleFractal(width / 2.5, height / 2.5, x, y, colors[randomIndex], can, level - 1);
            drawRectangleFractal(width / 2.5, height / 2.5, x + ((1.5 / 2.5) * width), y, colors[randomIndex], can, level - 1);
            drawRectangleFractal(width / 2.5, height / 2.5, x, y + ((1.5 / 2.5) * height), colors[randomIndex], can, level - 1);
            drawRectangleFractal(width / 2.5, height / 2.5, x + ((1.5 / 2.5) * width), y + ((1.5 / 2.4) * height), colors[randomIndex], can, level - 1);

        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String prompt;

        System.out.print("What shape do you want to be drawn\n" +
                "1. circle \n" +
                "2. triangle \n" +
                "3. rectangle \n" +
                "\nChoose one of these options >>>> ");
        prompt = input.nextLine();

        while (!prompt.equals("circle") && !prompt.equals("triangle") && !prompt.equals("rectangle")) {
            System.out.println("Invalid input. Please choose one of these options >>>>");
            prompt = input.nextLine();
        }

        FractalDrawer drawer = new FractalDrawer();

        double area = drawer.drawFractal(prompt);
        System.out.println("The calculated total area is " + area);
    }




}

