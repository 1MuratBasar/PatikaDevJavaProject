package business;

import core.Helper;
import dao.BrandDao;
import entity.Brand;
import entity.Model;

import java.util.ArrayList;
import java.util.Objects;


public class BrandManager {

    private final BrandDao brandDao;
    private final ModelManager modelManager;

    public BrandManager() {
        this.brandDao = new BrandDao();
        this.modelManager = new ModelManager();
    }


//----------------------------------------------------------------------------------------------------------------------
public ArrayList<Object[]> getForTable (int size) { // metot içerisine tablonun kolon sayısını alacak
    //bu metot benm için bir tablonun kolon sayısını alıcak
    ArrayList<Object[]>  brandRowList = new ArrayList<>();
    for (Brand brand : this.findAll()){
        Object[] rowObject = new Object[size];
        int i = 0;
        rowObject[i++] = brand.getId();  //rowobjeye tek tek alanları atıyoruz böylece size elde ediyoruz
        rowObject[i++] = brand.getName();
        brandRowList.add(rowObject);

    }
    return brandRowList; //elde edilen size brandrowliste e bize geliyor

} // burada kolon sayısı kadar objeolusturduk


//----------------------------------------------------------------------------------------------------------------------

    public ArrayList<Brand> findAll () { // asıl sorguyu branddao da yazdık. burası view ile yönetimsel ilişki kurma katmanı.
        //burada gelmesini istedigimiz sorguya farklı kontroller ekleyebilir.
        return this.brandDao.findAll();
    }

    public boolean save (Brand brand){
        if (brand.getId() !=0) {
            Helper.showMsg("error");  //bu tarz kontrolelri burada yapıyoruz. dao yu bulaştırmıyoruz
        }
        return this.brandDao.save(brand); // asıl sorguyu branddao da yazdık. burası view ile yönetimsel ilişki kurma katmanı.
        //burada gelmesini istedigimiz sorguya farklı kontroller ekleyebiliriz.
        //NOT: aynı ID den varsa save olamayacagının kontrolünü burda yapıyoruz. üstte sorguya bknz
        //son olarak brandmanager e save ekledigime göre iletişim kurması için brandview e gidiyoruz
    }

    public Brand getById (int id) {
        return this.brandDao.getById(id); //branddao da yazılan ve güncelleme için id döndüren getById metotu için yazıldı.
    }

    public boolean update (Brand brand){
        if (this.getById(brand.getId()) == null){  // bu brand id li biri var mı diye kontrol ettiriyorum
            Helper.showMsg("notFound");
        }
        return this.brandDao.update(brand);

    }

    public boolean delete (int id){
        if (this.getById(id) == null){  // veritabanında böyle bi row yoksa hata dondur
            Helper.showMsg( id + "kayıtlı marka bulunamadı !"); //custome mesaj verdigim için defaul mesaj donecek
            return false;
        }
//********************************************
        for (Model model : this.modelManager.getByListBrandId(id)){ // burası brand da siline bir markaya ait verilerin
            this.modelManager.delete(model.getId());    //modelde de silinmesi için eklendi
        }

        return this.brandDao.delete(id);
//********************************************

    }


}
