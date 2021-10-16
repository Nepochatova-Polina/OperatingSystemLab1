package lab1.compfunc.Advanced.BinaryFunc;

import lab1.compfunc.Advanced.DoubleOps.DoubleOps;
import lab1.compfunc.Advanced.DoubleOps.DoubleOpsF;
import lab1.compfunc.Advanced.DoubleOps.DoubleOpsG;
import lab1.compfunc.Advanced.Main;
import lab1.compfunc.Advanced.PeriodicMessage;

public class DoubleBinaryMin extends Thread{
    @Override
    public void run() {
        while (!Main.doubleFThread.isInterrupted() && !Main.doubleGThread.isInterrupted()) {
            if (DoubleOps.getCounter() == 0) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!PeriodicMessage.messageFlag) {
                    double DoubleOfBinOperation = DoubleBinMin(DoubleOpsF.getFResult(), DoubleOpsG.getGResult());
                    System.out.println("Minimum of two double results is: " + DoubleOfBinOperation);
                    Main.text.setText("Minimum of two double results is: " + DoubleOfBinOperation);
//                    Main.text.
                    DoubleOps.setCounter(2);
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
                            if (!PeriodicMessage.stopComputation) {
                                synchronized (Main.doubleFThread) {
                                    Main.doubleFThread.notify();
                                }
                                synchronized (Main.doubleGThread) {
                                    Main.doubleGThread.notify();
                                }
                            }else{
                                DoubleOps.stop = true;
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
        System.out.println("binary operation thread between double values stopped "+ interrupted());

    }
    public double DoubleBinMin(double fRes, double gRes) {return Math.min(fRes, gRes);}
}
