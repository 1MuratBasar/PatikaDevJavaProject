public class Daire {
    public double r;
    public static final double PI = 3.14;
    public double random;
public Daire (double r){

    this.r = r;
    this.random = random;
}


public void calArea() {
    double area = PI * this.r;
    System.out.println("dairenin alanı " + area);
}

    public double calArea2() {
        random = Math.random()*10;
        double area2 = random * this.r;
       // System.out.println("dairenin alanı " + area2);
        return area2;
    }
}


