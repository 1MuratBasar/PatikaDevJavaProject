public class Main {
    private static Yazar[] yazarlar;
    public static Yazar[] main(String[] args) {




            static {
                yazarlar = new Yazar[5];
                yazarlar[0] = new Yazar("Reşat Nuri", "Güntekin");
                yazarlar[1] = new Yazar("Necip Fazıl", "Kısakürek");
                yazarlar[2] = new Yazar("Yakup Kadri", "Karaosmanoğlu");
                yazarlar[3] = new Yazar("Halit Ziya", "Uşaklıgil");
                yazarlar[4] = new Yazar("Yahya Kemal", "Beyatlı");
            }
            public static Yazar[] getYazarlar();
            {
                return YazarIslemleri.getYazarlar();
            }
        }
    }

