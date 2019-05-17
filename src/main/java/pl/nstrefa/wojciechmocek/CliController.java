package pl.nstrefa.wojciechmocek;

import pl.nstrefa.wojciechmocek.bank.Bank;
import pl.nstrefa.wojciechmocek.bank.Exception;

import java.util.Scanner;

public class CliController implements Controller {

    private Scanner sc;
    private Bank bank;

    private enum MenuOption {
        LIST_BRANCHES(1), CREATE_BRANCH(2), CREATE_CUSTOMER(3), ADD_TRANSACTION(4),
        EXIT(5);

        private final int value;

        MenuOption(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static MenuOption fromInt(int i) {
            for (MenuOption option : MenuOption.values()) {
                if (option.getValue() == i) {
                    return option;
                }
            }
            throw new IllegalArgumentException("There is no such option");
        }
    }

    public CliController(Bank bank) {
        this.bank = bank;
        this.sc = new Scanner(System.in);
    }

    public void run() {
        MenuOption chosenOption = null;
        do {
            try {
                printMenu();
                chosenOption = MenuOption.fromInt(Integer.valueOf(sc.nextLine()));
                System.out.println();
                switch (chosenOption) {
                    case LIST_BRANCHES:
                        printBranches();
                        break;
                    case CREATE_BRANCH:
                        createBranch();
                        break;
                    case CREATE_CUSTOMER:
                        createCustomer();
                        break;
                    case ADD_TRANSACTION:
                        addTransaction();
                        break;
                    case EXIT:
                        System.exit(0);

                }
            } catch (IllegalArgumentException e) {
                System.out.println("Chosen option is not supported. Please choose correct one");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } while (MenuOption.EXIT != chosenOption);


    }

    public void addTransaction() {
        try {
            System.out.println("Adding transaction.");

            printBranches();
            System.out.print("Please type branch name: ");
            String branchName = sc.nextLine();

            System.out.print("Please enter customer name: ");
            String customerName = sc.nextLine();


            System.out.print("Please enter initial transaction: ");
            double transaction = Double.valueOf(sc.nextLine());

            System.out.printf("Summary:\n" +
                    "Add transaction in branch %s, to customer '%s' with the amount of %f\n" +
                    "Are you sure ? (y/n)",
                branchName, customerName, transaction
            );

            String confirmation = sc.nextLine();
            if (confirmation.equalsIgnoreCase("y")) {
                bank.addTransaction(branchName, customerName, transaction);
                System.out.println("New transaction added.");
            } else {
                System.out.println("New transaction cancelled.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, transaction not added");
        }
        System.out.println("Transaction added");
    }

    public void createCustomer() {
        try {
            System.out.println("Creating new customer.");
            System.out.print("Please enter customer name: ");
            String customerName = sc.nextLine();

            printBranches();
            System.out.print("Please type branch name: ");
            String branchName = sc.nextLine();

            System.out.print("Please enter initial transaction: ");
            double transaction = Double.valueOf(sc.nextLine());

            bank.createAccount(branchName, customerName, transaction);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, customer not created");
        }
        System.out.println("Customer created");
    }

    public void printBranches() {
        System.out.println("Available branches:");
        for (String b : bank.getBranches()) {
            System.out.println("- " + b);
        }
    }

    public void createBranch() {
        System.out.print("Creating new branch. Type the branch name: ");
        String branchName = sc.nextLine();
        bank.createBranch(branchName);
        System.out.println("Branch '" + branchName + "' created");
    }

    public void printMenu() {
        System.out.println(
            "==============================================================\n" +
                "Welcome to our banking system. What would you like to do?\n" +
                "1. List bank branches\n" +
                "2. Create new branch\n" +
                "3. Create new customer for the branch\n" +
                "4. Add transaction to a customer\n" +
                "5. Exit\n"
        );
        System.out.print("Type the number: ");
    }
}
