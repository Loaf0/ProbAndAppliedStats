package CSVUtil;

import java.io.FileNotFoundException;

public class CSVUtilTester {
    public static void main(String[] args) throws FileNotFoundException {
        CSVReader reader = new CSVReader();
        reader.readFile("../Exports/TestData.csv");

        while(reader.hasNext()){
            RowData rowdata = reader.next();
            System.out.print(rowdata.getString("name") + " " + rowdata.getInt("age") + " " + rowdata.getDec("power") + "\n");
        }
    }
}
