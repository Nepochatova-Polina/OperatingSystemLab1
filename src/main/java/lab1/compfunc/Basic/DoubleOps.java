package lab1.compfunc.Basic;

public class DoubleOps {
    public static double fResult, gResult;

    public static void createThreads(double number){
        Thread DtrialF = new Thread(() -> {
            DoubleOps.setFResult(DoubleOps.countF(number));
            System.out.println("Result of f(x) for double value: " + DoubleOps.fResult);
        });
        Thread DtrialG = new Thread(() -> {
            DoubleOps.setGResult(DoubleOps.countG(number));
            System.out.println("Result of g(x) for double value: " +DoubleOps.gResult);
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

    public static synchronized void setFResult(double value) {fResult = value;}

    public static synchronized void setGResult(double value) {gResult = value;}

}
