import java.util.function.DoublePredicate;

public class Postfix {

    public static double evaluate(String[] expression) {
        Stack<String> myStack = new Stack<>(20);
        try {
            double num1;
            double num2;
            for (int i = 0; i < expression.length; i++) {
                if (Postfix.isInteger(expression[i]))
                    myStack.push(expression[i]);
                else {
                    num1 = Double.valueOf(myStack.pop());
                    num2 = Double.valueOf(myStack.pop());
                    if (expression[i].equals("+"))
                        myStack.push((num2 + num1) + "");
                    else if (expression[i].equals("-"))
                        myStack.push((num2 - num1) + "");
                    else if (expression[i].equals("*"))
                        myStack.push((num2 * num1) + "");
                    else if (expression[i].equals("/"))
                        myStack.push((num2 / num1) + "");
                }
            }
            return Double.parseDouble(myStack.pop());
        } catch (StackException e) {
            System.out.println(e.getSize());
            return 0;
        } finally {
            System.out.println("Evaluation complete");
        }

    }


    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] test1 = {"5", "2", "+"};
        String[] test2 = {"1", "2", "-"};
        String[] test3 = {"4", "5", "*", "3", "+"};
        String[] test4 = {"1", "2", "+", "3", "4", "+", "/"};
        String[] test5 = {"1", "2", "3", "4", "5", "6", "7", "-"};
        String[] test6 = {"1", "2", "3", "4", "5", "6", "7", "8"};
        String[] test7 = {"1", "2", "+", "4", "5", "-", "/", "/"};
        String[] test8 = {"1", "4", "-", "3", "4", "+", "/"};

        System.out.println(Postfix.evaluate(test1));
        System.out.println(Postfix.evaluate(test2));
        System.out.println(Postfix.evaluate(test3));
        System.out.println(Postfix.evaluate(test4));
        System.out.println(Postfix.evaluate(test5));
        System.out.println(Postfix.evaluate(test6));
        System.out.println(Postfix.evaluate(test7));
        System.out.println(Postfix.evaluate(test8));
    }
}
