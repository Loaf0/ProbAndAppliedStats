package CSVUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
 *  @description CSVReader class the allows the reading of data based on the column header for easier csv management
 *  @author Tyler Snyder
 */

public class CSVReader {

    Map<String, Integer> columns;
    ArrayList<RowData> rows;
    int iterator = 0;

    public CSVReader(){
        columns = new HashMap<>();
        rows = new ArrayList<>();
    }

    public void readFile(String path) throws FileNotFoundException {
        columns = new HashMap<>();
        rows = new ArrayList<>();

        if (!path.contains(".csv")){
            System.out.println("File is not of expected type");
            return;
        }

        File csv = new File(path);
        Scanner reader = new Scanner(csv);

        // get table headers
        String[] headers = reader.nextLine().split(",");
        for(int i = 0; i < headers.length; i++){
            columns.put(headers[i].trim(), i);
        }

        // read each line into 2d array
        while (reader.hasNextLine()){
            String[] rowData = reader.nextLine().split(",");
            rows.add(new RowData(columns, new ArrayList<>(Arrays.asList(rowData))));
        }
    }

    public RowData next(){
        return rows.get(iterator++);
    }

    public Boolean hasNext(){
        return iterator < rows.size();
    }
}
