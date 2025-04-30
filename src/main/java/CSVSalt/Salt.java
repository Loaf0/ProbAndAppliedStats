package CSVSalt;

import CSVUtil.CSVReader;
import CSVUtil.FileWriter;
import CSVUtil.RowData;
import java.io.FileNotFoundException;

/*
 *  @description reads the output of the CSV Plotting package and salts the data
 *  @author Tyler Snyder
 */

public class Salt{

    private StringBuilder sb;

    public Salt(){
        sb = new StringBuilder();
        sb.append("X Value, Y Value\n");
    }

    public void saltDataFromCSV(String path, double randomRange) throws FileNotFoundException {
        CSVReader csv = new CSVReader();
        csv.readFile(path);
        while(csv.hasNext()){
            RowData rowdata = csv.next();
            double valueX = rowdata.getDec("X Value");
            double valueY = rowdata.getDec("Y Value");

            // salt values
            double max = randomRange / 2;
            double min = -randomRange / 2;
            valueY = valueY + (Math.random() * (max - min) + min);
            sb.append(valueX).append(", ").append(valueY).append("\n");
        }
    }

    public void exportSaltedData(String path) throws FileNotFoundException {
        new FileWriter().write(path, sb.toString());
    }
}