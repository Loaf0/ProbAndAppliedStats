package CSVPlotting;

import CSVUtil.FileWriter;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Plot {

    private ArrayList<Vector> points;

    public Plot(){
        points = new ArrayList<>();
    }

    /*
     * add points to the arraylist Points
     */
    public void savePoints(){
        for(int x = 0; x < 100; x++){
            double y = Math.pow(x, 2) * .5;
            points.add(new Vector((double)x, y));
        }
    }

    /*
     * Export the points to a csv
     * @param path the location of the csv
     */
    public void exportPlot(String path) throws FileNotFoundException {
        StringBuilder output = new StringBuilder();
        output.append("X Value, Y Value\n");
        for (Vector v : points) {
            output.append(v.getX()).append(", ");
            output.append(v.getY()).append(", \n");
        }

        new FileWriter().write(path, output.toString());
    }
}
