package lab1.compfunc.Basic;

public class IntOps {
    private static int fResult, gResult;
    public static Thread ItrialF;
    public static Thread ItrialG;

    public static void createTreads(int number) {
        ItrialF = new Thread(() -> {
            try {
                Thread.sleep(3000);
                IntOps.setFResult(IntOps.countF(number));
                System.out.println("Result of f(x) for integer value: " + IntOps.fResult);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        ItrialG = new Thread(() -> {
            try {
                Thread.sleep(3000);
                IntOps.setGResult(IntOps.countG(number));
                System.out.println("Result of g(x) for integer value: " + IntOps.gResult);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        ItrialF.start();
        ItrialG.start();
    }

    public static int countF(int x) {
        return x * x + 1 / (2 - x);
    }

    public static int countG(int x) {
        return x * x * x + 8;
    }

    public static synchronized void setFResult(int value) {
        IntOps.fResult = value;
    }

    public static synchronized void setGResult(int value) {
        IntOps.gResult = value;
    }

    public static int getgResult() {
        return gResult;
    }

    public static int getfResult() {
        return fResult;
    }

}
