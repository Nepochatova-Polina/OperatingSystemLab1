package lab1.compfunc.Advanced.IntOps;


public class IntOpsUtility {
    private static int counter = 2;
    private static int[] intArray = {1, 5, 3, 8, 12, 44, 23, 9, 11, 30};
    private static boolean restart = false;

    public static int[] getIntArray() {
        return intArray;
    }

    public static void setIntArray(int[] newArray) {
        IntOpsUtility.intArray = newArray;
    }

    public static synchronized boolean isRestart() {
        return restart;
    }

    public static synchronized void setRestart(boolean restart) {
        IntOpsUtility.restart = restart;
    }


    public static boolean isStop() {
        return stop;
    }

    public static void setStop(boolean stop) {
        IntOpsUtility.stop = stop;
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
