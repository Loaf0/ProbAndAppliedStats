package PlottingLibraryUsage;

public class PlottingLibraryUsageTester {
    public static void main(String[] args){

        Plotting graph = new Plotting();
        graph.generatePoints();
        graph.plotPoints("Base");

        graph.saltData();
        graph.plotPoints("Salted");

        graph.smoothData(6);
        graph.smoothData(10);
        graph.smoothData(8);
        graph.plotPoints("Smoothed");

        graph.createWindow("Graph");
    }
}
