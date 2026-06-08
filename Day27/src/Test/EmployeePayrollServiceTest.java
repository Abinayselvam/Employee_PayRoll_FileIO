package Test;
import Entities.Employee;
import Services.EmployeeService;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeePayrollServiceTest {

    @Test
    void given3Employees_WhenWrittenToFile_ShouldMatchEntries()
            throws IOException {

        EmployeeService service = new EmployeeService();

        service.addEmployee(
                new Employee(
                        1,
                        "Abi",
                        50000
                )
        );

        service.addEmployee(
                new Employee(
                        2,
                        "John",
                        60000
                )
        );

        service.addEmployee(
                new Employee(
                        3,
                        "Sam",
                        70000
                )
        );

        String fileName = "payroll.txt";

        service.writeEmployeePayrollToFile(
                fileName
        );

        long entries =
                service.countEntries(
                        fileName
                );

        assertEquals(
                3,
                entries
        );
    }
    @Test
    void givenEmployeePayrollFile_WhenRead_ShouldReturnThreeEntries()
            throws IOException {

        EmployeeService service =
                new EmployeeService();

        service.addEmployee(
                new Employee(
                        1,
                        "Abi",
                        50000
                )
        );

        service.addEmployee(
                new Employee(
                        2,
                        "John",
                        60000
                )
        );

        service.addEmployee(
                new Employee(
                        3,
                        "Sam",
                        70000
                )
        );

        String fileName =
                "payroll.txt";

        service.writeEmployeePayrollToFile(
                fileName
        );

        assertEquals(
                3,
                service.readPayrollFile(
                        fileName
                ).size()
        );
    }
}