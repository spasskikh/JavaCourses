package model.entity;

public class CreditCard extends Loan {

    private CardType cardType;

    public CreditCard(int limit, CardType cardType) {
        super(limit);
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return super.toString() +", card type = " + cardType;
    }
}
