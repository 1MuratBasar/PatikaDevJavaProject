package view;

import business.BrandManager;
import business.CarManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.Brand;
import entity.Car;
import entity.Model;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;

public class AdminView extends Layout{
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane tab_menu;
    private JButton btn_logout;
    private JPanel pnl_brand;
    private JScrollPane scl_brand;
    private JTable tbl_brand;
    private JPanel pnl_model;
    private JScrollPane scrl_model;
    private JTable tbl_model;
    private JButton btn_search_model;
    private JComboBox<ComboItem> cmb_s_model_brand;
    private JComboBox<Model.Type> cmb_s_model_type;
    private JComboBox<Model.Fuel> cmb_s_model_fuel;
    private JComboBox<Model.Gear> cmb_s_model_gear;
    private JButton btn_cncl_model;
    private User user; //burda mutlaka user a ihtiyac var cunku login olmus kişi işlem yapacak
    //tablolar üzerinde işlem yapabilmek için  DefaultTableModeller kullanılırı
    private DefaultTableModel tmdl_brand= new DefaultTableModel(); // defaulttable modeli biz tanımladık ve tmdl ismini biz verdik,
   private DefaultTableModel tmdl_model = new DefaultTableModel(); //Modeller - Kısım2
    private DefaultTableModel tmdl_car = new DefaultTableModel(); //Araçlar - Kısım 3
    private DefaultTableModel tmdl_booking = new DefaultTableModel(); //Kiralamalar - Kısım 4
    private JTable tbl_car;
    private JPanel pnl_car;
    private JPanel pnl_booking;
    private JScrollPane scrl_booking;
    private JTable tbl_booking;
    private JPanel pnl_booking_search;
    private JTextField fld_strt_date;
    private JTextField fld_fnsh_date;
    private JComboBox <Model.Gear> cmb_booking_gear;
    private JComboBox <Model.Fuel> cmb_booking_fuel;
    private JComboBox <Model.Type> cmb_booking_type;
    private JButton btn_booking_search;
    private JButton btn_cncl_booking;
    private JPanel pnl_rents;
    private JScrollPane scrl_rents;
    private JTable tbl_rents;
    private JButton btn_rents_search;
    private JButton btn_rents_clear;
    private JComboBox cmb_rents_plate_filter;
    private JPanel pnl_rents_search;

    //defaulttableı tanımladıktan sonra aşağı inip tablonun kolonlarını olusturuyoruz.
    private BrandManager brandManager; //kolonları tanımlamıstım verileri cekmek için tanımladım.+ constructora ekledm
    private ModelManager modelManager; //modeller - kısım2
    private CarManager carManager; //araçlar kısım 3
    private JPopupMenu model_menu;  //modeller - kısım2
    private JPopupMenu car_menu;  //araçlar - kısım3
    private JPopupMenu booking_menu;  //Kiralamalar - kısım 4
    private Object[] col_model; // verilerin filtrelenmesi ve loadModelTable a size vermek için
    private Object[] col_car;
    //-------------------------------------------------------------------------------------------------------------------------
    private JPopupMenu brand_menu;


public AdminView(User user) { // dışarıdan gelen bi user alacak her zaman
    this.brandManager = new BrandManager();
    this.modelManager = new ModelManager(); //modeller - kısım2
    this.carManager = new CarManager() ; // araçlar kısım 3

    this.user = user;
    this.add(container);
    this.guiInitialize(1000, 500);
    if (this.user == null) { // user yok ise pencere kapanacak
        dispose();
    }

    this.lbl_welcome.setText("Hoşgeldiniz " + this.user.getUsername());
    loadBrandTable(); //view çalıştıgında tablo yuklenicek. popup menulerde de işlem yapıldıgında bu metotu tetiklemem lazım
    //popum menulerin metotlarına da ekliyorum
    loadBrandComponent(); // sağ tıklave menulerin gelmesi
//******************************************************************************************************************
//MODELLERİN OLUTURULMASI - KISIM 2 - ALT
    loadComponent ();

    loadModelTable(null); //model yönetimi KIsım 2
    loadModelComponent(); // Kısım 2
    loadModelFilter(); //Verilerin filtrelenmesi kısmı - Kısım 2


    //Car Menu - Kısım 3
     loadCarTable ();
     loadCarComponent();

    //Booking Menu - Kısım 4
    loadBookingTable(null);
    loadBookingComponent();
    loadBookingFilter();

    //Rents Menu - Kısım 5 (ödev)
    loadRentTable(null); //digercomponenetlerin içinde olacak, guncelleme silem
 //   loadRentCompnent();
 //   loadRentFilter();

}
//*********************************************************************************************************************
private void loadComponent () {
    //çıkış yapmak için
    this.btn_logout.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            LoginView loginView = new LoginView();
        }
    });
}

