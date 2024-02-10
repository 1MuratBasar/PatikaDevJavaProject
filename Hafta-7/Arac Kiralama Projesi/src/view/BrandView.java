package view;

import business.BrandManager;
import core.Helper;
import entity.Brand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrandView extends Layout {
    private JPanel container;
    private Brand brand;
    private JLabel lbl_brand;
    private JLabel lbl_brand_name;
    private JTextField fld_brand_name;
    private JButton btn_brand_save;
    private BrandManager brandManager; // brandao da save metot yazıldı, brandanager da save kontrolü yapıldı, sıra brandview de kodumu yazıyoruz
    //brandmanager ı constructora alıyorum. sonrasında butona tıklanıldıgındaki action listener ı olusturuyorum
    public BrandView (Brand brand) { //içi dolu brand gonderirsem güncelleme, boş gönderirsem save işlemi olacak.ikisi de aynı arayüzde olacak
        this.brandManager = new BrandManager();
        this.add(container);
        guiInitialize(300,300);
        this.brand = brand;
        //----------------------------------------------------------------------------------------------------------------
        //güncelleme için seçilen satıra sag tıklayıp guncelle dediğimde açılan gundelleme/save gui ye gelmesi için alttaki kodu yazıyorum
        if (brand != null){
            this.fld_brand_name.setText(brand.getName());
        }
//----------------------------------------------------------------------------------------------------------------------

        //buntona tıklandıgıandaki action listener ı yazıyoruz
        btn_brand_save.addActionListener(e -> {
            if (Helper.isFieldEmpty(this.fld_brand_name)) { //tek bir kayıt yapacagım çin isfieldEmpty metotunu kullanıyorum
                Helper.showMsg("fill"); // burası boş ise doldur mesajı cıkacak
            } else { // eğer doluysa kaydetmeyi yapıcaz

                boolean result;
                if (this.brand == null) {
                    Brand obj = new Brand(fld_brand_name.getText()); //brand name i nesneye attık
                    result = this.brandManager.save(obj); //tek bir parametre oldugu için tek brand olusturdum
                } //buraya kadar butona basıldıgın brand null ise save yaptık. eger bull değilse update yazıcaz alta bknz
                //Update için
                    else {
                       this.brand.setName(fld_brand_name.getText()); //text e yeni girdiğim brand i alıyor ve
                        result = this.brandManager.update(this.brand); //update ini yapıyor
                }

                if (result){
                    Helper.showMsg("done");
                    dispose();
                } else {
                    Helper.showMsg("error");
                } //buraya kadar yeni marka eklemesini yaptırdık ancak tabloda gorunmedi.

            }

        }); //NOT: brandview de kaydetmey yapıyoruz. Adminview de kaydetmeyi cagırıyoruz.
        //-------------------------------------------------------------------------------------------------------------
    }
}
