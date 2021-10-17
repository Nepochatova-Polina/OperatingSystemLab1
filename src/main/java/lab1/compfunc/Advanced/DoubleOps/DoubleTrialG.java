package lab1.compfunc.Advanced.DoubleOps;

public class DoubleTrialG extends Thread {
    private static double gResult;

    @Override
    public void run() {
        double[] currArray = DoubleOps.getDoubleArray();
        for (int i = 0; i < 10; i++) {
            if (currArray[i] != 2) {
                synchronized (this) {
                    try {
                        setGResult(countG(currArray[i]));
                        System.out.println("Result of g(x) in " + i + " position: " + gResult);
                        DoubleOps.decrementCounter();
                        wait();
                        if (DoubleOps.isStop()) {
                            break;
                        }
                        if (DoubleOps.isRestart()) {
                            i = -1;
                            currArray = DoubleOps.getDoubleArray();
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
        System.out.println("G thread for double value stopped " + interrupted());
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
