public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[3][];

        arr[2] = new int[4];
        int sum = 0;
        arr[2][2] = 1;
        arr[2][3] = 2;
        System.out.println(arr[2][2]);
        System.out.println(arr[2][3]);
    }
}
