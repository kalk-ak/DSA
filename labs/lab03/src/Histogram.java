import java.util.Arrays;
class Histogram {
    int lowerbound;
    int upperbound;
    int[] frequency;

    public Histogram(int lowerbound, int upperbound) {
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
        this.frequency = new int[upperbound - lowerbound + 1];
    }
    public boolean add(int i){
        if (i >= lowerbound && i <= upperbound){
            frequency[i - this.lowerbound]++;
            return true;
        } else return false;
    }

    public String toStringHelper(int num) {
        String output = "";
        for (int i = 1; i <= frequency[num]; i++){
            output += "*";
        } return output;
    }

    public String toString(){
        String output = "";
        for (int i = lowerbound; i <= upperbound; i++){
            output += i + ":" + toStringHelper(i - lowerbound) + "\n";
        } return output;
    }

    public static void main(String args[]) {
        Histogram histo = new Histogram(0, 5);
        histo.add(3);
        histo.add(2);
        histo.add(1);
        histo.add(2);
        histo.add(3);
        histo.add(0);
        histo.add(1);
        histo.add(5);
        histo.add(3);
        System.out.println(histo);
    }
}
