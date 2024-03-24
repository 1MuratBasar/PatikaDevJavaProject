package core;

import javax.swing.*;
import java.awt.*;

public class Helper {

    //açıldıgında windows temalarını setlemek için
    public static void  setTheme() {
        optionPaneTR();

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }

    //kullanıcıya duruma göre döndürülen mesajları tanımlıyoruz
    // verdigimiz string degere göre mesajlar veriyor
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
            case "notFound":
                msg = "Kayıt bulunamadı !";
                title = "Bulunamadı !";
                break;
            case "error":
                msg = "Hatalı işlem yaptınız !";
                title = "Hata !";
                break;

            default:
                msg = str;
                title = "Mesaj";
        }
        // için püf noktası verdiğimiz mesajı göstermemiz için kullanılır. aldıgı parametreler mesaj, başlık, information mesajı oldugunu belirtilmesi
        JOptionPane.showMessageDialog(null, msg , title, JOptionPane.INFORMATION_MESSAGE);

    }
    // confirmation dialog = eminmisin diye bize sormasını sağlıyor
    public static boolean confirm (String str) {
        String msg;
        if (str.equals("sure")){
            msg = "Bu işlemi yapmak istediğine emin misin ?";

        } else {
            msg = str;
        }
        return JOptionPane.showConfirmDialog(null,msg,"Emin misin ?", JOptionPane.YES_NO_OPTION) == 0;
    }

    //kullancıdan deger alıyoruz. her seferinde tek tek sormak yerine metotla kontrol ediyorz.
    public static boolean isFieldEmpty (JTextField field) {
        return field.getText().trim().isEmpty();
    }

    //birden fazla alan kontrolü için bu metotu cagırıyoruz. (aldıgı parametre jtext field oldugu için sadece jtextfield kontrol ederiz)
    public static boolean isFieldListEmpty (JTextField[] fieldList) {

        for (JTextField field : fieldList) {
            if (isFieldEmpty(field)) {
                return true;
            }}
        return false;
    }
    //kendi metotları ile ekran olcusunu alarak, ekran ortasına cıkacak koordinatları kontrol ediyor
    public static int getLocationPoint (String type, Dimension size){
        return switch (type) {
            case "x" -> (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            // return edildiği için break e ihtiyaç yok
            case "y" -> (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default -> 0;
        };

    }
    //optionpane lerin dilini değişmek için kullanılır
    public static void optionPaneTR() {
        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");

    }
}
