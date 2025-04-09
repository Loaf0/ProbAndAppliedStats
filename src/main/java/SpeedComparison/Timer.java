package SpeedComparison;

/*
 * @description Class made to emulate a stopwatch
 * @author Tyler Snyder
 */

public class Timer {

    private long time;
    private long startTime;
    private long stopTime;

    public void start(){
        startTime = System.currentTimeMillis();
    }

    public void stop(){
        stopTime = System.currentTimeMillis();
        time +=  stopTime - startTime;
    }

    public void reset(){
        time = 0;
        startTime = 0;
        stopTime = 0;
    }

    public long getTime() {
        return time;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getStopTime() {
        return stopTime;
    }
}
