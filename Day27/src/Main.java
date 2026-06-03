import java.util.Scanner;

public class Main {

    public static void main(String[] args)

            throws Exception {

        System.out.println(
                "Welcome to Employee Payroll Service"
        );

        EmployeePayrollService service =

                new EmployeePayrollService();

        Scanner scanner =
                new Scanner(System.in);

        while(true) {

            System.out.println(
                    "\nChoose Option:"
            );

            System.out.println(
                    "1. Add Employee"
            );

            System.out.println(
                    "2. Display Employees"
            );

            System.out.println(
                    "3. Write To File"
            );

            System.out.println(
                    "4. Print File Data"
            );

            System.out.println(
                    "5. Count Entries"
            );

            System.out.println(
                    "6. Read File Analysis"
            );

            System.out.println(
                    "7. Exit"
            );

            int choice =
                    scanner.nextInt();

            switch(choice) {

                case 1:

                    service.readEmployeeData();
                    break;

                case 2:

                    service.writeEmployeeData();
                    break;

                case 3:

                    service.writeToFile();

                    System.out.println(
                            "Data Written Successfully"
                    );

                    break;

                case 4:

                    service.printData();
                    break;

                case 5:

                    System.out.println(

                            "Entry Count: "

                                    +

                                    service.countEntries()
                    );

                    break;

                case 6:

                    service.readFile();
                    break;

                case 7:

                    System.out.println(
                            "Application Closed"
                    );

                    System.exit(0);

                default:

                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }
    }
}