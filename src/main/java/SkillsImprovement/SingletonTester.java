package SkillsImprovement;

public class SingletonTester {

    public static void main(String[] args){
        Singleton cf = Singleton.getFactory();

        System.out.println(cf.isOn());
    }

}
