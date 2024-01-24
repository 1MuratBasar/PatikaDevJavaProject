import java.sql.*;

public class Main {

    public static final String DB_URL = "jdbc:mysql://localhost/work";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        // Verileri çekmek için
        Connection conn1 = null;
        Statement st = null;
        String sql = "Select * from employees";
        try {
            conn1 = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            st = conn1.createStatement(); //ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);
            ResultSet data = st.executeQuery(sql);
            while (data.next()) {
                System.out.print("ID       : " + data.getInt("id"));
                System.out.println();
                System.out.print("Name     : " + data.getString("name"));
                System.out.println();

                System.out.print("Position : " + data.getString("position"));
                System.out.println();

                System.out.print("Salary   : " + data.getDouble("salary"));
                System.out.println();
                System.out.println("------------------------------------------------");


            }
            st.close();
            conn1.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
