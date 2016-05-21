package moneytransfer;

/**
 * Author: Evgeny Anisimoff
 * Created: 20/05/16.
 */
public class Bank {
    public void transferMoney(Account from, Account to, long amount) {
        long fromId;
        synchronized (from) {
            fromId = from.getId();
        }
        long toId;
        synchronized (to) {
            toId = to.getId();
        }
        Account minIndex = fromId < toId ? from : to;
        Account maxIndex = fromId < toId ? to : from;

        synchronized (minIndex) {
            synchronized (maxIndex) {
                if (amount > from.getMoney()) {
                    throw new IllegalStateException("no enough money");
                }
                from.setMoney(from.getMoney() - amount);
                to.setMoney(to.getMoney() + amount);
                System.out.println(String.format("$%d transferred from %d to %d", amount, fromId, toId));
            }
        }
    }

    public void withdrawMoney(Account from, long amount) {
        synchronized (from) {
            if (amount > from.getMoney()) {
                throw new IllegalStateException("no enough money");
            }
            from.setMoney(from.getMoney() - amount);
            System.out.println(String.format("$%d withdrawn from %d", amount, from.getId()));
        }
    }
}
