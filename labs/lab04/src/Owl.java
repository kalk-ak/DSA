public class Owl {
    private String name;
    private int age;
    private double weight;

    public Owl(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean equals(Owl other) {
        if (this.age == other.age && this.name == other.name && this.weight == other.weight) {
            return true;
        } else {
            return false;
        }
    }

}
