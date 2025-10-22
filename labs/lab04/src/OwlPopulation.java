import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;

public class OwlPopulation {
    private String fileName;
    private Owl[] data;


    public int populateData() throws FileNotFoundException {
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);
        String s = "";

        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
           s += scanner.nextLine() + "\n";
        }
        scanner.close();


        data = new Owl[numLines];   //data is is allocated the exact amount of space it needs
        scanner = new Scanner(f);
        String myArray[] = s.split("\n");



        for (int i = 0; i < myArray.length; i++){
            String line[] = myArray[i].split(",");
            Owl newOwl = new Owl(line[0], Integer.parseInt(line[1]), Double.parseDouble(line[2]));
            data[i] = newOwl;

        }

    return data.length;
    }

    public OwlPopulation(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        populateData();
    }

    public double averageAge(){
        double average = 0;
        for (int i = 0; i < data.length; i++){
            average += data[i].getAge();
        }
        return average / data.length;
    }

    public Owl getYoungest(){
        Owl lowest = data[0];
        for (int i = 1; i < data.length; i++){
            if (data[i].getAge() < lowest.getAge()){
                lowest = data[i];
            }
        }
        return lowest;
    }

    public Owl getHeaviest(){
        Owl heaviest = data[0];
        for (int i = 1; i < data.length; i++){
            if (data[i].getWeight() > heaviest.getWeight()){
                heaviest = data[i];
            }
        }
        return heaviest;
    }

    public String toString(){
        Owl youngest = getYoungest();
        Owl heaviest = getHeaviest();

        String outPut = "The youngest owl is " + youngest.getName() + ", which is " + youngest.getAge() +
                "\nThe heaviest owl is " + heaviest.getName() + ", which is " + heaviest.getWeight() +
                "\nThe average age of the population is " + averageAge();

        return outPut;
    }

    public boolean containsOwl(Owl other){
        //TODO: method you can implement as a helper function to your merge method
        return false;
    }

    public void merge(OwlPopulation other){
        //TODO: a brief overview of what you can do to implement this method is given below:

        //1) determine (and store) the distinct owls in the other population.

        //2) make a new data array to hold the correct number of owls for the merged population

        //3) copy over the distinct owls from each population to the data array

        //4) set the new data array to "this" data (where is the merged population? what happens to the original populations?)
    }

    public int popSize(){
        return data.length;
    }

    public static void main(String[] args) {
        try {

            //The following should run when you are complete. Feel free to comment out as you see fit while you work.
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");
            System.out.println(pop1);
            System.out.println(pop1.popSize());

            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");
            System.out.println(pop2);
            System.out.println(pop2.popSize());

            pop1.merge(pop2);
            System.out.println(pop1);
            System.out.println(pop1.popSize());
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }


}
