import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        try {
            AccountServiceImplementation accountService = new AccountServiceImplementation();
//            accountService.printInfo();
//            accountService.withdraw(2,100000);
//            accountService.deposit(3,100);
            accountService.transfer(1,2,100);
            accountService.printInfo();
//            accountService.balance(2);
        }
//        catch (UnknownAccountException | NotEnoughMoneyException ex) {
//            System.out.println(ex.getMessage());
//        }

        catch (UnknownAccountException re) {
            System.out.println(re.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }

//        Connection connection = null;
//        Statement statement = null;
//
//        try {
//            try {
//                Class.forName("org.h2.Driver");
//                connection =
//
//                DriverManager.getConnection("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM './schema.sql'\\;RUNSCRIPT FROM './data.sql'");
//                String sql = "INSERT INTO STUDENTS (id, name, surname, age) VALUES (random_uuid(), ?, ?, ?)";
//                statement = connection.prepareStatement(sql);
//                statement.setString(1,"Viktor");
//                statement.setString(2, "Ivanov");
//                statement.setInt(3,65);
//                System.out.println(statement.executeUpdate());

//        Connection connection = null;
//        PreparedStatement statement = null;
//        try {
//            try {
//
//                connection = DriverManager.getConnection("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM './schema.sql'\\;RUNSCRIPT FROM './data.sql'");
////                connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:8082/mem:test;");
//                String sql = "INSERT INTO BANK (id, holder, amount) VALUES (?, ?, ?)";
//                statement = connection.prepareStatement(sql);
//
//                statement.setInt(1,5);
//                statement.setString(2, "Anna");
//                statement.setInt(3,333);
//
//                System.out.println(statement.executeUpdate());
//
//                // Создание Statement для отправки запроса базе данных
//                Statement st = connection.createStatement();
//                // Результирующий запрос
//                ResultSet rs = st.executeQuery("select * from bank");
//                // Количество колонок в результирующем запросе
//                int columns = rs.getMetaData().getColumnCount();
//                // Перебор строк с данными
//                while(rs.next()){
//                    for (int i = 1; i <= columns; i++){
//                        System.out.print(rs.getString(i) + "\t");
//                    }
//                    System.out.println();
//                }
//            } finally {
//                statement.close();
//                connection.close();
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//}


//            } finally {
//                statement.close();
//                connection.close();
//            }
//
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
