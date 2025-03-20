package CSVPlotting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Plot {

    private ArrayList<Vector> points;

    public Plot(){
        points = new ArrayList<>();
    }

    public void savePoints(){
        for(int x = 0; x < 50; x++){
            double y = Math.pow(x, 2) * .5;
            points.add(new Vector((double)x, y));
        }
    }

    public void exportPlot() {
        String path =  "../Exports/" + "plot.csv";
        File f = new File(path);
        f.getParentFile().mkdirs();

        try (PrintWriter pw = new PrintWriter(f)){
            StringBuilder output = new StringBuilder();
            output.append("X Value, Y Value\n");
            for (Vector v : points) {
                output.append(v.getX()).append(", ");
                output.append(v.getY()).append(", \n");
            }
            pw.write(output.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
