package CSVPlotting;

import java.io.FileNotFoundException;

public class RunPlotting {
    public static void main(String[] args) throws FileNotFoundException {
        Plot p = new Plot();
        p.savePoints();
        p.exportPlot("../Exports/plot.csv");
    }
}