//*********************************************************************************************************************
//********************************** KISIM 5 ÖDEV ************************************************************,
private void loadRentTable(ArrayList <Object[]> rentList) { // carlist i dışarıdan alıcak. cunku ben bir arama sonucu degerini alıcam burada
    Object[] col_booking_list = {"ID", "Plaka","Araç Marka","Araç Model","Müşteri","Telefon","Mail", "T.C.","Başlangıç Tarihi", "Bitiş Tarihi", "Fiyat"};
    createTable(this.tmdl_booking, this.tbl_booking, col_booking_list, rentList);
}



















//*********************************************************************************************************************
//********************************** KISIM 5 ÖDEV BİTTİ ************************************************************,

//*********************************************************************************************************************

    private void loadBookingFilter() {   //combobox a gelen filtreleme ceştileri için

        this.cmb_booking_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_booking_type.setSelectedItem(null);
        this.cmb_booking_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_booking_gear.setSelectedItem(null);
        this.cmb_booking_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_booking_fuel.setSelectedItem(null);

    }
//*********************************************************************************************************************
    //rezervasyon yap a tıkaldıgında (sağ tıkladıgında olacaklar)
    private void loadBookingComponent() {
    tableRowSelect(this.tbl_booking);
    this.booking_menu = new JPopupMenu();
    this.booking_menu.add("Rezervasyon Yap").addActionListener(e -> {

    int selectCarId = this.getTableSelectedRow(this.tbl_booking, 0); //seçilen araba idsini getir
    //bookingview GUI yı actır ve new BookView tanımladııgnda aracın hangi özellikleri gelsin tanımlıyoruz, bir üst satır
        BookingView bookingView = new BookingView(this.carManager.getById(selectCarId), //ilk başta araba istediğmiz için
                this.fld_strt_date.getText(),
                this.fld_fnsh_date.getText()
                );
        // bu işlemlerin sonunda booking in addWindowListener ını dinleyecegiz
        bookingView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {

                loadBookingTable(null);
                loadBookingFilter();

            }
        });


    });
    this.tbl_booking.setComponentPopupMenu(booking_menu);



//*********************************************************************************************************************
//********************************** KISIM 4 KİRALAMALAR ************************************************************,
        this.btn_booking_search.addActionListener(new ActionListener() { //butona tıklnadıgı anda (searc yapıldıgında) benim
            //carmanager ım da uygun car ları bulucaz
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Car> carList = carManager.searchForBooking(  ///*****BURADA THIS. almadı ???
                        fld_strt_date.getText(),
                        fld_fnsh_date.getText(),
                        (Model.Type) cmb_booking_type.getSelectedItem(),
                        (Model.Gear) cmb_booking_gear.getSelectedItem(),
                        (Model.Fuel) cmb_s_model_fuel.getSelectedItem()
                );
                //filterelenen arabaları array a alıp daha sonra obje seklinde tablolara yukleyeceğim. bunun için CARMANAGER içine searchForBooking
                // metotu yazıyorum
                //carmanager e metotu yazdıktan sonra altta getfortable ım ile array size ve carlistesi ni bir arraa atıp loadbookingtable metotumla tablolama atıyorum
                ArrayList<Object[]> carBookingRow = carManager.getForTable(col_car.length, carList);
                loadBookingTable(carBookingRow);
            }
        });
//*******************************************SIFIRLAMA BUTONU (KİRALAMA)************************************************************
        btn_cncl_booking.addActionListener(e -> {
            loadBookingFilter();

        });
//********************************************KİRALAMALAR KISIM4 BİTTİ************************************************
    }
//*********************************************************************************************************************

    private void loadBookingTable(ArrayList <Object[]> carList) { // carlist i dışarıdan alıcak. cunku ben bir arama sonucu degerini alıcam burada
    Object[] col_booking_list = {"ID", "Marka","Model","Plaka","Renk","KM","Yıl", "Tip","Yakıt Türü", "Vites"};
    createTable(this.tmdl_booking, this.tbl_booking, col_booking_list, carList);
    }


