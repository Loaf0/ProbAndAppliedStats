package CSVUtil;

import java.util.ArrayList;
import java.util.Map;

/*
 *  @description Custom data holder that allows the reading of lines from a CSV
 *  @author Tyler Snyder
 */

public class RowData {

    Map<String, Integer> columns;
    ArrayList<String> data;

    public RowData(Map<String, Integer> inputColumns, ArrayList<String> inputData){
        columns = inputColumns;
        data = inputData;
    }

    public String getCleanString(String columnName){
        return getString(columnName).trim();
    }

    public String getString(String columnName){
        columnName = columnName.trim();
        if(columns.containsKey(columnName))
            return data.get(columns.get(columnName));
        return "";
    }

    public int getInt(String columnName){
        columnName = columnName.trim();
        if(columns.containsKey(columnName))
            return Integer.parseInt(data.get(columns.get(columnName)).trim());
        return 0;
    }

    public Double getDec(String columnName){
        columnName = columnName.trim();
        if(columns.containsKey(columnName))
            return Double.valueOf(data.get(columns.get(columnName)).trim());
        return 0.0;
    }


}
