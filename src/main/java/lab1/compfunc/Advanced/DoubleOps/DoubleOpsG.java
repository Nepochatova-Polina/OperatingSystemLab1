package lab1.compfunc.Advanced.DoubleOps;

public class DoubleOpsG extends Thread {
    private static double gResult;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (DoubleOps.doubleArray[i] != 2) {
                synchronized (this) {
                    try {
                        setGResult(countG(DoubleOps.doubleArray[i]));
                        System.out.println("Result of g(x) in " + i + " position: " + gResult);
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
                System.out.println("Incorrect value for g(x) function");
                break;
            }
        }
        interrupt();
        System.out.println("G thread for double value stopped " + interrupted());
    }

    public static double countG(double x) {return x * x * x + 8;}
    public static synchronized void setGResult(double value) {gResult = value;}
    public static double getGResult() {return gResult;}
}
