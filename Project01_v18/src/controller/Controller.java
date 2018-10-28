package controller;

import model.entity.*;
import service.Service;
import view.Viewer;

import java.util.List;

public class Controller {

    private Service service;
    private Viewer viewer;

    public Controller() {
        service = new Service();
        viewer = new Viewer();
    }

    public void run() {
        service.init();

        viewer.printMenu();

        int switcher = service.getInput().getInt("Enter an action:");
        while (switcher != 0) {
            switch (switcher) {
                case 1:
                    viewer.printLoans("All information:", service.getAllBanks());
                    switcher = service.getInput().getInt("Enter an action:");
                    break;
                case 2:
                    selectBank();
                    switcher = service.getInput().getInt("Enter an action:");
                    break;
                case 3:
                    selectLoan();
                    switcher = service.getInput().getInt("Enter an action:");
                    break;
                case 4:
                    modifyLoan();
                    switcher = service.getInput().getInt("Enter an action:");
                    break;
                default:
                    viewer.printMessage("Incorrect parameter.");
                    viewer.printMenu();
                    switcher = service.getInput().getInt("Enter an action:");
                    break;
            }
        }
    }

    private void modifyLoan() {
        viewer.printMessage("Available banks: ");
        viewer.printMessage(service.getBanksNames());

        Bank b = service.getBank();
        if (b == null) {
            viewer.printMessage("There is no such a bank.");
            return;
        }

        viewer.printLoans("Available loans (1 - " + b.getLoans().size() + "):", b.getLoans());

        Loan loan = service.getLoan(b);
        if (loan == null) {
            viewer.printMessage("There is no such a loan.");
            return;
        }

        service.modify(loan);
        viewer.printMessage("Updated loan:\n" + loan.toString());

    }

    private void selectLoan() {
        viewer.printMessage("Available loan types:");
        viewer.printMessage(service.getLoansTypes());

        List<String> loans = service.getLoans();

        if (loans.size() == 0) {
            viewer.printMessage("There are no such loans");
            return;
        }
        viewer.printLoans("Found:", loans);


    }

    private void selectBank() {
        viewer.printMessage("Available banks: ");
        viewer.printMessage(service.getBanksNames());

        Bank b = service.getBank();
        if (b == null) {
            viewer.printMessage("There is no such a bank.");
            return;
        }
        viewer.printLoans("Information about " + b.getName(), b.getLoans());
    }

}
