public class Fighter {

    String name;
    int damage;
    int health;
    int weight;
    int dodge;
  int whoStarts;

    Fighter ( String name, int damage, int health, int weight, int  dodge, int whoStarts){

        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        if (dodge >=0 && dodge<= 100) {
            this.dodge = dodge;
        } else {
            this.dodge = 0;
        }

        if (whoStarts >= 0 && whoStarts <= 100) {

            this.whoStarts = whoStarts;
        } else {
            this.whoStarts =0;
        }
    }




    int hit (Fighter foe) {
     if (foe.isChange()) {

                        return foe.whoStarts;
        }
        System.out.println(this.name + "====>" + foe.name + " " + this.damage + " hasar vurdu");

        if (foe.isDodge()) {
            System.out.println(foe.name + " gelen hasarı blokladı");
            System.out.println("--------------");
            return foe.health;
        }

        if (foe.health - this.damage < 0) {

            return 0;
    }
        return foe.health - this.damage;
    }

    boolean isDodge (){

double randomNumber = Math.random()*100;
    return randomNumber <= this.dodge;
    }

    boolean isChange (){

        double randomNumber = Math.random()*100;
        return randomNumber <= this.whoStarts;
    }

}
