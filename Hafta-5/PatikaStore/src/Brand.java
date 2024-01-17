import java.util.Comparator;
import java.util.TreeSet;

public class Brand implements Comparable <Brand> {

    private int id;
    private String name;
    private static int idCounter=1;

    public Brand( String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public Brand(){

    }

    private static TreeSet <Brand> brandList = new TreeSet<>();
    static {
        brandList.add(new Brand("Samsun"));
        brandList.add(new Brand("Lenovo"));
        brandList.add(new Brand("Apple"));
        brandList.add(new Brand("Huawei"));
        brandList.add(new Brand("Casper"));
        brandList.add(new Brand("Asus"));
        brandList.add(new Brand("HP"));
        brandList.add(new Brand("Xiaomi"));
        brandList.add(new Brand("Monster"));
    }


    @Override
    public int compareTo(Brand o) {
        return this.name.compareTo(o.getName());
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

    public TreeSet<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(TreeSet<Brand> brandList) {
        this.brandList = brandList;
    }

    public void printBrand() {
        for (Brand brand : brandList){
            System.out.println("- " + brand.getName());
        }
    }
}

