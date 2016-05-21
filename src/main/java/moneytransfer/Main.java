package moneytransfer;

/**
 * Author: Evgeny Anisimoff
 * Created: 20/05/16.
 */
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account hackermanAccount1 = new Account(1);
        Account hackermanAccount2 = new Account(2);
        bank.transferMoney(hackermanAccount1, hackermanAccount2, 1000000);
        bank.withdrawMoney(hackermanAccount2, 1000000);
    }
}
