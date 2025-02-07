import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest
{
    Worker worker;

    @BeforeEach
    void setUp()
    {
        worker = new Worker("John", "Doe", "000001", "Mr.", 1990, 20.0);
    }

    @Test
    void calculateWeeklyPay()
    {
        // Test regular hours (no overtime)
        assertEquals(800.0, worker.calculateWeeklyPay(40));

        // Test overtime hours
        assertEquals(950.0, worker.calculateWeeklyPay(45));

        // Test no hours worked
        assertEquals(0.0, worker.calculateWeeklyPay(0));

        // Test edge case: exactly 40 hours
        assertEquals(800.0, worker.calculateWeeklyPay(40));
    }

    @Test
    void displayWeeklyPay()
    {
        // Capture the output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Call the method
        worker.displayWeeklyPay(45);

        // Verify the output
        String expectedOutput = "Regular Hours: 40.00, Regular Pay: $800.00\n" +
                "Overtime Hours: 5.00, Overtime Pay: $150.00\n" +
                "Total Pay: $950.00\n";

        // Reset the output stream
        System.setOut(System.out);
    }
}
