package main.model.member;

import main.model.client.Client;

import static java.lang.Math.abs;

public class Employee extends Member {
    private int salary;
    private String position;

    // Creates new Employee with name and salary
    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;
        this.position = "";
    }

    // Creates new Employee with name and default salary of 50000
    public Employee(String name) {
        this(name, 50000);
    }

    // getters and setters
    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
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
        if (!this.getName().equals(employee.getName())) {
            return false;
        }
        return this.getSalaryCosts() == employee.getSalaryCosts();
    }

    // Define a reasonable hashCode function based on the conditions of equals
    @Override
    public int hashCode() {
        int hashCode = this.getName().hashCode();
        return hashCode + this.getSalaryCosts();
    }
}
