package Pokemon;

public class PokemonTester {

    public static void main(String[] args){
        BattleSimulator bs = new BattleSimulator();

        Joltik bug = new Joltik();
        Farfetchd leek = new Farfetchd();

        bs.battle(bug, leek);
    }

}
