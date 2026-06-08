package Services;
import java.nio.file.Files;
import java.nio.file.Paths;
import Entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeService {
    private List<Employee> employeeList =
            new ArrayList<>();

    public void addEmployee(
            Employee employee) {

        employeeList.add(employee);
    }

    public void writeEmployeePayrollToConsole() {

        System.out.println(
                "Employee Payroll Data"
        );

        employeeList.forEach(
                System.out::println
        );
    }

    public void writeEmployeePayrollToFile(
            String fileName)

            throws IOException {

        Files.write(

                Paths.get(fileName),

                employeeList
                        .stream()
                        .map(Employee::toString)
                        .toList()
        );
    }

    public long countEntries(
            String fileName)

            throws IOException {

        return Files.lines(

                Paths.get(fileName)
        ).count();
    }

    public void printPayrollFile(
            String fileName)

            throws IOException {

        Files.lines(

                Paths.get(fileName)
        ).forEach(
                System.out::println
        );
    }

    public List<String> readPayrollFile(
            String fileName)

            throws IOException {

        return Files.readAllLines(
                Paths.get(fileName)
        );
    }

}
