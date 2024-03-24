public class Employee {
    String name;
    double salary;
    double workHours;
    int hireYear;


    Employee(String name, double salary, double workHours, int hireYear) {

        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;

    }

    double tax (){

        if (this.salary >= 1000) {
            return (this.salary * 0.03);
        } else {

            return 0;

    }}

    double bonus (){

        if (this.workHours > 40){

            return (this.workHours - 40 ) * 30;

        }
        return 0;
    }

    double raiseSalary () {
        int tFark = 2021 - this.hireYear;
        if (tFark >= 0 && tFark < 10) {
            return (this.salary * 0.05);
        }
        if (tFark >= 10 && tFark < 20) {
            return (this.salary * 0.10);
        }
        if (tFark >= 20) {
            return (this.salary * 0.15);
        }
        return 0;
    }

        void printInfo () {
            System.out.println("Adı \t\t\t\t: " + this.name);
            System.out.println("Maaşı \t\t\t\t: " + this.salary);
            System.out.println("Çalışma Saati \t\t: " + this.workHours);
            System.out.println("Başlangıç Yılı  \t: " + this.hireYear);
            System.out.println("Vergi \t\t\t\t: " + tax());
            System.out.println("Bonus \t\t\t\t: " + bonus());
            System.out.println("Maaş Artışı \t\t: " + raiseSalary());
            System.out.println("Vergi+Bonus+Maaş \t: " + ((this.salary) - tax() + bonus()));
            System.out.println("Toplam Maaş  \t\t: " + (raiseSalary() + this.salary - tax() + bonus()));

        }

    }



