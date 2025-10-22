public class Fib {
    public static int fibonacciRecursive(int n){
        if (n==0) return 0;
        else if (n==1) return 1;
        else{
            return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
        }
    }

    public static int fibonacciIterative(int n){
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else {
            int answer = 1;
            int adder = 0;
            int temp;

            for (int i = 1; i < n; i += 1){
                temp = answer;
                answer += adder;
                adder = temp;

            }
            return answer;
        }

    }
    /*public enum Day {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY*/
   // }
	// 


    public static void main(String[] args) {
        System.out.println(fibonacciRecursive(10));
        System.out.println(fibonacciIterative(10));
        System.out.println(fibonacciIterative(5));

       /* Day today = Day.SATURDAY;

        switch (today) {
            case MONDAY:
                System.out.println("Its Monday");
                break;
            case TUESDAY:
                System.out.println("Its Tuesday");
                break;
            case WEDNESDAY:
                System.out.println("Wednesday");
                break;
            case THURSDAY:
                System.out.println("Thursday");
                break;
            case FRIDAY:
                System.out.println("Chips");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Printed papyrus");
                break;
            default:
                System.out.println("Not a valid date");

*/
//}




    }
}



