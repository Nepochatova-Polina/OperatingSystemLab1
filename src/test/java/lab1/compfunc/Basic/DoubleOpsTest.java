package lab1.compfunc.Basic;

import junit.framework.TestCase;

public class DoubleOpsTest extends TestCase {

    public void testCountF() {
        double[] xArray = {1.4,4.6,6.5,13.654,15.5};
        double[] resArray = {3.626666666666666,20.775384615384613,42.02777777777778,186.3459085519135,240.17592592592592};
        for (int i = 0; i < 5; i++) {
            assertEquals(resArray[i], DoubleOps.countF(xArray[i]));
        }
    }

    public void testCountG() {
        double[] xArray = {1.4,4.6,6.5,13.654,15.5};
        double[] resArray = {10.744,105.33599999999997,282.625,2553.538650264,3731.875};
        for (int i = 0; i < 5; i++) {
            assertEquals(resArray[i],DoubleOps.countG(xArray[i]));
        }
    }
}