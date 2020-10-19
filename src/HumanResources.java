import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 *  Program "Human Resource" is an assignment for Project number #4 of subject PRO192x_02_VN.
 *  Requirements: This program helps to manage human resource in a company.
 *  Education unit: Funix University.
 *
 *  @author Nhat-Minh Ho
 *  @studentId FX03283
 *  @email minhhnfx03283@funix.edu.vn
 *  @date 2020-Oct-18
 *
 *  This class holds program's main thread including main() method.
 *
 */
public class HumanResources {
    private static List<Department> departments = new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();
    private static List<Manager> managers = new ArrayList<>();
    private static List<Staff> staffList = new ArrayList<>();

    public static void main(String[] args) {
        addTestData(); //TODO: delete

        greeting();
        displayMenu();
        process();
    }

    private static void addTestData() {
        addDeptTest();
    }

    /**
     * Add data to test
     */
    private static void addDeptTest() {
        //TODO: delete
        Department dept1 = new Department("dept1", "Sale");
        Department dept2 = new Department("dept2", "Tech");
        departments.add(dept1);
        departments.add(dept2);

        //add Managers
        Manager m1 = new Manager("m1","Tom","Business Leader",40, 5.4, LocalDate.of(2000, 1, 30),
                dept1, 10);
        Manager m2 = new Manager("m2","Holland","Project Leader", 30, 3.0, LocalDate.of(2010, 5, 4),
                dept2, 15);
        staffList.add(m1);
        staffList.add(m2);

        //add Employees
        Employee e1 = new Employee("e1","Cris",20,3,LocalDate.of(2020,10,10),dept1,
                20,10.4);
        Employee e2 = new Employee("e2","Tim", 26,3.0,LocalDate.of(2019,11,10),dept2,
                10,20);
        staffList.add(e1);
        staffList.add(e2);

    }


    /**
     * Print greeting lines and program version.
     */
    private static void greeting() {
        System.out.println("Welcome to Human Resource Management Program");
        System.out.println("version 1.0");
        System.out.println("____________________________________________");
    }

    /**
     * Display option menu.
     */
    private static void displayMenu() {
        System.out.println("Please select your command option:");
        System.out.println("1. Display all staff list.");
        System.out.println("2. Display all departments");
        System.out.println("3. Display staff by departments");
        System.out.println("4. Add new staff");
        System.out.println("5. Search staff information by name or stainff ID");
        System.out.println("6. Display salary of all staff in sorted descending order");
        System.out.println("7. Display salary of all staff  sorted ascending order");
        System.out.println("0. Exit program");
    }

    /**
     * This method lets user input option and check the input's validity.
     */
    private static void process() {
        System.out.print("Your choice (0-7): ");
        Scanner scanner = new Scanner(System.in);
        String userChoice = "";

        while (true) {
            userChoice = scanner.next();
            if (!isMainMenuInputValid(userChoice)) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            //TODO: match valid input with proper method
            switch (userChoice) {
                case "1":
                    displayStaffList();
                    break;
                case "2":
                    displayDepartmentList();
                    break;
                case "3":
                    displayStaffByDepartment();
                    break;
                case "4":
                    addNewStaff();
                    break;
                case "5":
                    searchStaff();
                    break;
                case "6":
                    displaySalaryDescendingOrder();
                    break;
                case "7":
                    displaySalaryAscendingOrder();
                    break;
                case "0":
                    System.out.println("Thank you, good bye!");
                    break;
            }
        }

    }

    /**
     * Display all the staff in company with details .
     */
    private static void displayStaffList() {
        System.out.printf("%-10s%-20s%-10s%-10s%-20s%-20s%-20s%-15s%-15S",
                "ID", "Name", "Age", "Pay Rate",
                "Enter Date", "Department", "Day-off Numbers", "Overtime", "Position");
        System.out.println();
//        for (Employee e : employees
//        ) {
//            System.out.println(e.toString());
//        }
//        for (Manager m: managers
//             ) {
//            System.out.println(m.toString());
//        }
        for (Staff f : staffList) {
            System.out.println(f.toString());
        }
    }

    private static void displayDepartmentList() {
        System.out.printf("%-10s%-20s%-20s","ID", "Department Name", "Number of staff");
        System.out.println();
        for (Department d: departments
             ) {
            System.out.println(d.toString());
        }
    }

    private static void displayStaffByDepartment() {

    }

    private static void addNewStaff() {
    }

    private static void searchStaff() {
    }

    private static void displaySalaryDescendingOrder() {
    }

    private static void displaySalaryAscendingOrder() {
    }

    /**
     * Check if user input in mainMenu.
     *
     * @param userChoice user input, valid value is from 0 to 7.
     * @return true if input valid, otherwise returns false.
     */
    private static boolean isMainMenuInputValid(String userChoice) {
        switch (userChoice) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "0":
                return true;
        }
        return false;
    }
}
