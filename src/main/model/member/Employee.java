package main.model.member;

public class Employee {
    private int salary;
    private String position;

    // Creates new Employee with name and salary
    public Employee(String name, int salary) {
        // stub
    }

    // Creates new Employee with name and default salary of 50000
    public Employee(String name) {
        this(name, 50000);
    }

    // getters and setters
    public String getPosition() {
        return ""; // stub
    }

    public void setPosition(String position) {
        // stub
    }

    // Returns true in the following conditions:
    // Obj is an instance of Employee
    // this and object have the same name
    // this and object have the same salary
    @Override
    public boolean equals(Object obj) {
        return false; // stub
    }

    // Define a reasonable hashCode function based on the conditions of equals
    @Override
    public int hashCode() {
        return 0; // stub
    }
}
