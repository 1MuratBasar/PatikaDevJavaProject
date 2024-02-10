package view;

import business.BrandManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.Brand;
import entity.Model;

import javax.swing.*;

public class ModelView extends Layout {
    private JPanel container;
    private JLabel lbl_heading;
    private JComboBox <ComboItem> cmb_brand; //generic bir yapı oldugu için <ComboItem> ekledim
    private JTextField fld_model_name;
    private JTextField fld_model_year;
    private JComboBox <Model.Type> cmb_model_type; ///generic bir yapı oldugu için <ComboItem> ekledim
    private JComboBox <Model.Fuel> cmb_model_fuel; ///generic bir yapı oldugu için <ComboItem> ekledim
    private JComboBox <Model.Gear> cmb_model_gear; ///generic bir yapı oldugu için <ComboItem> ekledim
    private JButton btn_model_save;
    private Model model;
    private ModelManager modelManager;
    private BrandManager brandManager; //sistemdeki bütün branları gezecegim aşağıda for dongusu ile o nedenle ihtiyacım oldu
    public ModelView (Model model){  //brandview da olusturdugumuz özellikleren yararlanıyorz
        this.model = model;
        this.add(container);
        this.brandManager = new BrandManager();
        this.modelManager = new ModelManager();
        guiInitialize(300,500);

     for (Brand brand : this.brandManager.findAll()) { //findall metotuyla bana tum brandleri getir
            this.cmb_brand.addItem(new ComboItem(brand.getId(), brand.getName()));
            //comboitem key ve value alıyor. key = id, value = name
            //bu metotla brandlerimi combobo içine koydum
         //brand id ve brand name imi koydum ihtiyaca göre id, ihtiyaca göre name ihtiyaca gore her ikisini de alablrlm
     }


        //aynılarını diger combolar için yapıcam.ancak oonlar veritabanından gelmiyor cunku enum yapıya sahipelr
        //bu nedenle onları eklemek daha kolay


        this.cmb_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
     //generic yapı oldugu için <> koyuyorum ve içerisine Fuel enum u alıp value sunu içeri atıyorum
     //bu nedenle <ComboItem> generic yapısını yukarı tanımlamalara ekliyorum
        this.cmb_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
    //adminviewden buraya geldik işlemleri yaptık. combolarımızı doldurduk sıra kaydetme işlemlerinde

//*************************************************************************************************************
        if (this.model.getId() != 0){ // burası gunclelemede alanları dolu getirmek için, null kullanıyoruz cunku
            this.fld_model_year.setText(this.model.getYear());
            this.fld_model_name.setText(this.model.getName());
            this.cmb_model_fuel.getModel().setSelectedItem(this.model.getFuel());
            this.cmb_model_fuel.getModel().setSelectedItem(this.model.getFuel());
            this.cmb_model_fuel.getModel().setSelectedItem(this.model.getFuel());
            ComboItem defaultBrand =  new ComboItem (this.model.getBrand().getId(), this.model.getBrand().getName());
            this.cmb_brand.getModel().setSelectedItem(defaultBrand);
        }
//*************************************************************************************************************

        btn_model_save.addActionListener(e -> {
            if (Helper.isFieldListEmpty(new JTextField[]{this.fld_model_name, this.fld_model_year})){
                Helper.showMsg("fill");
            } else {
                boolean result;
                //seçilen brand in id sini kaydetmek için
                ComboItem selectedBrand = (ComboItem) cmb_brand.getSelectedItem();
                this.model.setYear(fld_model_year.getText());
                this.model.setName(fld_model_name.getText());
                this.model.setBrand_id(selectedBrand.getKey());
                this.model.setType((Model.Type) cmb_model_type.getSelectedItem());
                this.model.setFuel ((Model.Fuel) cmb_model_fuel.getSelectedItem());
                this.model.setGear((Model.Gear) cmb_model_gear.getSelectedItem());
                //görüldüğü gibi üstte modelimin degerleri oluştu ve artık null değil
                //eger modelimin id si 0 dan farklı olursa bu bir update işlemi olacak
                if (this.model.getId() != 0) {  // update işlemi

                result = this.modelManager.update(this.model);

                } else { // 0 sa kaydet işlemi ypaıcaz. çümkü id si burda olusmamıstır
                result = this.modelManager.save(this.model);
                }

                if (result) {
                    Helper.showMsg("done");
                    dispose();
                } else {
                    Helper.showMsg("error");
                }
            }
        });
    }

}
