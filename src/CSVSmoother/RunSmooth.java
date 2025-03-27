package CSVSmoother;

import java.io.FileNotFoundException;

public class RunSmooth {
    public static void main(String[] args) throws FileNotFoundException {
        Smooth smoother = new Smooth();
        smoother.readFile("../Exports/saltedData.csv");
        smoother.smoothData(8);
        smoother.smoothData(4);
        smoother.smoothData(2);
        smoother.exportData("../Exports/saltedSmoothedData.csv");
    }
}
