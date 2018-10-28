package model.data;

import model.entity.*;

import java.util.*;

public class DataSource {

    public static List<Bank> getBanks() {
        return new ArrayList<>(
                Arrays.asList(
                        new Bank("PrivatBank",
                                new ArrayList<Loan>(Arrays.asList(new Mortgage(10000, 12000),
                                        new Mortgage(1000, 1200),
                                        new Personal(1200, LoanPurpose.REFINANCE),
                                        new CreditCard(5000, CardType.VISA),
                                        new CreditCard(5000, CardType.MASTER_CARD)
                                ))
                        ),
                        new Bank("CreditBank",
                                new ArrayList<Loan>(Arrays.asList(new Mortgage(15000, 17000),
                                        new Mortgage(1500, 1700),
                                        new Personal(1300, LoanPurpose.REFINANCE),
                                        new CreditCard(4000, CardType.VISA),
                                        new CreditCard(4000, CardType.MASTER_CARD)
                                ))
                        ),
                        new Bank("KredoBank",
                                new ArrayList<Loan>(Arrays.asList(new Mortgage(20000, 18000),
                                        new Mortgage(2000, 1800),
                                        new Personal(1100, LoanPurpose.REFINANCE),
                                        new CreditCard(5000, CardType.VISA),
                                        new CreditCard(5000, CardType.MASTER_CARD)
                                ))
                        ),
                        new Bank("AvalBank",
                                new ArrayList<Loan>(Arrays.asList(new Mortgage(30000, 25000),
                                        new Mortgage(3000, 2500),
                                        new Personal(2000, LoanPurpose.PURCHASE),
                                        new CreditCard(6000, CardType.VISA),
                                        new CreditCard(6000, CardType.MASTER_CARD)
                                ))
                        ),
                        new Bank("UkrSibBank",
                                new ArrayList<Loan>(Arrays.asList(new Mortgage(50000, 55000),
                                        new Mortgage(5000, 5500),
                                        new Personal(2500, LoanPurpose.PURCHASE),
                                        new CreditCard(5000, CardType.VISA),
                                        new CreditCard(5000, CardType.MASTER_CARD)
                                ))
                        )


                ));
    }
}
