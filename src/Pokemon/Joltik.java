package Pokemon;

public class Joltik extends Pokemon {

    public Joltik(String name, int hp, int attack, int defense, int spAttack, int spDefense, int speed) {
        setName(name);
        setHp(hp);
        setAttack(attack);
        setDefense(defense);
        setSpAttack(spAttack);
        setSpDefense(spDefense);
        setSpeed(speed);
    }

    public Joltik() {
        setName("Joltik");
        setHp(50);
        setAttack(47);
        setDefense(50);
        setSpAttack(57);
        setSpDefense(50);
        setSpeed(65);
    }

}
