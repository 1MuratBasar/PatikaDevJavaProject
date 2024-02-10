package business;
import core.Helper;

//import dao.BookDao;
import dao.BookDao;
import dao.CarDao;
import dao.ModelDao;
//import entity.Book;
import entity.Book;
import entity.Car;
import entity.Model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CarManager {

    private final CarDao carDao;
    private final ModelDao modelDao;
    private final BookDao bookDao; // tarih işlemlerinden sonra, bookDao ile query i çalıştırıp dolu araçları bulmakk için ekledik

    public CarManager() {
        this.modelDao = new ModelDao();
        this.carDao = new CarDao();
        this.bookDao = new BookDao();

    }
//********************************************************************************************************
    public Car getById  (int id) {return this.carDao.getById(id);}
//********************************************************************************************************
    public ArrayList<Car> findAll() {return this.carDao.findAll();}
//********************************************************************************************************

    public ArrayList<Object[]> getForTable (int size, ArrayList<Car> cars) {
        ArrayList<Object[]> carList = new ArrayList<>();

        for (Car obj : cars) {
            int i=0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getModel().getBrand().getName();
            rowObject[i++] = obj.getModel().getName();
            rowObject[i++] = obj.getPlate();
            rowObject[i++] = obj.getColor();
            rowObject[i++] = obj.getKm();
            rowObject[i++] = obj.getModel().getYear();
            rowObject[i++] = obj.getModel().getType();
            rowObject[i++] = obj.getModel().getFuel();
            rowObject[i++] = obj.getModel().getGear();
            carList.add(rowObject);
        }
        return carList;
    }
//********************************************************************************************************

    public boolean save (Car car) {
        if (this.getById(car.getId()) != null) {
            Helper.showMsg("error");
            return false;
        }
        return this.carDao.save(car);

    }
//********************************************************************************************************

    public boolean update (Car car) {
        if (this.getById(car.getId()) == null) {
            Helper.showMsg(car.getId() + " ID kayıtlı araç bulunamadı");
            return false;
        }
        return this.carDao.update(car);
    }
//********************************************************************************************************

    public boolean delete (int id) {
        if (this.getById(id) == null) {
            Helper.showMsg(id + " ID kayıtlı araç bulunamadı");
            return false;
        }
        return this.carDao.delete(id);
    }
//********************************************************************************************************
   // arabaları cekip buradakş search üzerinden aramam yapmama lazım
   //lakin
    public ArrayList<Car> searchForBooking(String strt_date, String fnsh_date,
                                           Model.Type type, Model.Gear gear, Model.Fuel fuel) {
        String query = "SELECT * FROM public.car as c LEFT JOIN public.model as m";

        ArrayList<String> where = new ArrayList<>();
        ArrayList<String> joinWhere = new ArrayList<>();
//********************************************************************************************************
        //sonradan eklendi. aşagıda tarih aralıkları sorgusu in alttaki
        ArrayList<String> bookorWhere = new ArrayList<>(); // sorgu araları or olacak. boş bi arralist dondurecek sımdılık
//********************************************************************************************************

        joinWhere.add("c.car_model_id = m.model_id");

//********************************************************************************************************
        // TARİH İŞLEMLERİ İÇİN YAZIYORUZ
        //tarih çekiyoruz
        //gelen format = 10/10/2023 dd/MM/yyyy
        //veritabanında format = 2023-10-10  Y-m-d
       strt_date = LocalDate.parse(strt_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
       fnsh_date = LocalDate.parse(fnsh_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
       // tarih formatlarını ayarladıktan sonra musait araç var mı (bunun çin 2 tarih arasını cekip bu 2 tarih arasına denk gelen araçları cıkarırsam
        //musait araçları bulurum
//********************************************************************************************************

        if (fuel != null ) {
            where.add("m.model_fuel = '" + fuel.toString() + "'");

        }
        if (gear != null ) {
            where.add("m.model_gear = '" + gear.toString() + "'");

        }
        if (type != null ) {
            where.add("m.model_type = '" + type.toString() + "'");

        }

        String whereStr = String.join(" AND " , where);
        String joinStr = String.join(" AND " , joinWhere);

        if (joinStr.length() >0) {
            query+= " ON " + joinStr;
        }
        if (whereStr.length() >0) {
            query += " WHERE " + whereStr;
        }
//********************************************************************************************************
        // TARİHLER ARASINDA UYGUN OLAN AAÇLARI GETİRMEK İÇİN
        //1- kriterlere uyan butun araçları cek
        //2-bu tarihleri arası kiralnamıs aracları cek
        //3-cektigim araçlardan bu trihle arası kiralanmıs araçları cıkıp musait olanları buluyoruz

        ArrayList<Car> searchedList = this.carDao.selectByQuery(query); //kriterlere uyana aracları cek yeni bir array a at (!!! önemli nokta query den gelmesi)


        bookorWhere.add("('" + strt_date + "' BETWEEN book_strt_date AND book_fnsh_date)");
        bookorWhere.add("('" + fnsh_date + "' BETWEEN book_strt_date AND book_fnsh_date)");
        bookorWhere.add("(book_strt_date BETWEEN '" + strt_date + "' AND '" + fnsh_date + "')"); //bnm herhangi bir rezervason tarihi bnm istedigim tarihler arasında mı
        bookorWhere.add("(book_fnsh_date BETWEEN '" + strt_date + "' AND '" + fnsh_date + "')"); //bnm herhangi bir rezervason tarihi bnm istedigim tarihler arasında mı

        String bookOrWhereStr = String.join(" OR " , bookorWhere); //query birleştirme yapıyorum
        String bookQuery = "SELECT * FROM public.book WHERE " + bookOrWhereStr; //query birleştirme

      //test  System.out.println(bookQuery);

//********************************************************************************************************
        //BOOKDAO işlemleri için yazıyoruz
        //yukarıda bookdao olusturuldu sonra aşadıya devam. bookdao içiinde query çalıştırıp uyugun tarihlerdeki araçları alıcz
        ArrayList<Book> bookList = this.bookDao.selectByQuery(bookQuery); // arraylist dön. bana tarihler (varsayılan) tum araçları getir
        // test System.out.println(busyCarList);
        ArrayList<Integer> busyCarId = new ArrayList<>(); //tarihle arasında olan ve gelmesini istemedigm araçlar için id list alıyorum
        for (Book book : bookList) {
            busyCarId.add(book.getCar_id());  // ben meşgul araba id lerinin içerisine bu bookların getcarid lerini atıcam. yani hangi araçların dolu oldugunun id verileri

        }
        //kriterlere uyan araçlardan meşgulleri cıkarmak için altta

        searchedList.removeIf(car -> busyCarId.contains(car.getId()));  //benim listemden busycarid var ise cıkar demek
        return searchedList; //geriye elimde sadece serachedlist kalıyor donduruyorum

        //return this.carDao.selectByQuery(query);
//********************************************************************************************************

    }


}
