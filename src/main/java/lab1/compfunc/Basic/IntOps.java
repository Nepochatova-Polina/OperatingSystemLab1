package lab1.compfunc.Basic;

public class IntOps {
    public static int fResult, gResult;

    public static void createTreads(int number){
        Thread ItrialF = new Thread(() -> {
            IntOps.setFResult(IntOps.countF(number));
            System.out.println("Result of f(x) for integer value: " + IntOps.fResult);
        });
        Thread ItrialG = new Thread(() -> {
            IntOps.setGResult(IntOps.countG(number));
            System.out.println("Result of g(x) for integer value: " + IntOps.gResult);
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

    public static synchronized void setFResult(int value) {fResult = value;}

    public static synchronized void setGResult(int value) {gResult = value;}

}
