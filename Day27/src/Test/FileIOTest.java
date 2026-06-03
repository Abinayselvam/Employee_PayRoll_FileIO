
package Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileIOTest {

    @Test
    void givenFile_WhenCreated_ShouldExist() {

        File file =

                new File(
                        "sample.txt"
                );

        assertFalse(
                file.exists()
    }

    @Test
    void givenEmployeeData_WhenWritten_ShouldMatchEntries()

            throws Exception {

        EmployeePayrollService service =

                new EmployeePayrollService();

        service.employees.add(

                new EmployeePayroll(
                        1,
                        "Abinaya",
                        50000
                )
        );

        service.writeToFile();

        long entries =
                service.countEntries();

        assertEquals(
                1,
                entries

        );
    }
}