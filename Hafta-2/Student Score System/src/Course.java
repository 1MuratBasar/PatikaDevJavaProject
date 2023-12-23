/*
Course Sınıfı Özellikleri :

Nitelikler : name,code,prefix,note,Teacher
Metotlar : Course() , addTeacher() , printTeacher()
 */
public class Course {
    Teacher teacher; //Teacher class ile connection kurup teacher nesnemizi ürettik ve bu nesneyle Teacher
                    // class ın içeriğine ulaşabiliyoruz. bu bir referans.
    String name;
    String code;
    String prefix;
    double note; // ilk etapta almıyorum varsayılan 0 olacak
    int sozlu;

    Course (String name, String code, String prefix ) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.note = 0;
        this.sozlu = 0;
    }

    void addTeacher (Teacher teacher) {

        if (teacher.branch.equals(this.prefix)){
            this.teacher = teacher;
          //  printTeachar();
          //  System.out.println("Öğretmen eşleşmesi yapıldı.");
        } else {
            System.out.println("Öğretmen ve ders bölümleri uyuşmuyor.");
        }


    }

    void printTeachar(){

        this.teacher.printTeacher();
    }




}
