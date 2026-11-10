import java.time.LocalDateTime;

public class Employee {

    // Private instance variables
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    // Time tracking variables
    private LocalDateTime punchInTime;

    // Constructor
    public Employee(int employeeId, String name, String department,
                    double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    // punchIn using a specified hour
    public void punchIn(int time) {
        punchInTime = LocalDateTime.now()
                .withHour(time)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        System.out.println("Punched in at "
                + punchInTime.getHour() + ":"
                + String.format("%02d", punchInTime.getMinute()));
    }

    // punchIn using current date and time
    public void punchIn() {
        punchInTime = LocalDateTime.now();

        System.out.println("Punched in at "
                + punchInTime.getHour() + ":"
                + String.format("%02d", punchInTime.getMinute()));
    }

    // punchOut using a specified hour
    public void punchOut(int time) {

        if (punchInTime != null) {

            LocalDateTime punchOutTime = LocalDateTime.now()
                    .withHour(time)
                    .withMinute(0)
                    .withSecond(0)
                    .withNano(0);

            double workedHours =
                    (punchOutTime.getHour() + punchOutTime.getMinute() / 60.0)
                            - (punchInTime.getHour() + punchInTime.getMinute() / 60.0);

            hoursWorked += workedHours;

            System.out.println("Punched out at "
                    + punchOutTime.getHour() + ":"
                    + String.format("%02d", punchOutTime.getMinute()));

            punchInTime = null;
        }
    }

    // punchOut using current date and time
    public void punchOut() {

        if (punchInTime != null) {

            LocalDateTime punchOutTime = LocalDateTime.now();

            double workedHours =
                    (punchOutTime.getHour() + punchOutTime.getMinute() / 60.0)
                            - (punchInTime.getHour() + punchInTime.getMinute() / 60.0);

            hoursWorked += workedHours;

            System.out.println("Punched out at "
                    + punchOutTime.getHour() + ":"
                    + String.format("%02d", punchOutTime.getMinute()));

            punchInTime = null;
        }
    }

    // Derived getter: Regular hours
    public double getRegularHours() {
        return Math.min(hoursWorked, 40);
    }

    // Derived getter: Overtime hours
    public double getOvertimeHours() {
        return Math.max(hoursWorked - 40, 0);
    }

    // Derived getter: Total pay
    public double getTotalPay() {
        return (getRegularHours() * payRate)
                + (getOvertimeHours() * payRate * 1.5);
    }
}