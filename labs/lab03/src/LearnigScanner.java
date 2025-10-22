import java.util.Scanner;

public class LearnigScanner {

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age: ");
        while(!input.hasNextInt()){
            input.nextLine();
            System.out.println("Invalid input only int is accepted");
        }

        int age = input.nextInt();
    }
}
