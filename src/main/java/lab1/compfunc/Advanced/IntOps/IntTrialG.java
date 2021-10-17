package lab1.compfunc.Advanced.IntOps;

public class IntTrialG extends Thread {
    private static int gResult;

    @Override
    public void run() {
        int[] currArray = IntOpsUtility.getIntArray();
        for (int i = 0; i < 10; i++) {
            if (currArray[i] != 5) {
                synchronized (this) {
                    try {
                        setGResult(countG(currArray[i]));
                        System.out.println("Result of g(x) in " + i + " position: " + gResult);
                        IntOpsUtility.decrementCounter();
                        wait();
                        if (IntOpsUtility.isStop()) {
                            break;
                        }
                        if (IntOpsUtility.isRestart()) {
                            i = -1;
                            currArray = IntOpsUtility.getIntArray();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("\nvalue " + currArray[i] + " is incorrect for g(x) function\n");
                setGResult(100000000);
                IntOpsUtility.decrementCounter();
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        interrupt();
        System.out.println("G thread for integer value stopped");
    }

    public static int countG(int x) {
        return (x * x * x + 8) / (x - 5);
    }

    public static synchronized void setGResult(int value) {
        gResult = value;
    }

    public static int getGResult() {
        return gResult;
    }
}
