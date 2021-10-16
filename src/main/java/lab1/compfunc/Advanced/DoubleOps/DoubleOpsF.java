package lab1.compfunc.Advanced.DoubleOps;

public class DoubleOpsF extends Thread {
    private static double fResult;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (DoubleOps.doubleArray[i] != 2) {
                synchronized (this) {
                    try {
                        setFResult(countF(DoubleOps.doubleArray[i]));
                        System.out.println("Result of f(x) in " + i + " position: " + fResult);
                        DoubleOps.decrementCounter();
                        wait();
                        if(DoubleOps.stop){
                            break;
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
        System.out.println("F thread for double value stopped " + interrupted());
    }

    public static double countF(double x) {
        return x * x + 1 / (2 - x);
    }

    public static synchronized void setFResult(double value) {
        fResult = value;
    }
    public static double getFResult() {return fResult;}

}
