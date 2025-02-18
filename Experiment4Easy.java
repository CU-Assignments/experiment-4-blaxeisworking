import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class Exp4easy {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. add employe");
            System.out.println("2. update employe");
            System.out.println("3. remove employe");
            System.out.println("4. search employe");
            System.out.println("5. display all employe");
            System.out.println("6. exit");
            System.out.print("enter choice");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    displayEmployees();
                    break;
                case 6:
                    System.out.println("exiting");
                    return;
                default:
                    System.out.println("invalid choice");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("enter employe ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("enter employe name: ");
        String name = scanner.nextLine();
        System.out.print("enter employe salary: ");
        double salary = scanner.nextDouble();
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully!");
    }

    private static void updateEmployee() {
        System.out.print("enter employe ID to update: ");
        int id = scanner.nextInt();
        for (Employee emp : employees) {
            if (emp.id == id) {
                scanner.nextLine(); 
                System.out.print("enter new name: ");
                emp.name = scanner.nextLine();
                System.out.print("enter new salary: ");
                emp.salary = scanner.nextDouble();
                System.out.println("employe details updated");
                return;
            }
        }
        System.out.println("employe not found!");
    }

    private static void removeEmployee() {
        System.out.print("enter employe ID to remove: ");
        int id = scanner.nextInt();
        employees.removeIf(emp -> emp.id == id);
        System.out.println("employe removed if existed");
    }

    private static void searchEmployee() {
        System.out.print("enter employe ID to search: ");
        int id = scanner.nextInt();
        for (Employee emp : employees) {
            if (emp.id == id) {
                System.out.println(emp);
                return;
            }
        }
        System.out.println("employe not found!");
    }

    private static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("no employees found.");
            return;
        }
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
