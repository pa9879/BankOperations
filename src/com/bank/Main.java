package com.bank;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import com.bank.entity.*;
import com.bank.command.BankSystem;
import com.bank.service.SbiBank;
import com.bank.command.BankBranch;

import java.util.ArrayList;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        SbiBank bank = new SbiBank(bankSystem, 10000);

        BankBranch branch1 = bank.addBranch("123 Main St", 1000);
        BankBranch branch2 = bank.addBranch("456 Elm St", 1000);

        branch1.addTeller(new BankTeller(1));
        branch1.addTeller(new BankTeller(2));
        branch2.addTeller(new BankTeller(3));
        branch2.addTeller(new BankTeller(4));

        int customerId1 = branch1.openAccount("John Doe");
        int customerId2 = branch1.openAccount("Bob Smith");
        int customerId3 = branch2.openAccount("Jane Doe");

        branch1.deposit(customerId1, 100);
        branch1.deposit(customerId2, 200);
        branch2.deposit(customerId3, 300);

        branch1.withdraw(customerId1, 50);

        bank.printTransactions();
        /*  Possible Output:
            Teller 1 opened account 0
            Teller 2 opened account 1
            Teller 3 opened account 2
            Teller 1 deposited 100 to account 0
            Teller 2 deposited 200 to account 1
            Teller 4 deposited 300 to account 2
            Teller 2 withdrew 50 from account 0
        */

        bank.collectCash(0.5);
    }
}
