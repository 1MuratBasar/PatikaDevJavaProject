package business;

import dao.UserDao;
import entity.User;

public class UserManager {
    //veri tabanına olan işlemler buradan yönetielcek. ancak buranın userdao ya ihtiyacıvar
private final UserDao userDao;

    public UserManager() {
        this.userDao = new UserDao(); // burada kullanmak için userdao clasını çagırıyoruz. userdao da ne var. veritabanıyla ilişki kurulumu
    }

    //biz viewdan bu metota gelicez. buradan dao ya gitcez
    //kullanıcı kayıt için kullancıı var mı yok mu burda bakıyoruz, dao ya gitmiyoruz
    //amaç işlemleri katmnlarla birbirinden ayırmak

    //alltaki bu metotla userdao dan alıyoruz gerekli alanları
    public User findByLogin(String username, String password) {
        //sanki aynı kou yazmısgibi olduk dao ile ancak burada ihtiyaca göre farklı sorgulamalar yapılablr
return userDao.findByLogin(username,password);
//Not: burada da user ile ilgili iş bitti şimdi view e geçiyoruz.

    }





}
