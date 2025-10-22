/*
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class backup {

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
            int numLines = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                numLines++;
            }
            scanner.close();

            data = new Owl[numLines];
            scanner = new Scanner(f);

            for (int i = 0; scanner.hasNextLine() && i < numLines; i++) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1].trim());
                    double weight = Double.parseDouble(parts[2].trim());
                    data[i] = new Owl(name, age, weight);
                }
            }
            scanner.close();
            return numLines;

        }

        public OwlPopulation(String fileName) throws FileNotFoundException {
            this.fileName = fileName;
            populateData();

        }

        public double averageAge(){
            if (data.length == 0) return 0.0;
            int totalAge = 0;
            for (Owl owl : data) {
                totalAge += owl.getAge();
            }
            return (double) totalAge / data.length;
        }

        public Owl getYoungest(){
            if (data.length == 0) return null;
            Owl youngest = data[0];
            for (Owl owl : data) {
                if (owl.getAge() < youngest.getAge()) youngest = owl;
            }
            return youngest;

        }

        public Owl getHeaviest(){
            if (data.length == 0) return null;
            Owl heaviest = data[0];
            for (Owl owl : data) {
                if (owl.getWeight() > heaviest.getWeight()) heaviest = owl;
            }
            return heaviest;
        }

        public String toString(){
            Owl youngest = getYoungest();
            Owl heaviest = getHeaviest();
            return String.format("The youngest owl is " + youngest.getName() + ", which is " + youngest.getAge() +" years old.\n" +
                    "The heaviest is " + heaviest.getName() + ", which is " + heaviest.getWeight() + " pounds\n" +
                    "The averegae is " + this.averageAge());

        }

        public boolean containsOwl(Owl other){
            for (Owl owl : data) {
                if (owl.equals(other)) return true;
            }
            return false;
        }

        public void merge(OwlPopulation other) {
            for (Owl owl : other.data) {
                if (!containsOwl(owl)) {
                    data = java.util.Arrays.copyOf(data, data.length + 1);
                    data[data.length - 1] = owl;
                }
            }
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



}
*/
