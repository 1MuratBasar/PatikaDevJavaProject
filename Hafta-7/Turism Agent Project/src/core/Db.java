package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    //Single Design Pattern özelliği
    private static Db instance=null;
    private Connection connection=null;
    private final String DB_URL = "jdbc:postgresql://localhost:5432/otel";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASS = "postgres";

    private Db() {

        try {
            this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASS);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
    //nesne uretmeden metoda ulaşmalıyım
    public static Connection getInstance ()  {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new Db();
            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // db nesnesi üretilmediyse aynı class ben yeni bitane üretiyorrum
        return instance.getConnection();

    }

}
