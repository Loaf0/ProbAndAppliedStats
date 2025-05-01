package SkillsImprovement;

public class Singleton {

    private boolean isOn;
    private static Singleton instance;

    private Singleton(){

    }

    public static Singleton getFactory(){
        if(instance == null)
            instance = new Singleton();
        return instance;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
