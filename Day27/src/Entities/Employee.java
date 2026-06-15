package Entities;

public class Employee {
<<<<<<< Updated upstream
    public int id;
    public String name;
    public double salary;
    public Employee(int id,String name,double salary)
    {
        this.id= id;
        this.name=name;
        this.salary=salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString()
    {
        return id+" | "+name+" | "+salary;
=======
    private int id;
    private String name;
    private double salary;



    public Employee(
            int id,
            String name,
            double salary) {

        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
>>>>>>> Stashed changes
    }
}
