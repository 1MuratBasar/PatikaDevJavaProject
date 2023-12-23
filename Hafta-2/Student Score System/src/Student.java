public class Student {

    Course tarih ; // Course class ile connection kurup c1,c2,c3 nesnelerimizi üreterek Course class ın
                //nitelik ve methodlarına eriştik. bu bir referanstır.
    Course mat ;

    Course fzk;



    String name;
    String studentNo;
    String classes;
    double avg;
    boolean isPass;



    Student (String name, String studentNo, String classes, Course tarih, Course mat, Course fzk) {
        this.name = name;
        this.studentNo = studentNo;
        this.classes = classes;
        this.tarih = tarih;
        this.mat = mat;
        this.fzk = fzk;
        this.avg = 0.0;
        this.isPass = false;


    }





void addBulkExamNote (int tarihNote, int matNote, int fizikNote, int fzkSozlu, int tarihSozlu, int matSozlu )
{  // bu aralıklarda deği ise notlar saten varsayılan olarak 0 tnaımladıgımız için 0 alacak.
    // ama yine de alışmak için şartı koyduk

    if (fizikNote >= 0 && fizikNote <= 100 ) {
        if (fzkSozlu >= 0 && fzkSozlu <=100) {
            this.fzk.note = ((fzkSozlu* 0.20) + ( fizikNote* 0.80)) / 2;
            this.fzk.sozlu = fzkSozlu;
        }
    }
     else {
        this.fzk.note = 0;
        this.fzk.sozlu = 0;
    }

    if (tarihNote >= 0 && tarihNote <= 100 ) {
        if (tarihSozlu >= 0 && tarihSozlu <=100) {
            this.tarih.note = ((tarihSozlu* 0.25) + ( tarihNote* 0.75)) / 2;
            this.tarih.sozlu = tarihSozlu;
        }
    }
    else {
        this.tarih.note = 0;
        this.tarih.sozlu = 0;
    }

    if (matNote >= 0 && matNote <= 100 ) {
        if (matSozlu >= 0 && matSozlu <=100) {
            this.mat.note = ((matSozlu* 0.30) + ( matNote* 0.70)) / 2;
            this.mat.sozlu = matSozlu;
        }
    }
    else {
        this.mat.note = 0;
        this.mat.sozlu = 0;
    }


    }

  void printNote (){
      System.out.println(this.tarih.name + " notu\t\t\t : " + this.tarih.note);
      System.out.println(this.tarih.name + " sozlu notu\t : " + this.tarih.sozlu);
      System.out.println(this.mat.name + " notu\t\t : " + this.mat.note);
      System.out.println(this.mat.name + " sozlu notu : " + this.mat.sozlu);
      System.out.println(this.fzk.name + " notu\t\t\t : " + this.fzk.note);
      System.out.println(this.fzk.name + " sozlu notu\t : " + this.fzk.sozlu);
  }

  void isPass (){

      if (this.mat.note == 0 || this.fzk.note == 0 || this.tarih.note == 0) {
          System.out.println("Notlar tam olarak girilmemiş");
      } else {


          this.avg = ((this.tarih.note + this.mat.note + this.fzk.note ) / 3.0);

        if (this.avg >= 50) {
            System.out.println("Geçme durumu\t : " + "Sınıfı geçti");
            this.isPass = true;
        } else {
            System.out.println("Geçme durumu\t\t : " + "Sınıf tekrarı");
            this.isPass = false;
        }
            printNote();
      System.out.println("Dersler ort.\t\t : " + this.avg);
  }}
    void printStu (){
        System.out.println("Adı : " + this.name);
        System.out.println("Öğrenci no : " + this.studentNo);
        System.out.println("Sınıfı : " + this.classes);
        System.out.println("Aldığı kurslar : " + tarih.name + mat.name + fzk.name);


    }



}

