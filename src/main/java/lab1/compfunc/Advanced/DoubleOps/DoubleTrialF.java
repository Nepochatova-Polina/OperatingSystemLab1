package lab1.compfunc.Advanced.DoubleOps;

public class DoubleTrialF extends Thread {
    private static double fResult;

    @Override
    public void run() {
        double[] currArray = DoubleOpsUtility.getDoubleArray();
        for (int i = 0; i < 10; i++) {
            if (currArray[i] != 2) {
                synchronized (this) {
                    try {
                        setFResult(countF(currArray[i]));
                        System.out.println("Result of f(x) in " + i + " position: " + fResult);
                        DoubleOpsUtility.decrementCounter();
                        wait();
                        if (DoubleOpsUtility.isStop()) {
                            break;
                        }
                        if (DoubleOpsUtility.isRestart()) {
                            i = -1;
                            currArray = DoubleOpsUtility.getDoubleArray();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Incorrect value for f(x) function");
                break;
            }
        }
        interrupt();
        System.out.println("F thread for double value stopped ");
    }

    public static double countF(double x) {
        return x * x + 1 / (2 - x);
    }

    public static synchronized void setFResult(double value) {
        fResult = value;
    }

    public static double getFResult() {
        return fResult;
    }

}
