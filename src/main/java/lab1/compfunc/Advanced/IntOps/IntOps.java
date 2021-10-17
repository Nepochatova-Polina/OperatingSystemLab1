package lab1.compfunc.Advanced.IntOps;

import lab1.compfunc.Advanced.DoubleOps.DoubleOps;

public class IntOps {
    private static int counter = 2;
    private static int[] intArray = {1, 5, 2, 8, 12, 44, 23, 9, 11, 30};
    private static boolean restart = false;

    public static int[] getIntArray() {
        return intArray;
    }

    public static void setIntArray(int[] newArray) {
        IntOps.intArray = newArray;
    }

    public static synchronized boolean isRestart() {
        return restart;
    }

    public static synchronized void setRestart(boolean restart) {
        IntOps.restart = restart;
    }


    public static boolean isStop() {
        return stop;
    }

    public static void setStop(boolean stop) {
        IntOps.stop = stop;
    }

    private static boolean stop = false;

    public static synchronized int getCounter() {
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
