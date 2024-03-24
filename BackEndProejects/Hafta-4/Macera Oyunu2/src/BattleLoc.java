import java.util.Random;

// locationun alt sınıfı oluyor
public abstract class BattleLoc extends Location{
    // abstract oldugu içni deneme yapamam alt sınıflar gerekli (forest magara etc)
 private Obstacle obstacle;
 private String award;
 private int maxObstacle;


 // battleloca ları location dan alıcam

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
         // içerdeki obstacle mı dışarıdan aldıgıma eşitlicem
        // içerdeki ödülümü dışardaın aldıgıma eşitlicem
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }


    //onlocation a buraya dahil etmek zorundayım
// butun battle loc lar için bütün loc la aynı oalcak
    //çünkü ata sınıfta karakteristik özellik aynı (tool store ve safehouse farklı nitelikler vardı)
    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şu an buradasınız" + this.getName());
        System.out.println("Dikkatli ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor");
        System.out.println("<S>avaş veya <K>aç");
        String selectCase = input.nextLine().toUpperCase();
               if (selectCase.equals("S") && (combat(obsNumber))   ){ // canım olmasına mı ragmen kaçtım if blogu
                     System.out.println(this.getName() + "tüm düşmanları yendiniz");
                   // savaşma işlemi true ise geri true donduruyorum
                       return true;

              }

               //kaçtıysa savaştan
        if (this.getPlayer().getHealth() <= 0) { // öldüm de mi cıktım if blogu
            System.out.println("Öldünüz");
            return false;
        } // sıfırdan kucuk degilse location dan canlı cıkmısımdır
        return true;

    }
            //ben bi tane combat metotu yazıyrm geriye boolean döndercek. canavarla savascagımız yapı
            // kactane canavar varsa değişken girilecek (obsNumber)
            // kaç canavarla savaşcaksam o kadar dongu olacak
        public boolean combat (int obsNumber){
            //ilk zombi ölünce oyunun sonlanmaması için orjinal bi health tutuyorum. çünkü tek bi obje uzerinden çalışıyorum
            //ilk döngü ilk canavar için 2. dongu başladıgında yeni canavar oalcak o nedenle canı tazeliyorum
             for (int i=1; i<=obsNumber; i++){
                 this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            //plaer ın ve canavar istatistiklerini bastıralım
           playerStats();
           obstacleStats(i);
           //degerler geldikten sonra kıran kırana mucadele için while lazım.

            while ((this.getPlayer().getHealth() > 0) && (this.getObstacle().getHealth() > 0)){

                System.out.print("<V>ur veya <K>aç");
                String selectCombat = input.nextLine().toUpperCase();
            if (selectCombat.equals("V")) {
                System.out.println("Siz vurdunuz");
                this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getToltalDamage());
                afterHit();

                if (this.getObstacle().getHealth() > 0 ) {
                    System.out.println();
                    System.out.println("Canavar size vurdu !");
                    int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                  if (obstacleDamage < 0){
                      obstacleDamage = 0;
                  }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                  afterHit();
               }
            } else {
                return false;
            }
           }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz, tebrikler");
                System.out.println(this.getObstacle().getAward() +  " para kazandınız.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel paranız : " + getPlayer().getMoney());
            } else {
                return false;
            }
          }
             //programa başlrken varsayılan olarak kazanmayı dusundugum için true ile başladım
            return true;
    }

             public void afterHit() {

        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println("-------------------------------------- ");


     }

    public void obstacleStats (int i){

        System.out.println(i + "." + this.getObstacle().getName() + " değerleri : ");
        System.out.println("------------------------------------------------------");

        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar  : " + this.getObstacle().getDamage());
        System.out.println("Ödül   : " + this.getObstacle().getAward()   );


    }


    public void playerStats(){
        System.out.println("---------------------");
        System.out.println(" Oyuncu Değerleri : ");
        System.out.println(" Sağlık     : " + this.getPlayer().getHealth());
        System.out.println(" Silah      : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println(" Hasar      : " + this.getPlayer().getToltalDamage());
        System.out.println(" Zırh       : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println(" Bloklama   : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println(" Para       : " + this.getPlayer().getMoney());
        System.out.println("---------------------");


    }


    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle() ) + 1;
    }




    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }


    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
