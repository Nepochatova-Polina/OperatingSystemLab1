package lab1.compfunc.Advanced.DoubleOps;

public class DoubleOps {
    private static double[] doubleArray = {1.6, 6.0, 4.3, 8.23, 12.22, 44.15, 23.7, 9.88, 11.44, 30.1};
    private static int counter = 2;

    public static synchronized boolean isRestart() {
        return restart;
    }

    public static synchronized void setRestart(boolean restart) {
        DoubleOps.restart = restart;
    }

    private static boolean restart = false;

    public static double[] getDoubleArray() {
        return doubleArray;
    }

    public static void setDoubleArray(double[] newArray) {
//        for (int i = 0; i < newArray.length; i++) {

//        }
        DoubleOps.doubleArray = newArray;
    }

    public static boolean isStop() {
        return stop;
    }

    public static void setStop(boolean stop) {
        DoubleOps.stop = stop;
    }

    private static boolean stop = false;

    public static synchronized double getCounter() {
        return counter;
    }

    public static synchronized void setCounter(int newCounter) {
        counter = newCounter;
    }

    public static synchronized void decrementCounter() {
        if (counter > 0) {
            counter--;
        }
    }
}
