package model.entity;

public abstract class Loan {

    private int account;
    private boolean earlyRepayment;
    private int limit;

    public Loan(int limit) {
        this.account = (int) (Math.random() * 1_000_000);
        this.earlyRepayment = false;
        this.limit = limit;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public boolean isEarlyRepayment() {
        return earlyRepayment;
    }

    public void setEarlyRepayment(boolean earlyRepayment) {
        this.earlyRepayment = earlyRepayment;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": account = " + account + ", limit = " + limit;
    }
}
