public class Main {
    public static void main(String[] args) {

        //  Player p1 = new Player("Murat B",1);
        //    Player.showName();

        Course ders1 = new Course("Matematik", "101", 50);
        Course ders2 = new Course("fizik", "101", 10);
        Course ders3 = new Course("kimya", "101", 70);
        Course[] notlar = {ders1, ders2, ders3};
     //   Calculate cal = new Calculate();
       Calculate.calcAverage(notlar);



    }
}