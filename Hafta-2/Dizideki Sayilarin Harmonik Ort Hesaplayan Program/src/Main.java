public class Main {
    public static void main(String[] args) {
        double[] numbers = {1, 2, 3};
        double harmonicAvg = 0;
        double harmonicSerie = 0;
        for (int i = 0; i < numbers.length; i++) {
            harmonicSerie = harmonicSerie + ( 1 /numbers[i]);
            harmonicAvg = (numbers.length) / harmonicSerie;
        }

        System.out.println(harmonicAvg);
    }
}