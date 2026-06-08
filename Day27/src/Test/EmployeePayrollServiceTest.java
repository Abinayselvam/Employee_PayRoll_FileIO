//package Test;
//import Entities.Employee;
//import Services.EmployeeService;
//import java.io.IOException;
//import static org.junit.Assert.assertEquals;
//
//public class EmployeePayrollServiceTest {
//
//    @Test
//    void given3Employees_WhenWrittenToFile_ShouldMatchEntries()
//
//            throws IOException {
//
//        EmployeeService service =
//
//                new EmployeeService();
//
//        service.addEmployee(
//
//                new Employee(
//                        1,
//                        "Abi",
//                        50000
//                )
//        );
//
//        service.addEmployee(
//
//                new Employee(
//                        2,
//                        "John",
//                        60000
//                )
//        );
//
//        service.addEmployee(
//
//                new Employee(
//                        3,
//                        "Sam",
//                        70000
//                )
//        );
//
//        String fileName =
//                "payroll.txt";
//
//        service.writeEmployeePayrollToFile(
//                fileName
//        );
//
//        long entries =
//
//                service.countEntries(
//                        fileName
//                );
//
//        assertEquals(
//                3,
//                entries
//        );
//    }
//}