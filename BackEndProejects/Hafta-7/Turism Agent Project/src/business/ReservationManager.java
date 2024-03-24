package business;

import core.Helper;
import dao.HotelDao;
import dao.ReservationDao;
import entity.Hotel;
import entity.Reservation;
import entity.Season;


import java.util.ArrayList;


public class ReservationManager {

    private final ReservationDao reservationDao;


    public ReservationManager() {
        this.reservationDao = new ReservationDao();

    }


    //----------------------------------------------------------------------------------------------------------------------
    public ArrayList<Object[]> getForTable(int size, ArrayList<Reservation> reservationList) { // metot içerisine tablonun kolon sayısını alacak
        //bu metot benm için bir tablonun kolon sayısını alıcak
        ArrayList<Object[]> reservationRowList = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = reservation.getId();  //rowobjeye tek tek alanları atıyoruz böylece size elde ediyoruz
            rowObject[i++] = reservation.getRoom_id();
            rowObject[i++] = reservation.getCheckin_date();
            rowObject[i++] = reservation.getCheckout_date();
            rowObject[i++] = reservation.getTotal_price();
            rowObject[i++] = reservation.getGuest_count();
            rowObject[i++] = reservation.getGuest_name();
            rowObject[i++] = reservation.getGuest_idno();
            rowObject[i++] = reservation.getGuest_mail();
            rowObject[i++] = reservation.getGuest_phone();



            reservationRowList.add(rowObject);

        }
        return reservationRowList; //elde edilen size brandrowliste e bize geliyor

    } // burada kolon sayısı kadar objeolusturduk


//----------------------------------------------------------------------------------------------------------------------

    public ArrayList<Reservation> findAll() { // asıl sorguyu branddao da yazdık. burası view ile yönetimsel ilişki kurma katmanı.
        //burada gelmesini istedigimiz sorguya farklı kontroller ekleyebilir.
        return this.reservationDao.findAll();
    }

    public boolean save(Reservation reservation) {
        if (reservation.getId() != 0) {
            Helper.showMsg("error");  //bu tarz kontrolelri burada yapıyoruz. dao yu bulaştırmıyoruz
        }
        return this.reservationDao.save(reservation); // asıl sorguyu branddao da yazdık. burası view ile yönetimsel ilişki kurma katmanı.
        //burada gelmesini istedigimiz sorguya farklı kontroller ekleyebiliriz.
        //NOT: aynı ID den varsa save olamayacagının kontrolünü burda yapıyoruz. üstte sorguya bknz
        //son olarak brandmanager e save ekledigime göre iletişim kurması için brandview e gidiyoruz
    }

    public Reservation getById(int id) {
        return this.reservationDao.getById(id); //branddao da yazılan ve güncelleme için id döndüren getById metotu için yazıldı.
    }

    public boolean update (Reservation reservation){
        if (this.getById(reservation.getId()) == null){  // bu brand id li biri var mı diye kontrol ettiriyorum
            Helper.showMsg("notFound");
        }
        return this.reservationDao.update(reservation);

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
        return this.reservationDao.delete(id);
//********************************************


    }

}



