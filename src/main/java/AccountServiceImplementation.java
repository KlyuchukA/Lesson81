import java.sql.*;

public class AccountServiceImplementation implements AccountService {
    Connection connection = null;
    String user = "sa";
    String pass = null;

    public AccountServiceImplementation() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM './schema.sql'\\;RUNSCRIPT FROM './data.sql'");
//        this.connection = DriverManager.getConnection("jdbc:h2:tcp://172.18.87.171:8082//mem:test",user,pass);
    }

    public void printInfo() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM BANK");
        ResultSet rs = null;

        statement.execute();
        rs = statement.getResultSet();

        // Количество колонок в результирующем запросе
        int columns = rs.getMetaData().getColumnCount();
        // Перебор строк с данными
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
    }

    public void balance(int accountId) throws UnknownAccountException, SQLException {

        PreparedStatement statement = connection.prepareStatement("SELECT amount FROM BANK where id = ?");
        statement.setInt(1, accountId);
        ResultSet result1 = null;

        statement.execute();
        result1 = statement.getResultSet();

        if (result1.next()) {

            int columns = result1.getMetaData().getColumnCount();
            System.out.println(result1.getInt("amount"));

            while (result1.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(result1.getString(i) + "\t");
                }
                System.out.println();

            }
        } else {
            throw new UnknownAccountException();
        }
    }

    public void withdraw(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException, SQLException {

        PreparedStatement statement = connection.prepareStatement("SELECT amount FROM BANK where id = ?");

        statement.setInt(1, accountId);
        ResultSet result1 = null;

        statement.execute();
        result1 = statement.getResultSet();

        if (result1.next()) {

            int value = result1.getInt("amount");
            if (value >= amount) {
                value = value - amount;

                PreparedStatement statement2 = connection.prepareStatement("UPDATE BANK SET amount = ? where id = ?");
                statement2.setInt(1, value);
                statement2.setInt(2, accountId);

                statement2.execute();

            } else {
                throw new NotEnoughMoneyException();
            }
        } else {
            throw new UnknownAccountException();
        }
    }

    public void deposit(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException, SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT amount FROM BANK where id = ?");

        statement.setInt(1, accountId);
        ResultSet result1 = null;

        statement.execute();
        result1 = statement.getResultSet();

        if (result1.next()) {

            int value = result1.getInt("amount");
            if (amount > 0) {
                value = value + amount;

                PreparedStatement statement2 = connection.prepareStatement("UPDATE BANK SET amount = ? where id = ?");
                statement2.setInt(1, value);
                statement2.setInt(2, accountId);

                statement2.execute();

            } else {
                throw new NotEnoughMoneyException();
            }
        } else {
            throw new UnknownAccountException();
        }
    }

    public void transfer(int from, int to, int amount) throws NotEnoughMoneyException, UnknownAccountException, SQLException {
        withdraw(from, amount);
        deposit(to, amount);
    }
}



