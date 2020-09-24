import java.sql.*;

public class AccountServiceImplementation {
    Connection connection = null;

    public AccountServiceImplementation() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM './schema.sql'\\;RUNSCRIPT FROM './data.sql'");
    }

    public void printInfo() throws SQLException{
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM BANK");
        ResultSet rs = null;

       statement.execute();
        rs= statement.getResultSet();

        // Количество колонок в результирующем запросе
        int columns = rs.getMetaData().getColumnCount();
        // Перебор строк с данными
        while(rs.next()){
            for (int i = 1; i <= columns; i++){
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }

       }

}


