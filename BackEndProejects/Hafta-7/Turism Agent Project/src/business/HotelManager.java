package business;

import core.Helper;
import dao.HotelDao;
import entity.Hotel;
import entity.Season;


import java.util.ArrayList;


public class HotelManager {

    private final HotelDao hotelDao;


    public HotelManager() {
        this.hotelDao = new HotelDao();

    }


    //----------------------------------------------------------------------------------------------------------------------
    public ArrayList<Object[]> getForTable(int size, ArrayList<Hotel> modelList) { // metot içerisine tablonun kolon sayısını alacak
        //bu metot benm için bir tablonun kolon sayısını alıcak
        ArrayList<Object[]> hotelRowList = new ArrayList<>();
        for (Hotel hotel : modelList) {
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = hotel.getId();  //rowobjeye tek tek alanları atıyoruz böylece size elde ediyoruz
            rowObject[i++] = hotel.getHotel_name();
            rowObject[i++] = hotel.getCity();
            rowObject[i++] = hotel.getRegion();
            rowObject[i++] = hotel.getAddress();
            rowObject[i++] = hotel.getMail();
            rowObject[i++] = hotel.getPhone();
            rowObject[i++] = hotel.getStar();
            rowObject[i++] = hotel.isCarpark() ? "VAR" : "YOK";
            rowObject[i++] = hotel.isWifi() ? "VAR" : "YOK";
            rowObject[i++] = hotel.isPool() ? "VAR" : "YOK";
            rowObject[i++] = hotel.isFitness() ? "VAR" : "YOK";
            rowObject[i++] = hotel.isConclerge() ? "VAR" : "YOK";
            rowObject[i++] = hotel.isSpa() ? "VAR" : "YOK";
            rowObject[i++] = hotel.isRoomservice() ? "VAR" : "YOK";


            hotelRowList.add(rowObject);

        }
        return hotelRowList; //elde edilen size brandrowliste e bize geliyor

    } // burada kolon sayısı kadar objeolusturduk


//----------------------------------------------------------------------------------------------------------------------

    public ArrayList<Hotel> findAll() { // asıl sorguyu branddao da yazdık. burası view ile yönetimsel ilişki kurma katmanı.
        //burada gelmesini istedigimiz sorguya farklı kontroller ekleyebilir.
        return this.hotelDao.findAll();
    }

    public boolean save(Hotel hotel) {
        if (hotel.getId() != 0) {
            Helper.showMsg("error");  //bu tarz kontrolelri burada yapıyoruz. dao yu bulaştırmıyoruz
        }
        return this.hotelDao.save(hotel); // asıl sorguyu branddao da yazdık. burası view ile yönetimsel ilişki kurma katmanı.
        //burada gelmesini istedigimiz sorguya farklı kontroller ekleyebiliriz.
        //NOT: aynı ID den varsa save olamayacagının kontrolünü burda yapıyoruz. üstte sorguya bknz
        //son olarak brandmanager e save ekledigime göre iletişim kurması için brandview e gidiyoruz
    }

    public Hotel getById(int id) {
        return this.hotelDao.getById(id); //branddao da yazılan ve güncelleme için id döndüren getById metotu için yazıldı.
    }

    public boolean update (Hotel hotel){
        if (this.getById(hotel.getId()) == null){  // bu brand id li biri var mı diye kontrol ettiriyorum
            Helper.showMsg("notFound");
        }
        return this.hotelDao.update(hotel);

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
        return this.hotelDao.delete(id);
//********************************************


    }

}



