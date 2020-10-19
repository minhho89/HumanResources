import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class holds general data of managers
 */
public class Manager extends Staff implements ICalculator {
    private String position;

    public Manager(String id, String name, String position, int age, double payRate, LocalDate startDate, Department department, int numDayOff) {
        super(id, name, age, payRate, startDate, department, numDayOff);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

        return String.format("%-10s%-20s%-10d%-10s%-20s%-20s%-35d%-20s",
                this.getId(), this.getName(), this.getAge(), df.format(this.getPayRate()),
                strDate, deptName, this.getNumDayOff(), this.getPosition());

    }

    @Override
    public double calculateSalary() {
        double responsibleWage = 0.0;
        switch (this.position) {
            case "Business Leader":
                responsibleWage = 8_000_000;
                break;
            case "Project Leader":
                responsibleWage = 5_000_000;
                break;
            case "Technical Leader":
                responsibleWage = 6_000_000;
                break;
            default:
                responsibleWage = 0.0;
                break;
        }
        return (this.getPayRate() * 5_000_000 + responsibleWage);
    }

}
