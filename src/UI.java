public class UI {
    /**
     * Print number of separated char (-).
     *
     * @param numOfChar number of separated "-" char
     */
    public static void printSeparatedLine(int numOfChar) {
        for (int i = 0; i < numOfChar; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Print title of the display result table.
     */
    public static void printTitle() {
        //                   id| name |age|pay |date|dept|off|ot   |pos |salary
        System.out.printf("%-5s%-20s%-5s%-10s%-15s%-15s%-10s%-15s%-20s%-15s",
                "ID", "Name", "Age", "Pay Rate", "Enter Date", "Department", "Day-off", "Overtime", "Position", "Salary");
        System.out.println();
        printSeparatedLine(130);
    }

    /**
     * Prints message when user inputs an invalid value.
     */
    public static void printInvalidMessage() {
        System.out.println("Invalid input. Please try again.");
    }

}
