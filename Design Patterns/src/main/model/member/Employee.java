package main.model.member;

import main.model.client.Client;

public class Employee extends Member {
    private int salary;
    private String position;

    // Creates new Employee with name and salary and position "Employee"
    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;
        this.position = "Employee";
    }

    // Creates new Employee with name and default salary of 50000
    public Employee(String name) {
        this(name, 50000);
    }

    @Override
    public int getSalaryCosts() {
        return this.salary;
    }

    @Override
    public void notifyClients(String message) {
        for (Client client : this.getClients()) {
            client.update(message);
        }
    }

    // getters and setters
    public String getPosition() {
        return this.position; // stub
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Returns true in the following conditions:
    // Obj is an instance of Employee
    // this and object have the same name
    // this and object have the same salary
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) obj;
        if (employee.getName() != this.getName()) {
            return false;
        }
        return employee.getSalaryCosts() == this.getSalaryCosts();
    }

    // Define a reasonable hashCode function based on the conditions of equals
    @Override
    public int hashCode() {
        int hashCode = this.getName().hashCode();
        return hashCode + this.getSalaryCosts(); // stub
    }
}
