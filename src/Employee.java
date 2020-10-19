import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * This class holds general data of Employees
 */
public class Employee extends Staff implements ICalculator {
    private double overtimeHour;

    public Employee(String id, String name, int age, double payRate, LocalDate startDate,
                    Department department, int numDayOff, double overtimeHour) {
        super(id, name, age, payRate, startDate, department, numDayOff);
        this.overtimeHour = overtimeHour;
    }

    public double getOvertimeHour() {
        return overtimeHour;
    }

    public void setOvertimeHour(double overtimeHour) {
        this.overtimeHour = overtimeHour;
    }

    @Override
    public String toString() {
        /* format Date to String in "yyyy-mmm-dd"
        ref. source: https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
         */
        LocalDate localDate = this.getStartDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LLL-dd");
        String strDate = localDate.format(formatter);

        //get Department name value only
        String deptName = this.getDepartment().getName();

        //format double type data
        DecimalFormat df = new DecimalFormat("#.#");

        return String.format("%-10s%-20s%-10d%-10s%-20s%-20s%-20d%-20s",
                this.getId(), this.getName(), this.getAge(), df.format(this.getPayRate()),
                strDate, deptName, this.getNumDayOff(), df.format(this.getOvertimeHour()));
    }

    @Override
    public double calculateSalary() {
        return (this.getPayRate() * 3_000_000 + this.overtimeHour * 200_000);
    }
}
