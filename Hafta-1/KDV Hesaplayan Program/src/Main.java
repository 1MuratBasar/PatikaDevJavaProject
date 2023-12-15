import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double tutar, kdvTutar, kdvOran=0.18, kdvOran2=0.08, kdvliTutar;
        Scanner sca = new Scanner(System.in);
        System.out.print("Ücret tutarı giriniz : ");
         tutar = sca.nextDouble();


        if (tutar >= 0 && tutar <1000)

        {
            kdvTutar = tutar * kdvOran;
            kdvliTutar = tutar + kdvTutar;
          //  tutar = tutar*1.18;
          //  System.out.println(kdvliTutar);
            System.out.println("KDVsiz Tutar : " + tutar);
            System.out.println("KDV Oranı : " + kdvOran);
            System.out.println("KDV tutarı : " + kdvTutar);
            System.out.println("KDV li Tutar : " + kdvliTutar);
        }
        if (tutar >= 1000)
        {
            kdvTutar = tutar * kdvOran2;
            kdvliTutar = tutar + kdvTutar;
         //   tutar  = tutar*1.08;
         //   System.out.println(kdvliTutar);
            System.out.println("KDVsiz Tutar : " + tutar);
            System.out.println("KDV Oranı : " + kdvOran2);
            System.out.println("KDV tutarı : " + kdvTutar);
            System.out.println("KDV li Tutar : " + kdvliTutar);
        }



/* kdvTutar = tutar * kdvOran;
        kdvliTutar = tutar + kdvTutar;

        System.out.println("KDVsiz Tutar : " + tutar);
        System.out.println("KDV Oranı : " + kdvOran);
        System.out.println("KDV tutarı : " + kdvTutar);
        System.out.println("KDV li Tutar : " + kdvliTutar);*/





    }
}