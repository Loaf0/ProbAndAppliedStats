package CSVPlotting;

public class Vector implements Comparable<Vector> {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /*
     * Compares Vectors
     * @param o The Vector to be compared to
     * @return 0 if x & y are equal, -1 if only x is equal, -2 if only y is equal, 1 if nothing is equal
     */
    @Override
    public int compareTo(Vector o) {
        double accuracy = 0.000001;
        if (o.getX() - x < accuracy && o.getY() - y < accuracy)
            return 0;
        else if(o.getY() - y >= accuracy)
            return -1;
        else if(o.getX() - x >= accuracy)
            return -2;
        return 1;
    }
}
