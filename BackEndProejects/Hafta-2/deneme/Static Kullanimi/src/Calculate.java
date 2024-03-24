public class Calculate {


    public  static void  calcAverage (Course[] notes) {
        double total=0;
        for (Course c: notes) {
            total += c.note;
        }
        double avg = total/notes.length;
        System.out.println(avg);
    }

}
