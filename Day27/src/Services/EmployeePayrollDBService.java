package Services;
import Entities.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {


    private static final String URL =
            "jdbc:mysql://localhost:3306/payroll_service";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }

    // CREATE

    public void addEmployee(
            String name,
            char gender,
            double salary,
            String startDate) {

        String query =

                "INSERT INTO employee_payroll " +
                        "(name,gender,salary,start) " +
                        "VALUES(?,?,?,?)";

        try(Connection connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(query)) {

            statement.setString(1, name);
            statement.setString(2, String.valueOf(gender));
            statement.setDouble(3, salary);
            statement.setDate(
                    4,
                    Date.valueOf(startDate)
            );

            statement.executeUpdate();

            System.out.println(
                    "Employee Added Successfully"
            );

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // READ ALL

    public List<Employee> displayEmployees() {
        List<Employee> emp = new ArrayList<>();
        String query = "select * from employee_payroll";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet rs = statement.executeQuery();
        ){
            while (rs.next())
            {
                emp.add(new Employee( rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary")));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return  emp;

    }

    // READ BY NAME

    public Employee getEmployeeByName(
            String employeeName) {

        String query =

                "SELECT * FROM employee_payroll " +
                        "WHERE name=?";

        try(Connection connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(query)) {

            statement.setString(
                    1,
                    employeeName
            );

            ResultSet rs =
                    statement.executeQuery();

            while(rs.next()) {

                System.out.println(

                        rs.getInt("id")
                                + " | " +

                                rs.getString("name")
                                + " | " +

                                rs.getDouble("salary")
                );
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
        return null;
    }

    // UPDATE SALARY

    public void updateSalary(
            String name,
            double salary) {

        String query =

                "UPDATE employee_payroll " +
                        "SET salary=? " +
                        "WHERE name=?";

        try(Connection connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(query)) {

            statement.setDouble(
                    1,
                    salary
            );

            statement.setString(
                    2,
                    name
            );

            int rows =
                    statement.executeUpdate();

            System.out.println(
                    rows +
                            " Row Updated"
            );

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // DELETE

    public void deleteEmployee(
            String name) {

        String query =

                "DELETE FROM employee_payroll " +
                        "WHERE name=?";

        try(Connection connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(query)) {

            statement.setString(
                    1,
                    name
            );

            int rows =
                    statement.executeUpdate();

            System.out.println(
                    rows +
                            " Row Deleted"
            );

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // UC7 FUNCTIONS

    public void getSalarySumByGender() {

        String query =

                "SELECT gender,SUM(salary) total " +
                        "FROM employee_payroll " +
                        "GROUP BY gender";

        executeAggregate(query);
    }

    public void getAverageSalaryByGender() {

        String query =

                "SELECT gender,AVG(salary) total " +
                        "FROM employee_payroll " +
                        "GROUP BY gender";

        executeAggregate(query);
    }

    public void getMinSalaryByGender() {

        String query =

                "SELECT gender,MIN(salary) total " +
                        "FROM employee_payroll " +
                        "GROUP BY gender";

        executeAggregate(query);
    }

    public void getMaxSalaryByGender() {

        String query =

                "SELECT gender,MAX(salary) total " +
                        "FROM employee_payroll " +
                        "GROUP BY gender";

        executeAggregate(query);
    }

    public void getCountByGender() {

        String query =

                "SELECT gender,COUNT(*) total " +
                        "FROM employee_payroll " +
                        "GROUP BY gender";

        executeAggregate(query);
    }

    private void executeAggregate(
            String query) {

        try(Connection connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(query);
            ResultSet rs =
                    statement.executeQuery()) {

            while(rs.next()) {

                System.out.println(

                        rs.getString("gender")
                                + " -> " +

                                rs.getDouble("total")
                );
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
    public boolean checkEmployeeInSync(
            String name,
            double salary)
    {
        Employee employee =
                getEmployeeByName(name);

        return employee != null &&
                employee.getSalary() == salary;
    }
}