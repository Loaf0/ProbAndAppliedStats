package CSVSalt;

import java.io.FileNotFoundException;

public class RunSalting {
    public static void main(String[] args) throws FileNotFoundException {
        Salt sal = new Salt();
        sal.saltDataFromCSV("../Exports/plot.csv", 1000);
        sal.exportSaltedData("../Exports/saltedData.csv");
    }
}
