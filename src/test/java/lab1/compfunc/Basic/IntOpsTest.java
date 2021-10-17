package lab1.compfunc.Basic;

import junit.framework.TestCase;
import lab1.compfunc.Basic.IntOps;

public class IntOpsTest extends TestCase {

    public void testCountF() {
        int[] xArray = {1,4,6,13,15};
        int[] resArray = {2,16,36,169,225};
        for (int i = 0; i < 5; i++) {
            assertEquals(resArray[i], IntOps.countF(xArray[i]));
        }
    }

    public void testCountG() {
        int[] xArray = {1,4,6,13,15};
        int[] resArray = {9,72,224,2205,3383};
        for (int i = 0; i < 5; i++) {
            assertEquals(resArray[i],IntOps.countG(xArray[i]));
        }
    }

}