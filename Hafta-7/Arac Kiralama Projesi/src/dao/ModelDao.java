package dao;

import core.Db;
import entity.Brand;
import entity.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelDao {
    private Connection con;
    private final BrandDao brandDao = new BrandDao();
//*************************************************************************************************************

    public ModelDao()  {
        this.con = Db.getInstance();
    }   //connection aldık singletonyapımız
//*************************************************************************************************************
    public Model getById (int id) { // id ye gore veriyi getirecek
        Model obj = null;
        String query = "SELECT * FROM public.model WHERE model_id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = this.match(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;

    }
//*************************************************************************************************************
    public ArrayList<Model> findAll (){ //bütün modelleri getirmek iççin

        return this.selectByQuery("SELECT * FROM public.model ORDER BY model_id ASC");
    }

//*************************************************************************************************************

    public ArrayList<Model> getByListBrandId (int brandId){

        return this.selectByQuery("SELECT * FROM public.model WHERE model_brand_id = " + brandId);
    //bursı brand da silinen bir markaya ait verilerin modelde de silinmesi için olusturuldu
    //sorguya göre dışarıdan gelen brandid sorguda ilgili markaya denk gelen verileri bulacak. buradan modelmanager
        // getByListBrandIde gidiyoruz
    }
//*************************************************************************************************************
/*
    public ArrayList<Model> getByBrandId (int brandId){

        return this.selectByQuery("SELECT * FROM public.model WHERE model_brand_id = " + brandId);
    }
*/
//*************************************************************************************************************

//custom bir query ile select yapma işlemi sağlayabilmek için yazıldı

    public ArrayList<Model> selectByQuery (String query) {
        ArrayList<Model> modelList = new ArrayList<>();
        try {
            ResultSet rs = this.con.createStatement().executeQuery(query); //dikkat edilrse yukarıdaki sql sorgusu burada kalıp hale getirildi
            while (rs.next()) { //yani bu metot kullanılarak otomatik bir query atılabilir
                modelList.add(this.match(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return modelList;
    }

//*************************************************************************************************************

    //SAVE METOTU
    public boolean save (Model model) {
        String query = "INSERT INTO public.model " +
                "(" +
                "model_brand_id," +
                "model_name," +
                "model_type," +
                "model_year," +
                "model_fuel," +
                "model_gear" +
                ")" +
                " VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1,model.getBrand_id());
            pr.setString(2, model.getName());
            pr.setString(3, model.getType().toString());
            pr.setString(4, model.getYear());
            pr.setString(5, model.getFuel().toString());
            pr.setString(6, model.getGear().toString());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

//*************************************************************************************************************

//UPDATE METOTU
    public boolean update (Model model) {
        String query = "UPDATE public.model SET " +
                "model_brand_id = ? , " +
                "model_name = ? , " +
                "model_type = ? , " +
                "model_year = ? , " +
                "model_fuel = ? , " +
                "model_gear = ? " +
                "WHERE model_id = ?";

        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1,model.getBrand_id());
            pr.setString(2, model.getName());
            pr.setString(3, model.getType().toString());
            pr.setString(4, model.getYear());
            pr.setString(5, model.getFuel().toString());
            pr.setString(6, model.getGear().toString());
            pr.setInt(7, model.getId());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
//*************************************************************************************************************
//DELETE METOTU
    public boolean delete (int model_id) {
        String query = "DELETE FROM public.model WHERE model_id = ? ";

        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, model_id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
//*************************************************************************************************************
//MATCH METOTU
    //metotda tek farklı nokta fuel,gear ve type ı valueof metoduyla veritabanından alarak burda yeni alana setliyorum
    public Model match (ResultSet rs) throws SQLException {
        Model model = new Model();
        model.setId(rs.getInt("model_id"));
        model.setName(rs.getString("model_name"));
        model.setFuel(Model.Fuel.valueOf(rs.getString("model_fuel")));
        model.setGear(Model.Gear.valueOf(rs.getString("model_gear")));
        model.setType(Model.Type.valueOf(rs.getString("model_type")));
        model.setYear(rs.getString("model_year"));
        model.setBrand(this.brandDao.getById(rs.getInt("model_brand_id")));
        //brand i match ettiğimiz için modeli cekiyoruz. model de kendi içinde brandi cekiyor. ordan roaya ulaşıyoruz
        model.setBrand_id(rs.getInt("model_brand_id"));
        return model;
    }
//*************************************************************************************************************


//*************************************************************************************************************
}
