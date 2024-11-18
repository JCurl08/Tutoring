package main.model.member;

import main.model.client.Client;

import java.util.List;

public class Department extends Member {
    private List<Member> members;

    // Creates a new department with name and an empty list of members
    public Department(String concernedApe) {
        super(concernedApe);
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
        Member memberToRemove = null;
        for (Member member : this.members) {
            if (member.getName().equals(memberName)) {
                memberToRemove = member;
                break;
            }
        }
        if (memberToRemove != null) {
            this.members.remove(memberToRemove);
            if (memberToRemove.getSalaryCosts() > 100000) {
                this.notifyClients("Please welcome " + memberToRemove.getName() + " to the " + this.getName() + " department");
            }
        }
    }

    @Override
    public int getSalaryCosts() {
        int result = 0;
        for (Member member : this.members) {
            result += member.getSalaryCosts();
        }
        return result;
    }

    @Override
    public void notifyClients(String message) {
        for (Member member : this.members) {
            member.notifyClients(message);
        }
        for (Client client : getClients()) {
            client.update(message);
        }
    }
}
