import org.junit.Test;

import static org.junit.Assert.*;
public class TestExperimentHelper {

    /** Returns the internal path length for an optimum binary search tree of
     *  size N. Examples:
     *  N = 1, OIPL: 0
     *  N = 2, OIPL: 1
     *  N = 3, OIPL: 2
     *  N = 4, OIPL: 4
     *  N = 5, OIPL: 6
     *  N = 6, OIPL: 8
     *  N = 7, OIPL: 10
     *  N = 8, OIPL: 13
     */
    @Test
    public void TestOptimalIPL(){
        for(int i=1;i<=8;i++) {
            System.out.print(ExperimentHelper.optimalIPL(i)+" ");
        }
    }

    /** Returns the average depth for nodes in an optimal BST of
     *  size N.
     *  Examples:
     *  N = 1, OAD: 0
     *  N = 5, OAD: 1.2
     *  N = 8, OAD: 1.625
     * @return
     */

    @Test
    public void TestOptimalAverageDepth(){
        double[] a=new double[3];
        a[0]=ExperimentHelper.optimalAverageDepth(1);

        a[1]=ExperimentHelper.optimalAverageDepth(5);

        a[2]=ExperimentHelper.optimalAverageDepth(8);

        double[] expect={0,1.2,1.625};

        assertArrayEquals(expect,a,0.01);
    }


}
