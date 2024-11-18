package main.model.business;

import main.model.member.Department;
import main.model.member.Employee;
import main.model.member.Member;

public class Business {
    private static Business business;
    private Employee ceo;
    private Department employees;

    // Creates a new business with ceo and employees contained within the department of name
    // sets ceo's position to ceo and adds it to employees
    private Business(Employee ceo, String name) {
        this.ceo = ceo;
        ceo.setPosition("CEO");
        this.employees = new Department(name);
        this.employees.addMember(ceo);
    }

    // MODIFIES: this
    // EFFECTS: if business is null, creates a new instance of business with:
    // ceo a new employee named Eric Barone with salary of 250,000
    // employees a new department called Concerned Ape
    // and sets it to business
    // returns instance of business
    public static Business getInstance() {
        if (Business.business == null) {
            Business.business = new Business(new Employee("Eric Barone", 250000),
                    "Concerned Ape");
        }
        return Business.business;
    }

    // MODIFIES: this, newCEO
    // EFFECTS: updates newCEO's position to ceo and sets ceo to newCEO,
    // updates old ceo's position to "default"
    // Notifies all the business' clients of the change with the given message:
    // "Congratulations to _____ on becoming the new CEO"
    public void changeCEO(Employee newCEO) {
        this.ceo.setPosition("default");
        newCEO.setPosition("CEO");
        this.ceo = newCEO;
        this.employees.notifyClients("Congratulations to " + newCEO.getName() + " on becoming the new CEO");
    }

    // MODIFIES: this
    // EFFECTS: adds member to employees
    public void addMember(Member member) {
        this.employees.addMember(member);
    }

    // MODIFIES: this
    // EFFECTS: removes the given member from the business
    public void removeMember(String member) {
        this.employees.removeMember(member);
    }
}
