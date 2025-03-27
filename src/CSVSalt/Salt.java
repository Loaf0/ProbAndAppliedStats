package CSVSalt;

import CSVUtil.CSVReader;
import CSVUtil.FileWriter;
import CSVUtil.RowData;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
//            valueY = valueY * (Math.random() * (max - min) + min);
            valueY = valueY + (Math.random() * (max - min) + min);
            sb.append(valueX).append(", ").append(valueY).append("\n");
        }
    }

    public void exportSaltedData(String path) throws FileNotFoundException {
        FileWriter fw = new FileWriter();
        fw.write(path, sb.toString());
    }
}