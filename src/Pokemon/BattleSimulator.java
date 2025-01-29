package Pokemon;

public class BattleSimulator {

    public void battle(Pokemon p1, Pokemon p2){
        if (p1.getSpeed() < p2.getSpeed()){
            Pokemon p3 = p1;
            p1 = p2;
            p2 = p3;
        }

        while(p1.getHp() > 0 || p2.getHp() > 0){
            p2.setHp(p2.getHp() - p1.getAttack());

            if(p2.getHp() > 0)
                p1.setHp(p1.getHp() - p2.getAttack());
        }

        if (p1.getHp() > 0)
            System.out.println(p1.getName() + " Wins!" );
        else
            System.out.println(p2.getName() + " Wins!" );

    }

}
