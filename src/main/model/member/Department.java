package main.model.member;

import java.util.List;

public class Department {
    private List<Member> members;

    // Creates a new department with name and an empty list of members
    public Department(String concernedApe) {
        // stub
    }

    // Adds member to members
    // addition of important members (those with salaryCosts > 100,000) will cause clients of this to be notified
    // with the message "Please welcome ____ to the ____ department" with the first blank being member name and the
    // second being the name of this.
    public void addMember(Member member) {
        // stub
    }

    // removes the first occurrence of member with the name member from members
    // removal of important members (those with salaryCosts > 100,000) will cause clients of this to be notified
    // with the message "Please say goodbye to ____ from the ____ department" with the first blank being member name and the
    // second being the name of this.
    public void removeMember(String memberName) {
        // stub
    }
}
