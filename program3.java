import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

class Person {
    protected String name;
    protected LocalDate dob;

    public Person(String name, String dobStr) {
        this.name = name;
        this.dob = parseDate(dobStr);
    }

    private LocalDate parseDate(String dateStr) {
        try {
            if (dateStr.indexOf('-') == 4) {
                return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } else {
                return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format: " + dateStr);
        }
    }

    public void displayName() {
        System.out.println("Name: " + name);
    }

    public void displayAge() {
        LocalDate now = LocalDate.now();
        int age = Period.between(dob, now).getYears();
        System.out.println("Age: " + age);
    }
}

class Employee extends Person {
    private String empId;
    private double salary;

    public Employee(String name, String dobStr, String empId, double salary) {
        super(name, dobStr);
        this.empId = empId;
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        displayName();
        displayAge();
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: $" + salary);
    }
}

public class program3 {
    public static void main(String[] args) {
        Employee emp = new Employee("John Doe", "15-05-1990", "EMP102", 75000);
        emp.displayEmployeeDetails();
    }
}
