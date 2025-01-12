package main.model.member;

import main.model.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Department extends Member {
    private List<Member> members;

    // Creates a new department with name and an empty list of members
    public Department(String name) {
        super(name);
        this.members = new ArrayList<>();
    }

    @Override
    public int getSalaryCosts() {
        int result = 0;
        for (Member member : members) {
            result += member.getSalaryCosts();
        }
        return result;
    }

    @Override
    public void notifyClients(String message) {
        for (Client client : this.getClients()) {
            client.update(message);
        }
        for (Member member : members) {
            member.notifyClients(message);
        }
    }

    // Adds member to members
    // addition of important members (those with salaryCosts > 100,000) will cause clients of this to be notified
    // with the message "Please welcome ____ to the ____ department" with the first blank being member name and the
    // second being the name of this.
    public void addMember(Member member) {
        this.members.add(member);
        if (member.getSalaryCosts() > 100000) {
            this.notifyClients("Please welcome " + member.getName() + " to the " + this.getName() + " department");
        }
    }

    // removes the first occurrence of member with the name member from members
    // removal of important members (those with salaryCosts > 100,000) will cause clients of this to be notified
    // with the message "Please say goodbye to ____ from the ____ department" with the first blank being member name and the
    // second being the name of this.
    public void removeMember(String memberName) {
        Member memberToBeRemoved = null;
        for (Member member : members) {
            if (member.getName() == memberName) {
                memberToBeRemoved = member;
                break;
            }
        }
        if (memberToBeRemoved != null) {
            members.remove(memberToBeRemoved);
            if (memberToBeRemoved.getSalaryCosts() > 100000) {
                notifyClients("Please say goodbye to " + memberToBeRemoved.getName() + " from the " + this.getName() + " department");
            }
        }
    }
}
