/*
Teacher Sınıfı Özellikleri :
Nitelikler : name,mpno,branch
Metotlar : Teacher()
public class Teacher
 */
    public class Teacher {

        String name;
        String mpno;
        String branch;

        Teacher (String name, String mpno, String branch) {

            this.name = name;
            this.mpno = mpno;
            this.branch = branch;
        }


        void printTeacher (){
            System.out.println("Adı : " + this.name);
            System.out.println("Telefon : " + this.mpno);
            System.out.println("Sınıf : " + this.branch);

        }

    }


