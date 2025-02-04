package DealOrNoDealSim;

public class DealOrNoDeal {

    private Door[] doors;

    public DealOrNoDeal(){
        doors = new Door[3];
        generateCorrectDoor();
    }

    public void generateCorrectDoor(){
        for(int i = 0; i < doors.length; i++){
            doors[i] = new Door();
        }

        int random = (int) (Math.random() * 3);

        doors[random].setCorrect(true);
    }

    public boolean pickRandomDoor(boolean swap){
        int random = (int) (Math.random() * 3);

        if(swap){
            if (!doors[(random + 1) % 3 ].getCorrect()){
                random = (random + 2) % 3 ;
            }
            else if (!doors[(random + 2) % 3 ].getCorrect()) {
                random = (random + 1) % 3 ;
            }
        }
        return doors[random].getCorrect();
    }

}
