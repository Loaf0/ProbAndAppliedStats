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

    /*
     * gets a String that has double, trailing and starting spaces removed from a column in a csv file
     * @param columnName the name of the csv column to get from
     * @returns String the String found under the column given as parameter altering for formatting
     */
    public String getCleanString(String columnName){
        return getString(columnName).trim().replaceAll(" {2}", " ");
    }

    /*
     * gets a String from a column in a csv file
     * @param columnName the name of the csv column to get from
     * @returns String the String found under the column given as parameter
     */
    public String getString(String columnName){
        columnName = columnName.trim();
        if(columns.containsKey(columnName))
            return data.get(columns.get(columnName));
        return "";
    }

    /*
     * gets a int from a column in a csv file
     * @param columnName the name of the csv column to get from
     * @returns int the int found under the column given as parameter
     */
    public int getInt(String columnName){
        columnName = columnName.trim();
        if(columns.containsKey(columnName))
            return Integer.parseInt(data.get(columns.get(columnName)).trim());
        return 0;
    }

    /*
     * gets a double value from a column in a csv file
     * @param columnName the name of the csv column to get from
     * @returns double the double found under the column given as parameter
     */
    public double getDec(String columnName){
        columnName = columnName.trim();
        if(columns.containsKey(columnName))
            return Double.parseDouble(data.get(columns.get(columnName)).trim());
        return 0.0;
    }
}
