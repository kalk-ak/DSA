import java.util.Scanner;

public class Max {
    public static int recursiveMaxDigit(int num, int max) {
        if (num < 10) {
            if (num > max) return num;
            else return max;
        } else {if (num % 10 > max) {
                return recursiveMaxDigit(num / 10, num % 10);
            } else {
                return recursiveMaxDigit(num / 10, max);
            }
        }
    }


    public static int recursiveMaxDigit2(int num){
        if (num < 10) return num;
        else{
            int max = num % 10;

            if (max > recursiveMaxDigit2(num / 10)) return max;
            else return recursiveMaxDigit2(num / 10);
        }
    }
    public static int iterativeMaxDigit(int num){
        int max = num % 10;
        num = num / 10;
        while (num > 0){
            if (num % 10 > max){
                max = num % 10;
                num = num / 10;
            } else {
                num = num / 10;
            }
        } return max;

    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int testNum = input.nextInt();
        System.out.println("recursion -> " + Max.recursiveMaxDigit2(testNum));
        System.out.println("ittereation -> " + Max.iterativeMaxDigit(testNum));

    }
}


