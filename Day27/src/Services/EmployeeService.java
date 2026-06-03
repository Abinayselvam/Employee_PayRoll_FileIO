package Services;
import java.nio.file.Files;
import java.nio.file.Paths;
import Entities.Employee;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeService {
    ArrayList<Employee> employees=new ArrayList<>();
    public void readEmployeeData()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the ID:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name:");
        String name=sc.nextLine();
        System.out.println("Enter the salary:");
        double salary=sc.nextDouble();
        Employee employee=new Employee(id,name,salary);
        employees.add(employee);

    }
    public void writeEmployeeData()
    {
       System.out.println("Employee PayRoll data:");
       employees.forEach(System.out::println);
    }
    public void readFile()

            throws Exception {

        Files.lines(

                        Paths.get(
                                "EmployeeData/payroll.txt"
                        )
                )

                .map(

                        line -> line.split("\\|")
                )

                .forEach(

                        data -> System.out.println(

                                "Name : "

                                        +

                                        data[1]
                        )
                );
    }


    public void writeToFile()

            throws IOException {

        FileWriter writer =

                new FileWriter(
                        "EmployeeData/payroll.txt"
                );

        for (EmployeePayroll emp
                : employees) {

            writer.write(

                    emp.toString()

                            +

                            System.lineSeparator()
            );
        }

        writer.close();
    }

    public void printData()

            throws Exception {

        Files.lines(

                        Paths.get(
                                "EmployeeData/payroll.txt"
                        )
                )

                .forEach(
                        System.out::println
                );
    }
    public long countEntries()

            throws Exception {

        return Files.lines(

                        Paths.get(
                                "EmployeeData/payroll.txt"
                        )
                )

                .count();

    }

}
