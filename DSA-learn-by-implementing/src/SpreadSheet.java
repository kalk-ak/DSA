import java.util.Scanner;

public class SpreadSheet {
    private String password;
    private ArrayList<Employee> spreadSheet = new ArrayList<>();

    /**
     * A recursive function that calculates the total someone has to pay based on the
     * Ethiopian tax metrics.
     * @param salary - the total salary of an employee.
     * @return
     */
    private static double payTaxHelper(double salary) {
        double taxRate;
        double taxedIncome;
        double left;

        if (salary == 0)
            return 0;

        if (salary >= 30000) {
            taxRate = 0.35;
            taxedIncome = salary - 30000;
            left = 30000;
        } else if (salary >= 20001) {
            taxRate = 0.3;
            taxedIncome = salary - 20001;
            left = 20000;
        }

        else if (salary >= 10001) {
            taxRate = 0.25;
            taxedIncome = salary - 10001;
            left = 10000;
        }
        else if (salary >= 5001) {
            taxRate = 0.2;
            taxedIncome = salary - 5001;
            left = 5000;
        }
        else if (salary > 2001) {
            taxRate = 0.15;
            taxedIncome = salary - 2001;
            left = 2000;
        }
        else if (salary > 1001) {
            taxRate = 0.1;
            taxedIncome = salary - 1001;
            left = 1000;
        }
        else {
            taxRate = 0;
            taxedIncome = 0;
            left = 0;
        }
        double taxPaid = taxedIncome * taxRate;
        return taxPaid + payTaxHelper(left);

    }

    /**
     * Calculates the salary of the employee after tax deductions and updates their received income.
     *
     * @param e the employee whose tax is being paid
     */
    public static void payTaxes(Employee e) {
        double salary = e.getSalary();

        double taxPaid = payTaxHelper(salary);

        double paidIncome = salary - taxPaid;
        e.setIncomePaid(paidIncome);
    }

    /**
     * Pays employees if date matches their pay date.
     *
     * @param date current date in format {day, month}
     */
    public void payOnDate(int[] date) {
        for (Employee e : spreadSheet) {
            if (date[0] == e.getPayDate()[0] && date[1] == e.getPayDate()[1]) {
                payTaxes(e);
                System.out.println(e);
                System.out.println();
            }
        }
    }

    /**
     * Displays a list of all employees along with their details.
     */
    public void listEmployee() {
        for (Employee e : spreadSheet) {
            System.out.println("Name >> " + e.getName() + "\n" +
                    "Id >> " + e.getId() + "\n" +
                    "Salary >> " + e.getSalary());
            System.out.println();
        }
    }


