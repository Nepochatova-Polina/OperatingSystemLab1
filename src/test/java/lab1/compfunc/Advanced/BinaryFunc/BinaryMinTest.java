package lab1.compfunc.Advanced.BinaryFunc;

import junit.framework.TestCase;
import lab1.compfunc.Basic.DoubleOps;

public class BinaryMinTest extends TestCase {

    public void testDoubleBinMin() {
        double[] xArray = {1.5, 4.6, 33.5654, 16.88, 8888.5};
        double[] yArray = {2.5, 0.6, 3.554, 167864.88, 588.5};
        double[] resArray = {1.5, 0.6, 3.554, 16.88, 588.5};
        for (int i = 0; i < xArray.length; i++) {
            assertEquals(resArray[i], DoubleBinaryMin.DoubleBinMin(xArray[i], yArray[i]));
        }
    }


    public void testIntBinMin() {
        int[] xArray = {1, 4, 654, 16, 58};
        int[] yArray = {5, 6, 54, 167, 588};
        int[] resArray = {1,4,54, 16, 58};
        for (int i = 0; i < xArray.length; i++) {
            assertEquals(resArray[i], IntBinaryMin.IntBinMin(xArray[i], yArray[i]));
        }

    }
}