package DealOrNoDealSim;

public class Door {

    private boolean correct;

    public Door(boolean bool){
        correct = bool;
    }

    public Door(){
        correct = false;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean getCorrect(){
        return correct;
    }
}
