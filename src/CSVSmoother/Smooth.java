package CSVSmoother;

import CSVPlotting.Vector;
import CSVUtil.CSVReader;
import CSVUtil.FileWriter;
import CSVUtil.RowData;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
 *  @description reads the output of the CSV Salting package and smooths the data to become more readable
 *  @author Tyler Snyder
 */

public class Smooth {

    private ArrayList<Vector> points;
    private StringBuilder sb;

    public Smooth(){
        points = new ArrayList<>();
        sb = new StringBuilder();
        sb.append("X Value, Y Value\n");
    }

    public void readFile(String path) throws FileNotFoundException {
        CSVReader csv = new CSVReader();
        csv.readFile(path);
        while(csv.hasNext()){
            RowData rowData = csv.next();

            double valueX = rowData.getDec("X Value");
            double valueY = rowData.getDec("Y Value");

            points.add(new Vector(valueX, valueY));
        }
    }

    public void smoothData(int windowSize){
        // for each point
        for (int i = 0; i < points.size(); i++) {
            double sum = 0;
            double values = 1;
            sum += points.get(i).getY();

            for (int j = 0; j < windowSize; j++) {
                // add all values in window range and in range of arraylist
                if(j - i >= 0){
                    sum += points.get(j - i).getY();
                    values++;
                }
                if(j + i < points.size()){
                    sum += points.get(j + i).getY();
                    values++;
                }
            }
            Vector avgVector = new Vector((double) i, sum/values);
            points.set(i, avgVector);
        }
    }

    public void exportData(String path) throws FileNotFoundException {
        for (Vector point : points) {
            sb.append(point.getX()).append(", ").append(point.getY()).append("\n");
        }
        FileWriter fw = new FileWriter();
        fw.write(path, sb.toString());
    }

}