    /**
     * Main method to interact with users and manage employee data.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SpreadSheet sheet = new SpreadSheet();  // Instantiate SpreadSheet

        while (true) {
            System.out.println("What do you want me to do?");
            System.out.println("1. List all Employees");
            System.out.println("2. Pay salary to employees");
            System.out.println("3. Add new employees");
            System.out.println("4. Delete employees");
            System.out.println("5. Search for employees");
            System.out.println("6. Update employee information");
            System.out.println("7. Exit");


            String input = scanner.nextLine().trim();  // Get user input and trim any whitespace
            int option = 0;

            try {
                option = Integer.parseInt(input);  // Try to convert the input to an integer
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;  // Skip the rest of the loop iteration if the input is not a valid number
            }

            if (option == 1) {
                System.out.println("Listing all employees...");
                if (sheet.spreadSheet.isEmpty())
                    System.out.println("No current employees");
                else
                    sheet.listEmployee();

            } else if (option == 2) {
                int day;
                while (true) {
                    System.out.println("Day salary being paid (format: integer)");
                    input = scanner.nextLine().trim();
                    try {
                        day = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number");
                        continue;
                    }
                    break;
                }
                int month;
                while (true) {
                    System.out.println("Month salary being paid (format: integer)");
                    input = scanner.nextLine().trim();

                    try {
                        month = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number");
                        continue;
                    }
                    break;
                }
                int[] date = {day, month};
                sheet.payOnDate(date);

            } else if (option == 3) {
                System.out.println("Adding new employees...");
                while (true) {
                    String first;
                    String last;
                    double salary;
                    System.out.println("what is the first of the employee >> ");
                    first = scanner.nextLine().trim();
                    System.out.println("what is the last name of the employee >> ");
                    last = scanner.nextLine().trim();
                    System.out.println("what is the salary of the employee >> ");
                    while (true) {
                        input = scanner.nextLine().trim();  // Get user input and trim any whitespace

                        try {
                            salary = Double.parseDouble(input);  // Try to convert the input to an integer
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                            continue;  // Skip the rest of the loop iteration if the input is not a valid number
                        }
                        break;
                    }
                    int day;
                    while (true) {
                        System.out.println("Day salary of employee (format: integer)");
                        input = scanner.nextLine().trim();
                        try {
                            day = Integer.parseInt(input);
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number");
                            continue;
                        }
                        break;
                    }
                    int month;
                    while (true) {
                        System.out.println("Month salary being paid (format: integer)");
                        input = scanner.nextLine().trim();

                        try {
                            month = Integer.parseInt(input);
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number");
                            continue;
                        }
                        break;

                    }
                    int[] date = {day, month};

                    Employee e = new Employee(first + " " + last, salary, date);
                    sheet.spreadSheet.add(e);
                    System.out.println("Employee added successfully");
                    System.out.println("Know that you can update employees whenever you want to");
                    break;

                }
            } else if (option == 4) {
                System.out.println("Deleting employees...");
                String first;
                String last;
                System.out.println("what is the first name of the employee");
                first = scanner.nextLine().trim();
                System.out.println("what is the last name of the employee");
                last = scanner.nextLine().trim();

                String fullName = first + " " + last;
                ArrayList<Integer> found = new ArrayList<>();
                for (int i = 0; i < sheet.spreadSheet.getSize(); i++)
                    if (sheet.spreadSheet.get(i).getName().equals(fullName))
                        found.add(i);

                if (found.isEmpty())
                    System.out.println("No employees found under the given first and last name");
                else if (found.getSize() == 1) {
                    sheet.spreadSheet.remove(found.get(0));
                    System.out.println("Employee removed successfully");
                } else {
                    System.out.println("multiple employees with the same name found");
                    System.out.println("which employee do you want to remove");
                    for (int i = 1; i < found.getSize() + 1; i++) {
                        System.out.println(i + ". " + sheet.spreadSheet.get(found.get(i)).getId());
                    }
                    int index;
                    while (true) {
                        input = scanner.nextLine();

                        try {
                            index = Integer.parseInt(input);
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number");
                            continue;
                        }
                        if (!(index >= 0 && index < found.getSize())) {
                            System.out.println("Please enter a valid number");
                            continue;
                        } else
                            break;
                    }
                    sheet.spreadSheet.remove(found.get(index - 1));
                    System.out.println("Employee removed successfully");
                }
            }
            else if (option == 5) {
                System.out.println("Searching employees...");
                String first;
                String last;
                System.out.println("what is the first name of the employee");
                first = scanner.nextLine().trim();
                System.out.println("what is the last name of the employee");
                last = scanner.nextLine().trim();
                String fullName = first + " " + last;

                ArrayList<Integer> found = new ArrayList<>();
                for (int i = 0; i < sheet.spreadSheet.getSize(); i++)
                    if (sheet.spreadSheet.get(i).getName().equals(fullName))
                        found.add(i);

                if (found.isEmpty())
                    System.out.println("no employees found");
                else {
                    for (int i = 0; i < found.getSize(); i++) {
                        Employee e = sheet.spreadSheet.get(found.get(i));
                        System.out.println("Name >> " + e.getName());
                        System.out.println("Id >> " + e.getId());
                        System.out.println("-----------------------");
                    }
                }
            } else if (option == 6) {
                System.out.println("Updating employees...");
                String first;
                String last;
                double salary;
                System.out.println("what is the first name of the employee");
                first = scanner.nextLine().trim();
                System.out.println("what is the last name of the employee");
                last = scanner.nextLine().trim();
                String fullName = first + " " + last;

                ArrayList<Integer> found = new ArrayList<>();
                for (int i = 0; i < sheet.spreadSheet.getSize(); i++)
                    if (sheet.spreadSheet.get(i).getName().equals(fullName))
                        found.add(i);

                if (found.isEmpty())
                    System.out.println("No employees found, try again");
                else if (found.getSize() == 1) {
                    while (true) {
                        System.out.println("update the first of the employee >>");
                        first = scanner.nextLine().trim();
                        System.out.println("update the last name of the employee >>");
                        last = scanner.nextLine().trim();
                        System.out.println("update the salary of the employee >>");
                        while (true) {
                            input = scanner.nextLine().trim();  // Get user input and trim any whitespace

                            try {
                                salary = Double.parseDouble(input);  // Try to convert the input to an integer
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid number.");
                                continue;  // Skip the rest of the loop iteration if the input is not a valid number
                            }
                            break;
                        }
                        int day;
                        while (true) {
                            System.out.println("update Day salary of employee (format: integer)");
                            input = scanner.nextLine().trim();
                            try {
                                day = Integer.parseInt(input);
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid number");
                                continue;
                            }
                            break;
                        }
                        int month;
                        while (true) {
                            System.out.println("update month salary being paid (format: integer)");
                            input = scanner.nextLine().trim();

                            try {
                                month = Integer.parseInt(input);
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid number");
                                continue;
                            }
                            break;

                        }
                        int[] date = {day, month};
                        Employee e = sheet.spreadSheet.get(found.get(0));
                        e.setName(fullName);
                        e.setPayDate(date);
                        e.setSalary(salary);
                        System.out.println("Employee updated successfully");
                        System.out.println("Know that you can update employees whenever you want to");
                        break;
                    }
                } else {
                    System.out.println("Multiple employees with the same name found");
                    System.out.println("What is the ID of the employee");

                    input = scanner.nextLine().trim();
                    while (true) {
                        int id;
                        while (true) {
                            try {
                                id = Integer.parseInt(input);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input please try again");
                                continue;
                            }
                            break;
                        }
                        Employee e = null;
                        for (int i = 0; i < found.getSize(); i++) {
                            if (sheet.spreadSheet.get(found.get(i)).getId() == id) {
                                e = sheet.spreadSheet.get(found.get(i));
                                break;
                            }
                        }
                        if (e == null) {
                            System.out.println("Invalid ID");
                            continue;
                        }
                        System.out.println("what is the first of the employee >>");
                        first = scanner.nextLine().trim();
                        System.out.println("what is the last name of the employee >>");
                        last = scanner.nextLine().trim();
                        System.out.println("what is the salary of the employee >>");
                        while (true) {
                            input = scanner.nextLine().trim();  // Get user input and trim any whitespace

                            try {
                                salary = Double.parseDouble(input);  // Try to convert the input to an integer
                            } catch (NumberFormatException y) {
                                System.out.println("Please enter a valid number.");
                                continue;  // Skip the rest of the loop iteration if the input is not a valid number
                            }
                            break;
                        }
                        int day;
                        while (true) {
                            System.out.println("Day salary of employee (format: integer)");
                            input = scanner.nextLine().trim();
                            try {
                                day = Integer.parseInt(input);
                            } catch (NumberFormatException y) {
                                System.out.println("Please enter a valid number");
                                continue;
                            }
                            break;
                        }
                        int month;
                        while (true) {
                            System.out.println("Month salary being paid (format: integer)");
                            input = scanner.nextLine().trim();

                            try {
                                month = Integer.parseInt(input);
                            } catch (NumberFormatException y) {
                                System.out.println("Please enter a valid number");
                                continue;
                            }
                            break;

                        }
                        int[] date = {day, month};
                        e.setName(fullName);
                        e.setPayDate(date);
                        e.setSalary(salary);
                        System.out.println("Employee updated successfully");
                        System.out.println("Know that you can update employees whenever you want to");
                        break;
                    }
                }
            } else if (option == 7) {
                System.out.println("program halted");
                sheet.listEmployee();
                return;
            } else {
                System.out.println("Invalid option. Please enter a number between 1 and 6.");
                continue;
            }

        }
    }
}
