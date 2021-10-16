package lab1.compfunc.Advanced.IntOps;

public class IntOpsF extends Thread {
    private static int fResult;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (IntOps.intArray[i] != 2) {
                synchronized (this) {
                    try {
                        setFResult(countF(IntOps.intArray[i]));
                        System.out.println("Result of f(x) in " + i + " position: " + fResult);
                        IntOps.decrementCounter();
                        wait();
                        if(IntOps.stop){
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
