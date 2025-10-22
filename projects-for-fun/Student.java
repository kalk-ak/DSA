public class Student implements Person {
    private String id;
    private String name;
    private int age;
    public Student (String i, String n, int a){
        id = i;
        name = n;
        age = a;
    }
    protected int studyHours(){ return age / 2;}

    public String getId(){ return id;}
    public String getName(){ return name;}
    public int getAge(){ return (Integer) age;}

    public boolean equals (Person other){
        if (!(other instanceof Student )) return false;
        Student s = (Student) other;
        return id.equals(s.id);
    }

    @Override
    public String toString() {
        return "Student ID: " + id +
                "\nName: " + name +
                "\nAge: " + age;

    }
}