//*********************************************************************************************************************
//**************************CAR MENULER -******************************************************
    private void loadCarComponent() {
    tableRowSelect(this.tbl_car);
    this.car_menu = new JPopupMenu();
//*********************************************************************************************************************

    this.car_menu.add("Yeni").addActionListener(e -> {
        CarView carView = new CarView(new Car());
        carView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                loadCarTable();
            }
        });

    });
//*********************************************************************************************************************
        this.car_menu.add("Güncelle").addActionListener(e -> {
            int selectCarId = this.getTableSelectedRow(tbl_car,0);
            CarView carView = new CarView(this.carManager.getById(selectCarId));
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
//*********************************************************************************************************************
        this.car_menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) { // confirm metodunu Helper da yazdık ve burada cagırdık
                int selectCarId = this.getTableSelectedRow(tbl_car,0);

                if (this.carManager.delete(selectCarId)){ // eger delete metotuna verdigim selectbrandid true ise yani sil dediysem
                    Helper.showMsg("done");
                    loadCarTable(); // tabloyu yeniden yukluyorum
                } else {
                    Helper.showMsg("error");
                }


            }

        });



this.tbl_car.setComponentPopupMenu(car_menu);

//*********************************************************************************************************************

    }




//*********************************************************************************************************************

    private void loadCarTable() {

   col_car = new Object[] {"ID", "Marka", "Model","Plaka", "Renk","Km","Yıl","Tip","Yakıt Türü","Vites"};
    ArrayList <Object[]> carList = this.carManager.getForTable(col_car.length, this.carManager.findAll());
    createTable(this.tmdl_car, this.tbl_car, col_car, carList);

    }

    private void loadModelComponent() {
        tableRowSelect(this.tbl_model); //mouse un tıkladıgı yeri seçmek için
        this.model_menu = new JPopupMenu(); //bunları yonetmek için bir modelview GUI açıyorum. GUI yi açtıktan sonra texfield ve comboboxları doldurmam lazım
        //bunun için modelviewde kodlarımı yzıyorum. ancak comboboxı doldurabilmek için core package de COmboItem metot yazıyorum ki verilerimi comboya alabileyim
        //go to Core then modelview. amacımız comboboxların degerin key i ve ekrana gösterilen degeri tutmak
//*********************************************************************************************************************

        this.model_menu.add("Yeni").addActionListener(e -> {

            ModelView modelView = new ModelView(new Model()); //null gönderirsem nullpointer hatası alırım. o ndenle model gonderiyorum
           //modelvire açılıyor ve gerekli işlemleri yapıp kaydet diyorum. o esnada brandview daki kodlarım calışıyor. sonra
           // tabloyu load etmek için action listener ekliyorum alta
            modelView.addWindowListener(new WindowAdapter() {
                @Override                                       //buradaki windowlistener, modelview kapandıgında birşey tetikleyecek. yani
                public void windowClosed(WindowEvent e) {       //table ı yeniden yukleyecek
                    loadModelTable(null);


                }
            });
    
        });
//*********************************************************************************************************************
  //NOT: editte veriler dolu gelmiyor. bu nedenle modelview da bir sorgu olusturyoruz
        /*
        if (this.model.getId() != 0){
        this.fld_model_year.setText(this.model.getYear());
        this.fld_model_name.setText(this.model.getName());
        this.cmb_model_fuel.getModel().setSelectedıtem(this.model.getFuel());
        this.cmb_model_fuel.getModel().setSelectedıtem(this.model.getFuel());
        this.cmb_model_fuel.getModel().setSelectedıtem(this.model.getFuel());
        ComboItem defaultBrand =  new ComboItem (this.model.getBrand().getId(), this.model.getBrand().getName());
        this.cmb_brand.getModel().setSelectedItem(defaultBrand);
        }

         */
        this.model_menu.add("Güncelle").addActionListener(e -> {
        int selectModelId = this.getTableSelectedRow(tbl_model,0);
        ModelView modelView = new ModelView(this.modelManager.getById(selectModelId));
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                    loadCarTable();

                }
            });
        });
