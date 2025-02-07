public class Worker extends Person
{
    public double hourlyPayRate;
    public String title;

    public Worker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate)
    {
        super(firstName, lastName, ID, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked)
    {
        double regularHours = Math.min(hoursWorked, 40);
        double overtimeHours = Math.max(hoursWorked - 40, 0);
        return (regularHours * hourlyPayRate) + (overtimeHours * hourlyPayRate * 1.5);
    }

    public void displayWeeklyPay(double hoursWorked)
    {
        double regularHours = Math.min(hoursWorked, 40);
        double overtimeHours = Math.max(hoursWorked - 40, 0);
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        double totalPay = regularPay + overtimePay;

        System.out.printf("Regular Hours: %.2f, Regular Pay: $%.2f%n", regularHours, regularPay);
        System.out.printf("Overtime Hours: %.2f, Overtime Pay: $%.2f%n", overtimeHours, overtimePay);
        System.out.printf("Total Pay: $%.2f%n", totalPay);
    }

    public String toJSONRecord()
    {
        String retString = "";
        char DQ = '\u0022';
        retString =  "{" + DQ + "IDNum" + DQ + ":" + DQ + this.IDNum + DQ + ",";
        retString += DQ + "firstName" + DQ + ":" + DQ + this.firstName + DQ + ",";
        retString += " " + DQ + "lastName"  + DQ + ":" + DQ + this.lastName + DQ + ",";
        retString += " " + DQ + "title" + DQ + ":" + DQ + this.title + DQ + ",";
        retString += " " + DQ + "hourlyPayRate" + DQ + ":" + DQ + this.hourlyPayRate + DQ + ",";
        retString += " " + DQ + "YOB"  + DQ + ":" + this.YOB + "}";

        return retString;
    }

    public String toXMLRecord()
    {
        String retString = "";

        retString = "<Person>" + "<IDNum>" + this.IDNum + "</IDNum>";
        retString += "<firstName>" + this.firstName + "</firstName>";
        retString += "<lastName>" + this.lastName + "</lastName>";
        retString += "<title>" + this.title + "</title>";
        retString += "<hourlyPayRate>" + this.hourlyPayRate + "</hourlyPayRate>";
        retString += "<YOB>" + this.YOB + "</YOB></Person>";

        return retString;
    }

    public String toCSVRecord()
    {
        return  this.IDNum + ", " + this.firstName + "," + this.lastName + "," + this.title + "," + this.hourlyPayRate + "," + this.YOB;
    }

}
