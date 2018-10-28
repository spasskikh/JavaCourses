package service;

import model.Model;
import model.data.DataSource;
import model.entity.*;
import util.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Service {

    private Model model;
    private UserInput input;

    public Service() {
        model = new Model();
        input = new UserInput();
    }

    public void init() {
        model.setBanks(DataSource.getBanks());
    }

    public UserInput getInput() {
        return input;
    }

    public List getAllBanks() {
        return model.getBanks();
    }

    public String getBanksNames() {
        StringBuilder sb = new StringBuilder();
        for (Bank b : model.getBanks()) {
            sb.append(b.getName() + " ");
        }
        return sb.toString();
    }

    public String getLoansTypes() {
        Set<String> loans = new TreeSet<>();
        for (Bank b : model.getBanks()) {
            for (Loan l : b.getLoans()) {
                loans.add(l.getClass().getSimpleName());
            }
        }
        return loans.toString();
    }

    public Bank getBank() {
        input.nextLine();
        String bankName = input.getLine("Enter bank name:");

        for (Bank b : model.getBanks()) {
            if (b.getName().equalsIgnoreCase(bankName)) {
                return b;
            }
        }
        return null;
    }

    public List<String> getLoans() {
        input.nextLine();
        String loanType = input.getLine("Enter loan type:");

        List<String> loans = new ArrayList<>();
        for (Bank b : model.getBanks()) {
            for (Loan l : b.getLoans()) {
                if (l.getClass().getSimpleName().equalsIgnoreCase(loanType)) {
                    loans.add(b.getName() + " - " + l.toString());
                }
            }
        }
        return loans;
    }

    public void modify(Loan loan) {
        int limit = input.getInt("Enter new limit:");
        model.modifyLimit(loan, limit);
    }

    public Loan getLoan(Bank b) {
        int index = input.getInt("Enter loan position:");
        if (index <= b.getLoans().size()) {
            return b.getLoans().get(index - 1);
        }
        return null;
    }
}
