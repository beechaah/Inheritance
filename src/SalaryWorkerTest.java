import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest
{
    SalaryWorker salaryWorker;

    @BeforeEach
    void setUp()
    {
        salaryWorker = new SalaryWorker("John", "Doe", "000001", "Mr.", 1990, 19.00, 75000.00);
    }

    @Test
    void calculateWeeklyPay()
    {
        // Extracted constant for readability
        final double EXPECTED_WEEKLY_PAY = 75000.0 / 52;

        // Test the fixed weekly pay
        assertEquals(EXPECTED_WEEKLY_PAY, salaryWorker.calculateWeeklyPay(40)); // Fixed weekly pay regardless of hours worked
        assertEquals(EXPECTED_WEEKLY_PAY, salaryWorker.calculateWeeklyPay(50)); // Same pay even for overtime
        assertEquals(EXPECTED_WEEKLY_PAY, salaryWorker.calculateWeeklyPay(0));  // Pay remains the same even if no hours worked
    }


    @Test
    void displayWeeklyPay()
    {
        // Define constants for clarity and reuse
        final double WEEKLY_PAY = 75000.0 / 52;
        final String EXPECTED_OUTPUT = String.format("Weekly Pay: $%.2f (based on annual salary)%n", WEEKLY_PAY);

        // Capture the output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Call the method
        salaryWorker.displayWeeklyPay(45);

        // Verify the output
        assertEquals(EXPECTED_OUTPUT, outContent.toString());

        // Reset the output stream
        System.setOut(System.out);
    }

}
