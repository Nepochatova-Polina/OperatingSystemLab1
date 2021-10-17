package lab1.compfunc.Advanced.IntOps;

import lab1.compfunc.Advanced.DoubleOps.DoubleOps;

public class IntTrialF extends Thread {
    private static int fResult;

    @Override
    public void run() {
        int[] currArray = IntOps.getIntArray();
        for (int i = 0; i < 10; i++) {
            if (currArray[i] != 2) {
                synchronized (this) {
                    try {
                        setFResult(countF(currArray[i]));
                        System.out.println("Result of f(x) in " + i + " position: " + fResult);
                        IntOps.decrementCounter();
                        wait();
                        if (IntOps.isStop()) {
                            break;
                        }
                        if (IntOps.isRestart()) {
                            i = -1;
                            currArray = IntOps.getIntArray();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("\nvalue " + currArray[i] + " is incorrect for f(x) function\n");
                setFResult(100000000);
                IntOps.decrementCounter();
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
        System.out.println("F thread for integer value stopped  " + interrupted());
    }

    public static int countF(int x) {
        return x * x + 1 / (2 - x);
    }

    public static synchronized void setFResult(int value) {
        fResult = value;
    }

    public static int getFResult() {
        return fResult;
    }

}
