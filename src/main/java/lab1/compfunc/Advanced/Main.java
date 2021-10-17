package lab1.compfunc.Advanced;

import lab1.compfunc.Advanced.BinaryFunc.DoubleBinaryMin;
import lab1.compfunc.Advanced.BinaryFunc.IntBinaryMin;
import lab1.compfunc.Advanced.DoubleOps.DoubleTrialF;
import lab1.compfunc.Advanced.DoubleOps.DoubleTrialG;
import lab1.compfunc.Advanced.IntOps.IntTrialF;
import lab1.compfunc.Advanced.IntOps.IntTrialG;
import lab1.compfunc.Advanced.Message.StopByKey;
import lab1.compfunc.Advanced.Message.PeriodicMessage;

public class Main {
    public static final IntTrialF intFThread = new IntTrialF();
    public static final IntTrialG intGThread = new IntTrialG();
    public static final DoubleTrialF doubleFThread = new DoubleTrialF();
    public static final DoubleTrialG doubleGThread = new DoubleTrialG();
    public static final IntBinaryMin intBinThread = new IntBinaryMin();
    public static final DoubleBinaryMin doubleBinThread = new DoubleBinaryMin();

    public static void main(String[] args) {
        PeriodicMessage currMess = new PeriodicMessage();
        StopByKey keymess = new StopByKey();

        intBinThread.start();
        intFThread.start();
        intGThread.start();
//        doubleGThread.start();
//        doubleFThread.start();
//        currMess.start();
        keymess.start();
//        doubleBinThread.start();

    }


}
