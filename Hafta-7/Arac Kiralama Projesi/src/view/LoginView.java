package view;

import core.Helper;

import javax.swing.*;
import java.awt.*;

// Jframe den extend ediyoruz. çunku icerde Jframe özelliklerini kullancıaz. bknz Kaynaklar
public class LoginView extends JFrame{
    private JPanel container;
    private JPanel w_top;
    private JLabel lbl_welcome;
    private JLabel lbl_welcome2;
    private JPanel w_bottom;
    private JTextField fld_username;
    private JPasswordField fld_pass;
    private JButton btn_login;
    private JLabel lbl_username;
    private JLabel lbl_pass;

    public LoginView() {
        //Jframe özelliklerini kullandıgımız için this diyebilirz.
        this.add(container);  // içerdeki container ı jframe e attım
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("RENT A CAR");
        this.setSize(250,300);
        //java AWT den gelen toolkit ile kendi monitörümün kend genişliğini buluyorum.
        //ve jframe ın genişliğini cıkarıp 2 ye bölüyorum (ortalamak için)

        this.setLocation(Helper.getLocationPoint("x", this.getSize()), Helper.getLocationPoint("y", this.getSize()));
        this.setVisible(true);

        //ben tüm alanları boş mu dolu mu tek tek kod yazacagım. bunun için mesaj vermek için Joption pane kullalıyor javada
        //alan kontrolünü bunu boolean tipte bir metotla Helper sınıfında yazıyorum

        btn_login.addActionListener(e -> {
            //Helper da olusturdugum isFieldEmpty metodumuzu kullanıyoruz
            JTextField[] checkFieldList = {this.fld_username, this.fld_pass};
            if (Helper.isFieldListEmpty(checkFieldList)){ // (go to helper class)
                Helper.showMsg("fill");
            }
            //alanlar kontrol ettik ancak bunlar kendini tekrarlıyor. bu nedenle akıllı olması için Helper class içinde
            //geri birşey dondurmeyen showMessage metotu olusturuyorz. geriye Joption pane cıktısı olacak
            // artı kontrol edilmesi gereken alan sayısı cok olursa akıllı bir metot yazmak mantıklı (array ile)
        });
    }

}
