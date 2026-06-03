import Entities.Employee;
import Services.EmployeeService;

import java.lang.classfile.constantpool.FloatEntry;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Employee Payroll System.");

        EmployeeService service=new EmployeeService();
        service.readEmployeeData();
        service.writeEmployeeData();
    }
}