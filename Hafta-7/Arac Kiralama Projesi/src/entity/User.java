package entity;

//veritabanından cektigimiz her veriyi burada olusturdugumuz User sınıfından üretilmiş bir
// nesneye atacagız
public class User {
    private int id;
    private String username;
    private String password;
    private String role;

    public User () {


    }

    public User(int id, String username, String passwprd, String role) {
        this.id = id;
        this.username = username;
        this.password = passwprd;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwprd) {
        this.password = passwprd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    //login de kayıt sorgularken boyle bi kullancıı varsa bilgileri consola al diye tostringi cagırıyorum
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
