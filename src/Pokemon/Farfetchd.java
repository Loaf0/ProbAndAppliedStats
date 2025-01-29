package Pokemon;

public class Farfetchd extends Pokemon {

    public Farfetchd(String name, int hp, int attack, int defense, int spAttack, int spDefense, int speed) {
        setName(name);
        setHp(hp);
        setAttack(attack);
        setDefense(defense);
        setSpAttack(spAttack);
        setSpDefense(spDefense);
        setSpeed(speed);
    }

    public Farfetchd() {
        setName("Farfetch'd");
        setHp(52);
        setAttack(95);
        setDefense(55);
        setSpAttack(58);
        setSpDefense(62);
        setSpeed(55);
    }

}
