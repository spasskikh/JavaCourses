package model.entity;

public class Personal extends Loan {

    private LoanPurpose purpose;

    public Personal(int limit, LoanPurpose purpose) {
        super(limit);
        this.purpose = purpose;
    }

    public LoanPurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(LoanPurpose purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return super.toString() + ", purpose = " + purpose;
    }
}
