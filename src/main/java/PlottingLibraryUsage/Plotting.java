package PlottingLibraryUsage;

import CSVPlotting.Vector;
import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.ArrayList;

public class Plotting {

    private XYSeriesCollection dataset;
    private ArrayList<Vector> points;

    public Plotting(){
        dataset = new XYSeriesCollection();
        points = new ArrayList<>();
    }

    public void generatePoints(){
        for (int i = 0; i < 100; i++) {
            points.add(new Vector(i, Math.pow(i, 3) - 5 * i));
        }
    }

    public void plotPoints(){
        plotPoints("Series");
    }

    public void plotPoints(String str){
        XYSeries series = new XYSeries(str);
        for (int i = 0; i < 100; i++) {
            series.add(points.get(i).getX(), points.get(i).getY());
        }
        dataset.addSeries(series);
    }

    public void saltData(){
        JDKRandomGenerator rng = new JDKRandomGenerator();
        GaussianRandomGenerator rg = new GaussianRandomGenerator(rng);

        for (int i = 0; i < 100; i++) {
            double y = points.get(i).getY() * (1 + rg.nextNormalizedDouble()/8);
            points.set(i, new Vector(i, y));
        }
    }

    public void smoothData(){
        smoothData(5);
    }

    public void smoothData(int windowSize) {
        DescriptiveStatistics ds = new DescriptiveStatistics();
        ds.setWindowSize(windowSize);

        for (int i = 0; i < points.size(); i++) {
            ds.addValue(points.get(i).getY());
            double smoothedY = ds.getMean();
            points.set(i, new Vector(points.get(i).getX(), smoothedY));
        }
    }

    public void createWindow(){
        createWindow("Graph");
    }

    public void createWindow(String str){
        JFreeChart chart = ChartFactory.createXYLineChart(str, null, null, dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setTitle("Plotting Salting Smoothing Graph");
        frame.setContentPane(chartPanel);
        frame.setLocationRelativeTo(null); // opens in center of screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
