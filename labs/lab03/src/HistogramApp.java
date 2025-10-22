import java.util.Scanner;
public class HistogramApp {
    public static void main(String[] args) {
        System.out.println("Options--\n" +
                "add -> used to add numbers to the histogram\n" +
                "print -> prints the histogram to the screen\n" +
                "quit -> leaves the program");
        System.out.println("\n");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a lower bound: ");
        int lowerBound = input.nextInt();
        System.out.print("Enter an upper bound: ");
        int upperBound = input.nextInt();
        input.nextLine();


        System.out.println();
        Histogram createdHistogram = new Histogram(lowerBound, upperBound);

        String key = input.nextLine();
        while (!key.equals("quit")){
            if (key.equals("add")){
                System.out.print("Enter a number: ");
                int num = input.nextInt();
                createdHistogram.add(num);

                input.nextLine();
                key = input.nextLine();

            } else if (key.equals("print")){
                System.out.println(createdHistogram.toString());
                input.nextLine();
                key = input.nextLine();
            } else {
                System.out.println("Not a valid input");
                key = input.nextLine();
            }
        }
        System.out.println("Bye!");
    }
}
