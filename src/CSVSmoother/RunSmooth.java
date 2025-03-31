package CSVSmoother;

import java.io.FileNotFoundException;

public class RunSmooth {
    public static void main(String[] args) throws FileNotFoundException {
        Smooth smoother = new Smooth();
        smoother.readFile("../Exports/saltedData.csv");
        smoother.smoothData(10);
        smoother.smoothData(20);
        smoother.exportData("../Exports/saltedSmoothedData.csv");
    }
}
