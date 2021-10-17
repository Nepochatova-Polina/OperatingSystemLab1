package lab1.compfunc.Advanced.BinaryFunc;

import lab1.compfunc.Advanced.IntOps.IntOpsUtility;
import lab1.compfunc.Advanced.IntOps.IntTrialF;
import lab1.compfunc.Advanced.IntOps.IntTrialG;
import lab1.compfunc.Advanced.Main;
import lab1.compfunc.Advanced.Message.MessagesUtility;

public class IntBinaryMin extends Thread {
    @Override
    public void run() {
        while (!Main.intFThread.isInterrupted() && !Main.intGThread.isInterrupted()) {
            if (IntOpsUtility.getCounter() == 0) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (MessagesUtility.isMessageFlag()) {
                    int IntOfBinOperation = IntBinMin(IntTrialF.getFResult(), IntTrialG.getGResult());
                    System.out.println("Minimum of two integer results is: " + IntOfBinOperation);
                    IntOpsUtility.setCounter(2);
                    synchronized (Main.intFThread) {
                        Main.intFThread.notify();
                    }
                    synchronized (Main.intGThread) {
                        Main.intGThread.notify();
                    }
                } else {
                    synchronized (this) {
                        try {
                            wait();
                            if (MessagesUtility.isStopComputation()) {
                                synchronized (Main.intFThread) {
                                    Main.intFThread.notify();
                                }
                                synchronized (Main.intGThread) {
                                    Main.intGThread.notify();
                                }
                            } else {
                                IntOpsUtility.setStop(true);
                                synchronized (Main.intFThread) {
                                    Main.intFThread.notify();
                                }
                                synchronized (Main.intGThread) {
                                    Main.intGThread.notify();
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
        System.out.println("binary operation thread between integer values stopped");
    }

    public static int IntBinMin(int fRes, int gRes) {
        return Math.min(fRes, gRes);
    }
}
