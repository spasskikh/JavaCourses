package model.entity;

public class Mortgage extends Loan {

    private int pledge;

    public Mortgage(int limit, int pledge) {
        super(limit);
        this.pledge = pledge;
    }

    public int getPledge() {
        return pledge;
    }

    public void setPledge(int pledge) {
        this.pledge = pledge;
    }

    @Override
    public String toString() {
        return super.toString() + ", pledge = " + pledge;
    }
}
