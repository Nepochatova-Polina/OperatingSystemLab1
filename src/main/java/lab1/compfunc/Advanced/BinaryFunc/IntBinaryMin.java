package lab1.compfunc.Advanced.BinaryFunc;

import lab1.compfunc.Advanced.IntOps.IntOps;
import lab1.compfunc.Advanced.IntOps.IntTrialF;
import lab1.compfunc.Advanced.IntOps.IntTrialG;
import lab1.compfunc.Advanced.Main;
import lab1.compfunc.Advanced.Message.MessagesClass;

public class IntBinaryMin extends Thread {
    @Override
    public void run() {
        while (!Main.intFThread.isInterrupted() && !Main.intGThread.isInterrupted()) {
            if (IntOps.getCounter() == 0) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!MessagesClass.isMessageFlag()) {
                    int IntOfBinOperation = IntBinMin(IntTrialF.getFResult(), IntTrialG.getGResult());
                    System.out.println("Minimum of two integer results is: " + IntOfBinOperation);
                    IntOps.setCounter(2);
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
                            if (!MessagesClass.isStopComputation()) {
                                synchronized (Main.intFThread) {
                                    Main.intFThread.notify();
                                }
                                synchronized (Main.intGThread) {
                                    Main.intGThread.notify();
                                }
                            } else {
                                IntOps.setStop(true);
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
        System.out.println("binary operation thread between integer values stopped  " + interrupted());
    }

    public int IntBinMin(int fRes, int gRes) {
        return Math.min(fRes, gRes);
    }
}
