import java.sql.SQLException;

public interface AccountService {
    void balance(int accountId) throws UnknownAccountException, SQLException;

    void withdraw(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException, SQLException;

    void deposit(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException, SQLException;

    void transfer(int from, int to, int amount) throws NotEnoughMoneyException, UnknownAccountException, SQLException;
}