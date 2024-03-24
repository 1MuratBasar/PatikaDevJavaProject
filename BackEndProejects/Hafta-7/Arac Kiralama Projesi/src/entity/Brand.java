package entity;

public class Brand {
    private int id;
    private String name;

    public Brand() {
    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brand( String name) {
         this.name = name; // burayı sonradan olusturduk. kayıt esnasında sadece marka adı eklemek için kullanıcam. bknz btn_brand_save listener
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
