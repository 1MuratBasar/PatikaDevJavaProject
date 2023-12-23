



public class Main {
    public static void main(String[] args) {

Teacher t1 = new Teacher("Murat", "+905301234567","TRH");
Teacher t2 = new Teacher("Hasan", "+905307654321","FZK");
Teacher t3 = new Teacher("Mehmet", "+905313579012","MATH");
Teacher t4 = new Teacher("Ayşe", "+905551234567","BIO");

Course tarih = new Course("Tarih", "101","TRH");
tarih.addTeacher(t1);
Course fizik = new Course("Fizik", "102","FZK");
fizik.addTeacher(t2);
Course matematik = new Course("Matematik", "101","MATH");
matematik.addTeacher(t3);
Course biyoloji = new Course("Biyoloji","102","BIO");
biyoloji.addTeacher(t4);



Student stu1 = new Student("Cenk","111","3",tarih,matematik,fizik);
stu1.addBulkExamNote(50,50,50,100,100,100);

stu1.isPass();









    }



}