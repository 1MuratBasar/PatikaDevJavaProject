package core;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static void setTheme() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }


    //showmsg metotu ile alan kontrolü sonrası gelemsi istenen mesajları akıllı hale getirdik
    public static void showMsg(String str) {
        String msg;
        String title;

        switch (str) {
            case "fill":
                msg = "Lütfen tüm alanları doldurunuz !";
                title = "Hata !";
                break;
            case "done":
                msg = "İşlem başarılı !";
                title = "Sonuç !";
                break;
            default:
                msg = str;
                title = "Mesaj";
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);

    }

    //alanların boş mu dolu mu kontrolü
    //dısarıdan gelen Jtext fieldi alıyor kontrol için
    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    // alanlar cok sayıda ise bu textfieldleri bir array e atıp bir metot içerisinde kontrol ettirirm
    public static boolean isFieldListEmpty(JTextField[] fieldList) {
        //textfield lerin oldugu bir array a atıcam. sonra bunu for each ile dönücem
        for (JTextField field : fieldList) {
            if (isFieldEmpty(field)) { // isFieldEmpty metotundan gelen Jtextfield leri alıyor
                return true;
            }
        }
        return false;

    }

    //Ekran için location metotu (ekstra smart)
    public static int getLocationPoint (String type // hangi ekseni istiyorsam x/y
            , Dimension size) { // Dimension veri tipinden size alıyorum. veri tipinin sadece size özelliği var ve sadecewidth, height özelliği var

        switch (type) {
            case "x":
                return (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y":
                return (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;

            default:
                return 0;

        }
    }

}
