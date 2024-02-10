package business;

import core.Helper;
import dao.HotelDao;
import dao.PensionDao;
import dao.SeasonDao;
import entity.Hotel;
import entity.Pension;
import entity.Season;


import java.util.ArrayList;


public class SeasonManager {

    private final SeasonDao seasonDao;
    private HotelManager hotelManager;
    private HotelDao hotelDao;

    public SeasonManager() {

        this.hotelManager = new HotelManager();
        this.hotelDao = new HotelDao();
        this.seasonDao = new SeasonDao();
    }



    //----------------------------------------------------------------------------------------------------------------------
    public ArrayList<Object[]> getForTable(int size, ArrayList<Season> seasonList) { // metot içerisine tablonun kolon sayısını alacak
        //bu metot benm için bir tablonun kolon sayısını alıcak
        ArrayList<Object[]> seasonRowList = new ArrayList<>();
        for (Season season : seasonList) {
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = season.getId();  //rowobjeye tek tek alanları atıyoruz böylece size elde ediyoruz
            rowObject[i++] = season.getHotel_id();
            rowObject[i++] = season.getStrt_date();
            rowObject[i++] = season.getFnsh_date();

            seasonRowList.add(rowObject);

        }
        return seasonRowList; //elde edilen size brandrowliste e bize geliyor

    } // burada kolon sayısı kadar objeolusturduk


//----------------------------------------------------------------------------------------------------------------------

    public ArrayList<Season> findAll() { // asıl sorguyu branddao da yazdık. burası view ile yönetimsel ilişki kurma katmanı.
        //burada gelmesini istedigimiz sorguya farklı kontroller ekleyebilir.
        return this.seasonDao.findAll();
    }

    public boolean save(Season season) {
        if (season.getId() != 0) {
            Helper.showMsg("error");  //bu tarz kontrolelri burada yapıyoruz. dao yu bulaştırmıyoruz
        }
        return this.seasonDao.save(season); // asıl sorguyu branddao da yazdık. burası view ile yönetimsel ilişki kurma katmanı.
        //burada gelmesini istedigimiz sorguya farklı kontroller ekleyebiliriz.
        //NOT: aynı ID den varsa save olamayacagının kontrolünü burda yapıyoruz. üstte sorguya bknz
        //son olarak brandmanager e save ekledigime göre iletişim kurması için brandview e gidiyoruz
    }

    public Season getById(int id) {
        return this.seasonDao.getById(id); //branddao da yazılan ve güncelleme için id döndüren getById metotu için yazıldı.
    }

    public boolean update (Season season){
        if (this.getById(season.getId()) == null){  // bu brand id li biri var mı diye kontrol ettiriyorum
            Helper.showMsg("notFound");
        }
        return this.seasonDao.update(season);

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
        return this.seasonDao.delete(id);
//********************************************

    }



}



