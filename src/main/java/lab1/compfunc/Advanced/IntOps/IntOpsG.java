package lab1.compfunc.Advanced.IntOps;

public class IntOpsG extends Thread {
    private static int gResult;

    @Override
    public void run() {
            for (int i = 0; i < 10; i++) {
                if (IntOps.intArray[i] != 2) {
                    synchronized (this) {
                        try {
                            setGResult(countG(IntOps.intArray[i]));
                            System.out.println("Result of g(x) in " + i + " position: " + gResult);
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
                    System.out.println("Incorrect value for g(x) function");
                    break;
                }
            }
        interrupt();
        System.out.println("G thread for integer value stopped  " + interrupted());
    }

    public static int countG(int x) {return x * x * x + 8;}
    public static synchronized void setGResult(int value) {gResult = value;    }
    public static int getGResult() {return gResult;}
}
