package lab1.compfunc.Advanced.DoubleOps;

public class DoubleTrialG extends Thread {
    private static double gResult;

    @Override
    public void run() {
        double[] currArray = DoubleOpsUtility.getDoubleArray();
        for (int i = 0; i < 10; i++) {
            if (currArray[i] != 2) {
                synchronized (this) {
                    try {
                        setGResult(countG(currArray[i]));
                        System.out.println("Result of g(x) in " + i + " position: " + gResult);
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
                System.out.println("Incorrect value for g(x) function");
                break;
            }
        }
        interrupt();
        System.out.println("G thread for double value stopped ");
    }

    public static double countG(double x) {
        return x * x * x + 8;
    }

    public static synchronized void setGResult(double value) {
        gResult = value;
    }

    public static double getGResult() {
        return gResult;
    }
}
