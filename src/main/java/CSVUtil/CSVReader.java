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

    /*
     * Load a file into the csv reader to be parsed
     * @param path the path of the file
     */
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
            // as we generate each RowData object we use a shared columns map to reduce memory usage when loading large files
            rows.add(new RowData(columns, new ArrayList<>(Arrays.asList(rowData))));
        }
    }

    /*
     * iterate to the next RowData object and return it
     * @returns RowData an object containing data for each header
     */
    public RowData next(){
        return rows.get(iterator++);
    }

    /*
     * check if the next RowData Object exists
     * @returns RowData an object containing data for each header
     */
    public Boolean hasNext(){
        return iterator < rows.size();
    }
}
