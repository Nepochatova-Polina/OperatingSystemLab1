package lab1.compfunc.Advanced.BinaryFunc;

import lab1.compfunc.Advanced.IntOps.IntOps;
import lab1.compfunc.Advanced.IntOps.IntOpsF;
import lab1.compfunc.Advanced.IntOps.IntOpsG;
import lab1.compfunc.Advanced.Main;
//import lab1.compfunc.Advanced.Message;
import lab1.compfunc.Advanced.PeriodicMessage;

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
                if (!PeriodicMessage.messageFlag) {
                    int IntOfBinOperation = IntBinMin(IntOpsF.getFResult(), IntOpsG.getGResult());
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
                            if (!PeriodicMessage.stopComputation) {
                                synchronized (Main.intFThread) {
                                    Main.intFThread.notify();
                                }
                                synchronized (Main.intGThread) {
                                    Main.intGThread.notify();
                                }
                            }else{
                                IntOps.stop = true;
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

    public int IntBinMin(int fRes, int gRes) {return Math.min(fRes, gRes);}
}
