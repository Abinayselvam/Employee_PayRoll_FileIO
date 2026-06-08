import Entities.Employee;
import Services.EmployeeService;

import java.io.IOException;
import java.util.Scanner;

public class EmployeePayrollMain {

    public static void main(String[] args)

            throws IOException {

        EmployeeService service =

                new EmployeeService();

        Scanner scanner =
                new Scanner(System.in);

        while(true) {

            System.out.println(

                    "\n1 Add Employee" +

                            "\n2 Display Console" +

                            "\n3 Write To File" +

                            "\n4 Print File" +

                            "\n5 Count Entries" +

                            "\n6 Read File" +

                            "\n7 Exit"
            );

            int choice =
                    scanner.nextInt();

            switch(choice) {

                case 1 -> {

                    System.out.print(
                            "Id : "
                    );

                    int id =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Name : "
                    );

                    String name =
                            scanner.nextLine();

                    System.out.print(
                            "Salary : "
                    );

                    double salary =
                            scanner.nextDouble();

                    service.addEmployee(

                            new Employee(

                                    id,

                                    name,

                                    salary
                            )
                    );
                }

                case 2 ->
                        service
                                .writeEmployeePayrollToConsole();

                case 3 -> {

                    service
                            .writeEmployeePayrollToFile(

                                    "payroll.txt"
                            );

                    System.out.println(
                            "Written Successfully"
                    );
                }

                case 4 ->

                        service
                                .printPayrollFile(

                                        "payroll.txt"
                                );

                case 5 ->

                        System.out.println(

                                "Entries : "

                                        +

                                        service
                                                .countEntries(

                                                        "payroll.txt"
                                                )
                        );

                case 6 ->

                        service
                                .readPayrollFile(

                                        "payroll.txt"
                                )
                                .forEach(
                                        System.out::println
                                );

                case 7 -> {

                    System.exit(0);
                }

                default ->

                        System.out.println(
                                "Invalid Choice"
                        );
            }
        }
    }
}