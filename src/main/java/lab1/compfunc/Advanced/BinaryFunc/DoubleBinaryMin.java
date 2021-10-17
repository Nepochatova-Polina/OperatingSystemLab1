package lab1.compfunc.Advanced.BinaryFunc;

import lab1.compfunc.Advanced.DoubleOps.DoubleOpsUtility;
import lab1.compfunc.Advanced.DoubleOps.DoubleTrialF;
import lab1.compfunc.Advanced.DoubleOps.DoubleTrialG;
import lab1.compfunc.Advanced.Main;
import lab1.compfunc.Advanced.Message.MessagesUtility;

public class DoubleBinaryMin extends Thread {
    @Override
    public void run() {
        while (!Main.doubleFThread.isInterrupted() && !Main.doubleGThread.isInterrupted()) {
            if (DoubleOpsUtility.getCounter() == 0) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (MessagesUtility.isMessageFlag()) {
                    double DoubleOfBinOperation = DoubleBinMin(DoubleTrialF.getFResult(), DoubleTrialG.getGResult());
                    System.out.println("Minimum of two double results is: " + DoubleOfBinOperation);
                    DoubleOpsUtility.setCounter(2);
                    synchronized (Main.doubleFThread) {
                        Main.doubleFThread.notify();
                    }
                    synchronized (Main.doubleGThread) {
                        Main.doubleGThread.notify();
                    }
                } else {
                    synchronized (this) {
                        try {
                            wait();
                            if (MessagesUtility.isStopComputation()) {
                                synchronized (Main.doubleFThread) {
                                    Main.doubleFThread.notify();
                                }
                                synchronized (Main.doubleGThread) {
                                    Main.doubleGThread.notify();
                                }
                            } else {
                                DoubleOpsUtility.setStop(true);
                                synchronized (Main.doubleFThread) {
                                    Main.doubleFThread.notify();
                                }
                                synchronized (Main.doubleGThread) {
                                    Main.doubleGThread.notify();
                                }
                                break;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
        interrupt();
        System.out.println("binary operation thread between double values stopped ");

    }

    public static double DoubleBinMin(double fRes, double gRes) {
        return Math.min(fRes, gRes);
    }
}
