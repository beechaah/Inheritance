public class SalaryWorker extends Worker
{
    private double annualSalary;

    public SalaryWorker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate, double annualSalary) {
        super(firstName, lastName, ID, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked)
    {
        return annualSalary / 52;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked)
    {
        double weeklyPay = annualSalary / 52;
        System.out.printf("Weekly Pay: $%.2f (based on annual salary)%n", weeklyPay);
    }

    public String toJSONRecord()
    {
        String retString = "";
        char DQ = '\u0022';
        retString =  "{" + DQ + "IDNum" + DQ + ":" + DQ + this.IDNum + DQ + ",";
        retString += DQ + "firstName" + DQ + ":" + DQ + this.firstName + DQ + ",";
        retString += " " + DQ + "lastName"  + DQ + ":" + DQ + this.lastName + DQ + ",";
        retString += " " + DQ + "title" + DQ + ":" + DQ + this.title + DQ + ",";
        retString += " " + DQ + "hourlyPayRate" + DQ + ":" + DQ + this.hourlyPayRate + DQ + ',';
        retString += " " + DQ + "annualSalary" + DQ + ":" + DQ + this.annualSalary + DQ + ",";
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
        retString += "<annualSalary>" + this.annualSalary + "</annualSalary>";
        retString += "<YOB>" + this.YOB + "</YOB></Person>";

        return retString;
    }

    public String toCSVRecord()
    {
        return  this.IDNum + ", " + this.firstName + "," + this.lastName + "," + this.title + "," + this.hourlyPayRate + "," + this.annualSalary + "," + this.YOB;
    }

}
