package Services;

import Entities.Employee;

import java.util.ArrayList;
import java.util.Scanner;

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

}
