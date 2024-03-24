import business.UserManager;
import core.Db;
import core.Helper;
import view.AdminView;
import view.LoginView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// N katmanlı kurumsal mimari kullanılacak
//DATA ACCESS OBJECT = veri tabanı ile ilişkileri sağlayan DAO sınıfları kullanılacak Data Access Object
//Business kısmı. view ın iletişim kurdugu yerler business ile yönetilecek
//view kısmı olacak. arayüzler yönetilecek. masaüstü uygulamasındaki kodlar burda
//business ta veri tabanı işleelri DAO sınıf uzerinden yapacak
//Entity = veritabanından cekilen veriler modellere aktarılacak
//Core = sistemle alakalı veritabanı bağlantısı, helper sınıfları vs burada olacak.

public class App {
    public static void main(String[] args) {
        Helper.setTheme();
        LoginView loginView = new LoginView();

        // UserManager userManager = new UserManager();
        // AdminView adminView = new AdminView(userManager.findByLogin("admin","1234"));




    }
}
