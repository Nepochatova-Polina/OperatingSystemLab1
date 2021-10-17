package lab1.compfunc.Advanced.IntOps;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class IntTrialTest {

    @Test(expected = AssertionError.class)
    public void testCountF() {
        int[] xArray = {1,4,6,13,15,0,2};
        int[] resArray = {2,16,36,169,225,2,0};
        for (int i = 0; i < xArray.length; i++) {
            Assert.assertEquals(resArray[i], IntTrialF.countF(xArray[i]));
        }
    }

    @Test(expected = ArithmeticException.class)
    public void testCountG() {
        int[] xArray = {1,4,6,13,15,0,5};
        int[] resArray = {-2,-72,224,275,338,-1,0};
        for (int i = 0; i < xArray.length; i++) {
            Assert.assertEquals(resArray[i], IntTrialG.countG(xArray[i]));
        }

    }

}