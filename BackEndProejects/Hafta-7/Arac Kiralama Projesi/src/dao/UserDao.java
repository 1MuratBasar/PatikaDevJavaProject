package dao;


// UserDao: veri tabaına sorgu atacagımız katmandır


import core.Db;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    private final Connection con;

    public UserDao () {
        this.con = Db.getInstance();
    }
    // buraya kadar aralarında ilişki bulunan User, UserManager ve UserDao classlarını oluşturduk
    //User içinde class ın veritabından alacagı değerlere karsılık gelecek alanalrı tanımladık
    //şimdi sıra kullanıcı adı şifreyi yollayığ böyle biri var mı yok mu ona bakcıcaz




    //veri tabanındaki userların hepsini bir array a atıp bunalrı bir listede almak için
    public ArrayList<User> findAll(){
        ArrayList<User> userList = new ArrayList<>(); // içinde user ları oaln boş bir arraylist olusturdum
        String sql = "SELECT * FROM public.user";
        try {
            //herhangi bir preparestatement yapmadıgım için direk result set alıyorum
            ResultSet rs = this.con.createStatement().executeQuery(sql);
 //ÖNEMLİ
   // 4-5 sutun için db eşleşmesi ok ancak sutunlar cok ise bunları teker teker yapmak yerine
   // bir match metotu yazıyoruz
            while (rs.next()) {
                userList.add(this.match(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }





    // bu metot ile veritabanından aldıgım user ı bir objeye atadım
    //bu (findByLogin) tek bi user için tüm user ları istersem findAll metotunu kullanıcam (yukarıda)
    public User findByLogin(String username, String password){
        User obj=null;
        String query= "SELECT * FROM public.user WHERE user_name = ? AND user_pass = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, username); //1. soru işaretini username
            pr.setString(2, password); //2. soru işaret passwordi le değiştir
            //ve eğer varsa bunun bir resultset edonmesini sağla
            ResultSet rs = pr.executeQuery();
            // ve eğer
            if (rs.next()) {
                obj = this.match(rs); // bnm yerime veriyi otomatik modele cevirdi
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return obj;
    }


    //bnm geriye User döndüren bir match metotuna ihtiyacım var
    public User match (ResultSet rs) throws SQLException {
    User obj = new User();
        obj.setId(rs.getInt("user_id"));
        obj.setUsername(rs.getString("user_name"));
        obj.setPassword(rs.getString("user_pass"));
        obj.setRole(rs.getString("user_role"));
        //yarın bir gun user tablosuna alan eklenirse sadece buraya bir satır daha eklemek yeterli sorgu calısır
        return obj;
    }

}
//NOT: burada map leme işlemlerimizi hallettik.
//Özetle: tek bir user döndüren ve btün user ları döndüren 2 metot yazdık
//bu 2 metotta kullanacagımız resultset leri sürekli yazmak yerien bunalrı bir match metotunda
//getirttik.
// veri tabanıyla ilişki kurduk. şimdi yönetime gidiyoruz (UserManager)