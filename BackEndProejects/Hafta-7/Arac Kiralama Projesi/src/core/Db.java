package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    private static Db instance=null; //singelton nesneyi tanımlıyorum. en altta bağlantı meto için kullanıcam
    //bu singleton design pattern özelliğidir. amac db deki bağlantıyı hafıza da bir kez oluşturup ihtiyac oldugunda cağırıcam. sadece hafızada olusmusu cagırıcam
    private Connection connection = null;
    private final String DB_URL = "jdbc:postgresql://localhost:5432/AracKiralama";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASS = "postgres";

    //private cons alıyorum.bu sınıf uzerinden erişilmesini istemiyorum
    //bu nedenle metotla erişicem
    private Db() {
        try {
            this.connection = DriverManager.getConnection( DB_URL,DB_USERNAME,DB_PASS);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //conenction ın değiştirilmesini istemiyorum o yuzden sadece getter metotu kullanıyorum
    public Connection getConnection() {
        return connection;
    }

//bağlantıya erişmek için static bir metot yazıyorum. bağlantıyı bu nesnenin içinde ureticem
 //bağlantı null sa ya da kapatılmıssa yeni bi bağlantı olustur ya da saten varsa return deki bağlanıtıy dondur
    public static Connection getInstance() {

      try {
          if (instance == null || instance.getConnection().isClosed()) {
              instance = new Db();
          }
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
        return instance.getConnection();
    }
}