//*********************************************************************************************************************

        this.model_menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) { // confirm metodunu Helper da yazdık ve burada cagırdık
                int selectModelId = this.getTableSelectedRow(tbl_model,0);
                //silme için brandid alındı artık branddao da silme yapıyorum. go to brand dao
                //brand dao dan brand manager a ve ardından tekrar buraya geliyoruz. ekstra olarak silmek istedigine emin misin diye soracagız

                //eger işlem için evt dediysem;
                if (this.modelManager.delete(selectModelId)){ // eger delete metotuna verdigim selectbrandid true ise yani sil dediysem
                    Helper.showMsg("done");
                    loadModelTable(null); // tabloyu yeniden yukluyorum
                    loadCarTable();

                } else {
                    Helper.showMsg("error");
                }


            }

        });

//*********************************************************************************************************************

        this.tbl_model.setComponentPopupMenu(model_menu); //menuleri olusturdum. burada da bunu tabloma entegre ediyorum
        //çalıştırdıgımda ekranda çıktı. ancak bunu tıklanıldıgında yapsın (seçili olan satıra) istiyoruz. bu nedenle actionerlistener lazım
        //her ekleme ve guncellemeden sonra tabloyu boşaltıp tekrar doldurmak için loadBrandTable metotunu yazıyorum
        //ve tablo için belirledigim özellikleri bu metot içine alıyrm. bknz alt kısım


        //  this.tbl_brand.setComponentPopupMenu(brandMenu); //menuleri olusturdum. burada da bunu tabloma entegre ediyorum
        //çalıştırdıgımda ekranda çıktı. ancak bunu tıklanıldıgında yapsın (seçili olan satıra) istiyoruz. bu nedenle actionerlistener lazım
        //her ekleme ve guncellemeden sonra tabloyu boşaltıp tekrar doldurmak için loadBrandTable metotunu yazıyorum
        //ve tablo için belirledigim özellikleri bu metot içine alıyrm. bknz alt kısım

 //*******************KISIM-2 VRİLERİN FİLTRELENMESİ*********************************************
        //******BUTONA BASIP ARAMA YAPMA****************
this.btn_search_model.addActionListener(e -> {
//butona tıkladıgımızda modelManager üzerinde query olusturup onu veritabanında sorgulamamız lazım
//model manager a gidip searchForTable metotumu yazıyorum
        ComboItem selectedBrand = (ComboItem) this.cmb_s_model_brand.getSelectedItem();
        //---------ARA KOD---------------------------------
       // filtrelemenin kldırılması sırasında hata almaması içni yazıldı
        int brandId = 0;
        if (selectedBrand != null){
            brandId = selectedBrand.getKey();
        }
        //--------ARA KOD TMM--------------------

        ArrayList<Model> modelListBySearch = this.modelManager.searchForTable(
               // selectedBrand.getKey(),
                brandId,
                (Model.Fuel) cmb_s_model_fuel.getSelectedItem(),
                (Model.Gear) cmb_s_model_gear.getSelectedItem(),
                (Model.Type) cmb_s_model_type.getSelectedItem()

//butona tıkladıgımda ustteki verilri searchForTable metotuna attım. bu metotda modelmanager da veritabanı
//sorgulaması yapıyor
        );
 // *******************************************************************************************************************
    ArrayList<Object[]> modelRowListBySearch = this.modelManager.getForTable(
            this.col_model.length, modelListBySearch );
    loadModelTable(modelRowListBySearch ); //SEARCH ettigim veriyi tablonun yapısına uyarladım

});
//*******************************************************************************************************************
        //FİLTREYİ SIFIRLAMAK İÇİN ALT
              //filtreleri temizlemek için
        this.btn_cncl_model.addActionListener(e -> {
            this.cmb_s_model_type.setSelectedItem(null);
            this.cmb_s_model_gear.setSelectedItem(null);
            this.cmb_s_model_fuel.setSelectedItem(null);
            this.cmb_s_model_brand.setSelectedItem(null);
            loadModelTable(null);
        });
//*******************************************************************************************************************

    }
    //MODELLERİN OLUTURULMASI - KISIM 2 - ÜST
//******************************************************************************************************************
//ARA NOT: Buraya kadar modeller oluşturuldu. Şimdi brandda degişen bir marka isminin model kısmında da değişmesini
//istiyoruz.bu nedenle loadBrandTable işlemleri ardından loadModelTable ı da çagırmalıyım

