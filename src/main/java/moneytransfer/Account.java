package moneytransfer;

/**
 * Author: Evgeny Anisimoff
 * Created: 20/05/16.
 */
public class Account {
    private final long id;
    private long money;

    public Account(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }
}
