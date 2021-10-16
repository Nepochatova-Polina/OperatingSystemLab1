package lab1.compfunc.Advanced;

import lab1.compfunc.Advanced.BinaryFunc.DoubleBinaryMin;
import lab1.compfunc.Advanced.BinaryFunc.IntBinaryMin;
import lab1.compfunc.Advanced.DoubleOps.DoubleOpsF;
import lab1.compfunc.Advanced.DoubleOps.DoubleOpsG;
import lab1.compfunc.Advanced.IntOps.IntOpsF;
import lab1.compfunc.Advanced.IntOps.IntOpsG;

import javax.swing.*;

public class Main {
    public static final IntOpsF intFThread = new IntOpsF();
    public static final IntOpsG intGThread = new IntOpsG();
    public static final DoubleOpsF doubleFThread = new DoubleOpsF();
    public static final DoubleOpsG doubleGThread = new DoubleOpsG();
    public static final IntBinaryMin intBinThread = new IntBinaryMin();
    public static final DoubleBinaryMin doubleBinThread = new DoubleBinaryMin();
    public static  JTextField text = new JTextField();

    public static void main(String[] args) {
        //        PeriodicMessage currMess = new PeriodicMessage();
//
//        intBinThread.start();
//        intFThread.start();
//        intGThread.start();
        doubleGThread.start();
        doubleFThread.start();
//        currMess.start();
        doubleBinThread.start();
//        MKeyListener listener = new MKeyListener();
//       listener.run();


    }


}