// Ayrıca Branddan bir şey silince modele ait tüm verilerinde silinmesiini istiyorum. (CASCADE ing)
//bunun için önce modeldao da getByListBrandId metotu olusturdum. brandId ile dışardan gelen id ye göre verileri getirecek
//ardından modelManager üzerinden iletilecek. sonra brandManagere gidilip kodu yazılacak (delete kısmına)
//Bunu gidip BrandManager da yazıyorum (delete kısmına for dongusu)
//******************************************************************************************************************
//KISIM - 2 VERİLERİN FİLTRELENMESİ
    //Marka kısmında verileri cekecek, diger verileri enum sınıftan alacak

public void loadModelFilter(){

    this.cmb_s_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
    this.cmb_s_model_type.setSelectedItem(null);
    this.cmb_s_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
    this.cmb_s_model_gear.setSelectedItem(null);
    this.cmb_s_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
    this.cmb_s_model_fuel.setSelectedItem(null);
    loadModelFilterBrand();
}

public void loadModelFilterBrand(){
    this.cmb_s_model_brand.removeAllItems();
    for (Brand obj : brandManager.findAll()){
        this.cmb_s_model_brand.addItem(new ComboItem(obj.getId(), obj.getName()));
    }
    this.cmb_s_model_brand.setSelectedItem(null);
}

//**************************************************************************

    //NOT: veri filtreleem için loadModelTable metotmuzu guncelliyoruz

