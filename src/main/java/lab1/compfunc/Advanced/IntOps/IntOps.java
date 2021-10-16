package lab1.compfunc.Advanced.IntOps;

public class IntOps {
    private static int counter = 2;
    public static int[] intArray = {1, 6, 4, 8, 12, 44, 23, 9, 11, 30};
    public static boolean stop = false;

    public static synchronized int getCounter() {return counter;}

    public static synchronized void setCounter(int newCounter) {counter = newCounter;}

    public static synchronized void decrementCounter() {
        if (counter > 0) {
            counter--;
        }
    }
}
