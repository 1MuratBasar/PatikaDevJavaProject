package business;

import core.Helper;
import dao.HotelDao;
import dao.PensionDao;
import entity.Hotel;
import entity.Pension;


import java.util.ArrayList;


public class PensionManager {

    private final PensionDao pensionDao;
    private HotelManager hotelManager;
        private HotelDao hotelDao;

    public PensionManager() {
        this.pensionDao = new PensionDao();
        this.hotelManager = new HotelManager();
        this.hotelDao = new HotelDao();
    }


    //----------------------------------------------------------------------------------------------------------------------
    public ArrayList<Object[]> getForTable(int size, ArrayList<Pension> penslionList) { // metot içerisine tablonun kolon sayısını alacak
        //bu metot benm için bir tablonun kolon sayısını alıcak
        ArrayList<Object[]> pensionRowList = new ArrayList<>();
        for (Pension pension : penslionList) {
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = pension.getId();  //rowobjeye tek tek alanları atıyoruz böylece size elde ediyoruz
            rowObject[i++] = pension.getHotel_id();
            rowObject[i++] = pension.getPension_type();

            pensionRowList.add(rowObject);

        }
        return pensionRowList; //elde edilen size brandrowliste e bize geliyor

    } // burada kolon sayısı kadar objeolusturduk


//----------------------------------------------------------------------------------------------------------------------

    public ArrayList<Pension> findAll() { // asıl sorguyu branddao da yazdık. burası view ile yönetimsel ilişki kurma katmanı.
        //burada gelmesini istedigimiz sorguya farklı kontroller ekleyebilir.
        return this.pensionDao.findAll();
    }

    public boolean save(Pension pension) {
        if (pension.getId() != 0) {
            Helper.showMsg("error");  //bu tarz kontrolelri burada yapıyoruz. dao yu bulaştırmıyoruz
        }
        return this.pensionDao.save(pension); // asıl sorguyu branddao da yazdık. burası view ile yönetimsel ilişki kurma katmanı.
        //burada gelmesini istedigimiz sorguya farklı kontroller ekleyebiliriz.
        //NOT: aynı ID den varsa save olamayacagının kontrolünü burda yapıyoruz. üstte sorguya bknz
        //son olarak brandmanager e save ekledigime göre iletişim kurması için brandview e gidiyoruz
    }

    public Pension getById(int id) {
        return this.pensionDao.getById(id); //branddao da yazılan ve güncelleme için id döndüren getById metotu için yazıldı.
    }

    public boolean update (Pension pension){
        if (this.getById(pension.getId()) == null){  // bu brand id li biri var mı diye kontrol ettiriyorum
            Helper.showMsg("notFound");
        }
        return this.pensionDao.update(pension);

    }

    public boolean delete(int id) {
        if (this.getById(id) == null) {  // veritabanında böyle bi row yoksa hata dondur
            Helper.showMsg(id + "kayıtlı marka bulunamadı !"); //custome mesaj verdigim için defaul mesaj donecek
            return false;
        }
//********************************************
      /*  for (Hotel hotel : this.modelManager.getByListBrandId(id)){ // burası brand da siline bir markaya ait verilerin
            this.modelManager.delete(model.getId());    //modelde de silinmesi için eklendi
        }
*/
        return this.pensionDao.delete(id);
//********************************************


    }

}



