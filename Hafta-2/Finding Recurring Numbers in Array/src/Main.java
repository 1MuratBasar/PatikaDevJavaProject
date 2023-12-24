import java.util.Arrays;
public class Main {
    // son koşula mod şartı eklenerek çift sayılar elde kaldı
    //duplicate içine atıcağımd değer daha önce bunun içinde var mı?
    static boolean isFind (int [] arr , int value) {

        for (int i : arr) {
            if (i==value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] list = {4, 10, 4, 4, 2, 9, 10, 21, 2, 33, 9, 1};
        int[] recurring = new int[list.length];
        int startIndex = 0;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (i != j && (list[i] == list[j])) { // i!=j kendine tekrar bakma diyoruz
                    if (!isFind(recurring, list[i])) {
                        recurring[startIndex++] = list[i]; // index e artırarak deger girdiyoruz


                    }
                    break;
                }
            }
            }
                for (int value : recurring){
                    if (value !=0 && value%2==0 ){
                        System.out.println(value);

                    }

                }

        }
    }