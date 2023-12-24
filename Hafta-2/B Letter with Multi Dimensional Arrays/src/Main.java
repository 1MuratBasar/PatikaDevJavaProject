
        public class Main {
    // Letter B with Multi Dimensional Array
            // i nin 0,3,6 ya düştügü satırlar x ekseni dogrultusunda yıldız basacak
            // y ise dikey dış çizgiler 0 ve 3 (y eksenin)
            //geri kalan alanlar boşluk

            public static void main(String[] args) {
                String[][] letter = new String[7][4];

                for (int i = 0; i < letter.length; i++) {
                    for (int j = 0; j < letter[i].length; j++) {
                        if (i == 0 || i == 3 || i==6) {
                            letter[i][j] = " * ";
                        } else if (j == 0 || j == 3) {
                            letter[i][j] = " * ";
                        } else {
                            letter[i][j] = "   ";
                        }
                    }
                }

                for (String[] row : letter){
                    for (String col : row){
                        System.out.print(col);
                    }
                    System.out.println();
                }
            }
        }

