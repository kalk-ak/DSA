public class Employee  {
    private String name;
    private double salary;
    private int id;
    static int idS;
    private double incomeReceived;
    private double taxPaid;
    private int[] payDate = {01, 01};


    public Employee(){}
    public Employee(String s,double salary) {
        name = s;
        this.salary = salary;
        id = idS++;
    }
    public Employee(String s,double salary, int[] date) {
        name = s;
        this.salary = salary;
        id = idS++;
        payDate = date;
    }


    @Override
    public String toString() {
        return ("" + name + " has  " + salary + "\n" +
                name + " paid " + taxPaid + " in taxes\n" +
                "employee id >> " + id );
    }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public int getId() { return id; }
    public void setSalary(double s) {
        salary = s;
    }
    public void setName(String s) {
        name = s;
    }
    public void setPayDate(int[] date) {
        payDate = date;
    }
    public void setIncomePaid(double s) {
        incomeReceived = s;
        taxPaid = Math.abs(salary - incomeReceived);
    }
    public int[] getPayDate() {
        return payDate;
    }






}
