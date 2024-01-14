public class Main {
    public static void main(String[] args) {
        User us = new User("Murat") ;
        User us2 = new User("Başar") ;
        User us4 = new User("lod") ;
        System.out.println(User.counter);
        System.out.println(us.name + " " +  us2.name);

    }
}
