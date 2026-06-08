import Services.EmployeePayrollDBService;

import java.sql.*;

public class DBTest {
public static void main(String[] args)
{
    EmployeePayrollDBService service =
            new EmployeePayrollDBService();

    service.displayEmployees();

    service.addEmployee(
            "Abi",
            'F',
            50000,
            "2025-06-10"
    );

    service.updateSalary(
            "Abi",
            60000
    );

    service.getEmployeeByName(
            "Abi"
    );

    service.getSalarySumByGender();

    service.deleteEmployee(
            "Abi"
    );

}

}