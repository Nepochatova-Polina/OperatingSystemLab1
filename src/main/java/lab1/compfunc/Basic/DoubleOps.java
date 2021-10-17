package lab1.compfunc.Basic;

public class DoubleOps {
    private static double fResult, gResult;

    public static void createThreads(double number) {
        Thread DtrialF = new Thread(() -> {
            try {
                Thread.sleep(3000);
                DoubleOps.setFResult(DoubleOps.countF(number));
                System.out.println("Result of f(x) for double value: " + DoubleOps.fResult);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread DtrialG = new Thread(() -> {
            try {
                Thread.sleep(3000);
                DoubleOps.setGResult(DoubleOps.countG(number));
                System.out.println("Result of g(x) for double value: " + DoubleOps.gResult);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        DtrialF.start();
        DtrialG.start();
    }

    public static double countF(double x) {
        return x * x + 1 / (2 - x);
    }

    public static double countG(double x) {
        return x * x * x + 8;
    }

    public static synchronized void setFResult(double value) {
        DoubleOps.fResult = value;
    }

    public static synchronized void setGResult(double value) {
        DoubleOps.gResult = value;
    }

    public static double getgResult() {
        return gResult;
    }

    public static double getfResult() {
        return fResult;
    }


}
