package business;

import core.Helper;
import dao.RoomDao;
import entity.Room;


import java.util.ArrayList;


public class RoomManager {

    private final RoomDao roomDao;


    public RoomManager() {
        this.roomDao = new RoomDao();

    }


    //----------------------------------------------------------------------------------------------------------------------
    public ArrayList<Object[]> getForTable(int size, ArrayList<Room> roomList) { // metot içerisine tablonun kolon sayısını alacak
        //bu metot benm için bir tablonun kolon sayısını alıcak
        ArrayList<Object[]> roomRowList = new ArrayList<>();
        for (Room room : roomList) {
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = room.getRoom_id();  //rowobjeye tek tek alanları atıyoruz böylece size elde ediyoruz
            rowObject[i++] = room.getHotel_name();
            rowObject[i++] = room.getPension();
            rowObject[i++] = room.getRoom_type();
            rowObject[i++] = room.getSeason_strt_date();
            rowObject[i++] = room.getSeason_fnsh_date();
            rowObject[i++] = room.getStock();
            rowObject[i++] = room.getBed();
            rowObject[i++] = room.getMetresquare();
            rowObject[i++] = room.getPrc_adult();
            rowObject[i++] = room.getPrc_child();
            rowObject[i++] = room.isAir_conditioning() ? "VAR" : "YOK";
            rowObject[i++] = room.isMinibar() ? "VAR" : "YOK";
            rowObject[i++] = room.isTv() ? "VAR" : "YOK";
            rowObject[i++] = room.isBcase() ? "VAR" : "YOK";
            rowObject[i++] = room.isFridge() ? "VAR" : "YOK";


            roomRowList.add(rowObject);

        }
        return roomRowList; //elde edilen size brandrowliste e bize geliyor

    } // burada kolon sayısı kadar objeolusturduk


//----------------------------------------------------------------------------------------------------------------------

    public ArrayList<Room> findAll() { // asıl sorguyu branddao da yazdık. burası view ile yönetimsel ilişki kurma katmanı.
        //burada gelmesini istedigimiz sorguya farklı kontroller ekleyebilir.
        return this.roomDao.findAll();
    }

    public boolean save(Room room) {
        if (room.getRoom_id() != 0) {
            Helper.showMsg("error");  //bu tarz kontrolelri burada yapıyoruz. dao yu bulaştırmıyoruz
        }
        return this.roomDao.save(room); // asıl sorguyu branddao da yazdık. burası view ile yönetimsel ilişki kurma katmanı.
        //burada gelmesini istedigimiz sorguya farklı kontroller ekleyebiliriz.
        //NOT: aynı ID den varsa save olamayacagının kontrolünü burda yapıyoruz. üstte sorguya bknz
        //son olarak brandmanager e save ekledigime göre iletişim kurması için brandview e gidiyoruz
    }

    public Room getById(int id) {
        return this.roomDao.getById(id); //branddao da yazılan ve güncelleme için id döndüren getById metotu için yazıldı.
    }

    public boolean update(Room room) {
        if (this.getById(room.getRoom_id()) == null) {  // bu brand id li biri var mı diye kontrol ettiriyorum
            Helper.showMsg("notFound");
        }
        return this.roomDao.update(room);

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
        return this.roomDao.delete(id);
//********************************************


    }

    //********************************************//********************************************

    public ArrayList<Room> searchForTable(String hotel_name, String city) {
        String select1 = "SELECT * FROM public.room";
        ArrayList<String> whereList = new ArrayList<>();



        if (hotel_name != null) {
            whereList.add("hotel_name LIKE '%" + hotel_name + "%'");
        }
        if (city != null) {
            whereList.add("hotel_name LIKE '%" + city + "%'");
        }

        String whereStr = String.join(" AND ", whereList);
        String query2 = select1;

        if (whereStr.length() > 0) {
            query2 += " WHERE " + whereStr;
        }


        return this.roomDao.selectByQuery(query2);

    }
}








