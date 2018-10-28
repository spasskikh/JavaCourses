package model.entity;

import java.util.List;

public class Bank {

    private String name;
    private List<Loan> loans;

    public Bank(String name, List<Loan> loans) {
        this.name = name;
        this.loans = loans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + ":\n");
        for (Loan l : loans) {
            sb.append(l).append('\n');
        }
        return sb.toString();
    }
}