//******************************************************************************************************************
//MODELLERİN OLUTURULMASI - KISIM 2 - ALT
//1-loadmodeltable yazabilmek için ilk önce yukarıda  Defaulttable model tmdl_model olusturuyoruz
//2-Kolonlar olusturuyorum
  //  public void loadModelTable () {//NOT: veri filtreleem için loadModelTable metotmuzu guncelliyoruz
    public void loadModelTable (ArrayList<Object[]> modelList){
       this.col_model = new Object[] {"Model ID", "Marka", "Model Adı", "Tipi", "Yıl", "Yakıt Türü", "Vites"}; //kolonları olusturdum
//3-kolonları olusturdumm ustte. altta modelleri cekiyorum // getfortable size ve arraylist alıyor
 //       ArrayList<Object[]> modelList = this.modelManager.getForTable(col_model.length, this.modelManager.findAll());  // getfortable brandmanager da uretildi
//****************************
 if (modelList == null) {
     modelList = this.modelManager.getForTable(col_model.length, this.modelManager.findAll());  // getfortable brandmanager da uretildi

 }

//4-modelliste aldıgım tum bu verileri yeni bi create table a atıoyurm
        createTable(this.tmdl_model, this.tbl_model, col_model, modelList);
//--yukarıda olusturdugum defaulttable + viewde olusturduguum tbl_model + kolonlarım +  satırlarım (modellist)

    } //buraya kadar veritabanındaki verileri tabloya yukledik ve çalıştırdıgımızda geldi. sıra ekleme silme guncelleme
    //MODELLERİN OLUTURULMASI - KISIM 2 - ÜST
    //*******************************************************************************************************************
    //tabloyu her seferinde boşalt ve tekrar yukle metotu.
    public void loadBrandTable (){  //Küçük not: her marka model eklerken bu tabloyu kullanacagımız için burayı akıllı yazabilirz
    //layout içerisine her tablo için extend edebileceğim bir metot yazıyorum

        //-----------------------------------------------------------------------------------------------------------------------------------
        //şimdi adminview deki tabloya verileri getircez. sırayla veritabanına bağlanıp butun verileri cekp tabloya basmamız gerekiyor
        //Brand, Branddao ve BrandManager olusturulur.
        //Branddao ya userdao daki findall ve match metotları alındı
        //brandmanager e usermanager deki findall metotu alındı
        //sıra adminview de bunları tabloda göstermeye geldi. yukarıda defaulttable tanımlayıp tekrar buraya geliyoruz

        // tablonun kolonlarını tanımlıyorum

        Object [] col_brand = {"Marka ID", "Marka Adı"} ; //-----> tablonun kolon başlıkları

        //kolonları oluşturdum. şimdi managerdan brand leri cekmem lazım. geriye arraylistte brand olan brandlisteye ihtiyacım var. yukarı brandmanager tanımlıyorum
     //   ArrayList<Brand> brandList = this.brandManager.findAll(); //bu metot kendi içinde branddao ya baglanıyor ve  branddaonun findall metotunu cagırıyor
        //üstteki satırı daha akılllı hale getirdik ielrleyen videolarda

        ArrayList<Object[]> brandList = this.brandManager.getForTable(col_brand.length);  // getfortable brandmanager da uretildi
        this.createTable(this.tmdl_brand, this.tbl_brand, col_brand, brandList);

        /*
        this.tmdl_brand.setColumnIdentifiers(col_brand); //yukarıda tanımladıgım kolon adlarını buraya koyuyorum. tmdl brandımım kolonlarını tanımlamıs oldum
        //------buraya kadar markanın kolonları belirlendi

        this.tbl_brand.setModel(this.tmdl_brand); //swing dek tbl_brand a olusturdugum tmdl tablosunu atadım.
        //TMDL MODELİME VERİLERİ EKLEYİP SWİNG TEKİ TBL_BRAND I MA VERİLRİ ATAMIS OLDUM
        //******************************************************
        this.tbl_brand.getTableHeader().setReorderingAllowed(false); //ekstra özellik. tablonun klonlarını manuel değiştirmeyi engeller
        this.tbl_brand.setEnabled(false); //ekstra özellik. tablonnun duzenlenebilirliğini apsif yap

//---------------------------------------------------------------------------------------------------------------------------------
//ARA KOD:
DefaultTableModel clearModel = (DefaultTableModel) tbl_brand.getModel();
clearModel.setRowCount(0); // bu kod her defasında tablonun içerisini boşaltıcak. altta da yeniden eklemeyi sağlıcam

//---------------------------------------------------------------------------------------------------------------------------------

        //*********BU DÖNGÜYLE BRAND VERİLERİMİ TABLOYA EKLİYORUZ
        for (Brand brand : brandList){
            Object[] obj = {brand.getId(), brand.getName()};
            this.tmdl_brand.addRow(obj);
        }
        //en önemli nokta: adminviewde olusturdugum (tbl_brand) tablosuna bu olusturmus oldugum tmdl_brand ı setliyorum.

*/

//---------------------------------------------------------------------------------------------------------------------------------

    }

    public void loadBrandComponent(){
        //ŞİMDİ TABLO GELDİ VE TABLODA POP UP MENULER İLE SAĞ TIKLAYIP EKLE,SİL,GÜNCELLE FONKSİYONLARINI YAPIYORUZ
        //alltaki menuleri olusturdukdan sonra burayı yazdım. şöyleki seçilen satıra sağ tıklayıp guncelleme yapmam lazım. bu nedenle
        //mouse listener ı kullanıyorum. burada satırı secebileyim ki bunun uzerinden işlem yapayım

        tableRowSelect(this.tbl_brand); //layouttan geliyor, mouse ın tıklanıldıgı nokta pointi veriyor
 //alt kısım tekrarlayan bir yapı oldugu için ilerleyen kısımlarda layout a alarak burayı pasife cektik
 //ve üstteki satırı ekledik buraya
  /*      this.tbl_brand.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = tbl_brand.rowAtPoint(e.getPoint()); // burasınn anlamı. tabloda mouse hangi alana denk geliyorsa bana getir
                tbl_brand.setRowSelectionInterval(selected_row, selected_row);
            }
        }); //MOUSE LISTENER İLE TABLODAKİ SATIRI SEÇTİRMEYİ SAĞLADIK.
*/
//---------------------------------------------------------------------------------------------------------------------------------------



        //----------------------------------------------------------------------------------------------------------------
        //yukarıda (cons), class ta JPopupMenuyu tanımladım. aşağıda menuleri olusturuyorum
        this.brand_menu = new JPopupMenu();
        this.brand_menu.add("Yeni").addActionListener(e -> {
            //System.out.println("yeni tıklandı")
            BrandView brandView = new BrandView(null); //satıra sağ tıklayıp yeni deyince yeni bir GUI açılacak (kaydet/dezenle için)

            brandView.addWindowListener(new WindowAdapter() {
                @Override                                       //buradaki windowlistener, view kapandıgında birşey tetikleyecek. yani
                public void windowClosed(WindowEvent e) {       //table ı yeniden yukleyecek
                    loadBrandTable();
                    loadModelTable(null); // branda gerçekleşen bir durumun model de de gerçekleşmesi için
                    loadModelFilter();
                }
            });

        }); // sağ tıkladıgımızda brnadview GUI açılıyor ve boş bir parametre gonderiyor kaydetme için. brandview brand parametresi alıyor dıarıdan
        //ancak null versem de bu sıkıntı yaratmıyor.

//************************************************************************************************************

        this.brand_menu.add("Güncelle").addActionListener(e -> {
            //güncelleme çin seçili olan brand in id sini almamız lazım. bunun için alttaki satırı yazıyoruz

                int selectBrandId = this.getTableSelectedRow(tbl_brand,0);

              //layout a tasındı --->  Integer.parseInt(tbl_brand.getValueAt(tbl_brand.getSelectedRow(), 0).toString()); //hangi row seçiliyse onun 0. indexindeki değeri veriyor ve bunu string donduruyor

            BrandView brandView = new BrandView(this.brandManager.getById(selectBrandId)); //seçili olan id yi database den alıp buraya getiriyor
            brandView.addWindowListener(new WindowAdapter() {
                @Override                                       //buradaki windowlistener, view kapandıgında birşey tetikleyecek. yani
                public void windowClosed(WindowEvent e) {       //table ı yeniden yukleyecek
                    loadBrandTable();
                    loadModelTable(null); // branda gerçekleşen bir durumun model de de gerçekleşmesi için
                    loadModelFilter();
                    loadCarTable();


                }
            });

            //(seçtiğim markanın guncellemesi için tıkladıgımda guncelleme ekranına gelmesi için brandviewde kod yazıyorum (if brand!=null)

            //üsteki satırda: 0. index i alıyoruz. tablomuzda 0. sütun brand_id ye denk geliyor. string dondurdugu için komut integer a ceviriyrz
            //NOT: burda satırın indexini seçtik bu brandı database den alıp brand e aktarıp brandview içine almam lazım --------*******önemli burası
            //bunun için branddao da geriye int id deger alan getById adında geriye brand donduren metot yazıyorz.
            //bu metotun amacı....

        });

//************************************************************************************************************
        this.brand_menu.add("Sil").addActionListener(e -> {
            //seçili olan satırdaki veriyiy silmek için seçili olan brand in id sini almak gerekiyor



            if (Helper.confirm("sure")) { // confirm metodunu Helper da yazdık ve burada cagırdık
                int selectBrandId = this.getTableSelectedRow(tbl_brand,0);
                //silme için brandid alındı artık branddao da silme yapıyorum. go to brand dao
                //brand dao dan brand manager a ve ardından tekrar buraya geliyoruz. ekstra olarak silmek istedigine emin misin diye soracagız

                //eger işlem için evt dediysem;
                if (this.brandManager.delete(selectBrandId)){ // eger delete metotuna verdigim selectbrandid true ise yani sil dediysem
                    Helper.showMsg("done");
                    loadBrandTable(); // tabloyu yeniden yukluyorum
                    loadModelTable(null); // branda gerçekleşen bir durumun model de de gerçekleşmesi için
                    loadModelFilter(); // filtreleme metotumu cagırıyor
                    loadCarTable();


                } else {
                    Helper.showMsg("error");
                }


            }

        });

//NOT: buraya kadar ekleme silme guncelleme işlemleri ni yaptık. buradan sonrası model tablolarına geçiyoruz.


//------------------------------------------------------------------------------------------------------------------------------------------------------------

        this.tbl_brand.setComponentPopupMenu(brand_menu); //menuleri olusturdum. burada da bunu tabloma entegre ediyorum
        //çalıştırdıgımda ekranda çıktı. ancak bunu tıklanıldıgında yapsın (seçili olan satıra) istiyoruz. bu nedenle actionerlistener lazım
        //her ekleme ve guncellemeden sonra tabloyu boşaltıp tekrar doldurmak için loadBrandTable metotunu yazıyorum
        //ve tablo için belirledigim özellikleri bu metot içine alıyrm. bknz alt kısım
    }

//**********************************************************************************************************************
//buraya textfield ın Customcreate checkbox ını işaretleyerek metotu olusturduk. tarih ayarlaması yapıcaz
    private void createUIComponents() throws ParseException {
        this.fld_strt_date = new JFormattedTextField(new MaskFormatter("##/##/####"));  //tarihin format ayarını yapıyoruz
        this.fld_strt_date.setText("10/10/2023");  // varsayıan deger atması yapıyorm
        this.fld_fnsh_date = new JFormattedTextField(new MaskFormatter("##/##/####")); //custom create leri secmeliyiz
        this.fld_fnsh_date.setText("19/10/2023");
    } // tarih formatını olusturduktan sonra tarihler arası işlem yapmak için car manager a gidiyoruz (searchforbooking işin içinde oldugu için buraya yazıyoruz)
    //**********************************************************************************************************************
}

