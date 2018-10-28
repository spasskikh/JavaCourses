package model;

import model.entity.*;

import java.util.List;

public class Model {

    private List<Bank> banks;

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }


    public void modifyLimit(Loan loan, int limit) {
        loan.setLimit(limit);
    }
}
