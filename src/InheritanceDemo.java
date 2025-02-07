import java.util.ArrayList;

public class InheritanceDemo
{
    public static void main(String[] args)
    {
        ArrayList<Worker> workers = new ArrayList<>();

        workers.add(new Worker("Alice", "Smith", "000001", "Ms.", 1990, 15.0));
        workers.add(new Worker("Bob", "Jones", "000002", "Mr.", 1985, 18.0));
        workers.add(new Worker("Charlie", "Brown", "000003", "Mr.", 1992, 20.0));

        workers.add(new SalaryWorker("David", "Wilson", "000004", "Dr.", 1980, 52000, 57000.00));
        workers.add(new SalaryWorker("Eve", "Taylor", "000005", "Mrs.", 1987, 60000, 100000.00));
        workers.add(new SalaryWorker("Ally", "Faris", "000006", "Mrs.", 1991, 19.00, 75000.00));


        int[] weeklyHours = {40, 50, 40};

        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s%n", "Name", "ID", "Week 1", "Week 2", "Week 3", "Total Pay");

        for (Worker worker : workers)
        {
            double totalPay = 0.0;
            System.out.printf("%-10s %-10s ", worker.firstName + " " + worker.lastName, worker.IDNum);
            for (int week = 0; week < 3; week++)
            {
                double weeklyPay = worker.calculateWeeklyPay(weeklyHours[week]);
                totalPay += weeklyPay;
                System.out.printf("%-10.2f ", weeklyPay);
            }
            System.out.printf("%-10.2f%n", totalPay);
        }
    }
}
