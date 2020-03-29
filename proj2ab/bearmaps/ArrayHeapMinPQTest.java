package bearmaps;

import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;

import static org.junit.Assert.*;

public class ArrayHeapMinPQTest {

    @Test
    public void testRemove(){
        ArrayHeapMinPQ<Integer> a=new ArrayHeapMinPQ<>();
        a.add(2,1);
        a.add(1,2);
        a.add(3,2);
        a.add(8,7);
        a.add(4,0);
        a.add(5,4);
        a.add(6,5);
        a.add(7,6);
     //   Integer[] testA=(Integer[])( a.returnTest());

        int test=a.removeSmallest();

        int test1=a.removeSmallest();

        int test2=a.removeSmallest();

        String expect="4";

        String expect2="2";

        String expect3="1";

        assertNotNull(expect,test);

        assertEquals(expect,test1);

        assertEquals(expect3,test2);
    }




    @Test
    public void testChangePriority(){
        ArrayHeapMinPQ<String >  test =new ArrayHeapMinPQ<>();
        for(int i=0;i<=10;i++){
            test.add("check"+i,i);
        }
        assertTrue(test.contains("check10"));

        test.changePriority("check10",0);

        String testS=test.removeSmallest();

        assertEquals("check10",testS);
    }



    @Test
    public void runtimeTest() {
        Stopwatch sw = new Stopwatch();
        ArrayHeapMinPQ<String >  test1 =new ArrayHeapMinPQ<>();
       for(int i=0;i<100000;i++){
           test1.add("check"+i,i+1);
       }

        System.out.println("Total time elapsed: " + sw.elapsedTime() + " seconds.");



        Stopwatch sw1 = new Stopwatch();
        Random a=new Random(12);
        Random b=new Random(1);

        for(int i=3000;i<40000;i++){

            int temp=a.nextInt(1000000);

            double temp1=a.nextDouble();
            test1.changePriority("check"+i,temp1);
        }

        System.out.println("Total time elapsed: " + sw.elapsedTime() + " seconds.");


    }



    @Test
    public void runtimeTest1() {
        Stopwatch sw = new Stopwatch();
        NaiveMinPQ<String>  test1 =new NaiveMinPQ<>();
        for(int i=0;i<100000;i++){
            test1.add("check"+i,i+1);
        }

        System.out.println("Total time elapsed: " + sw.elapsedTime() + " seconds.");



        Stopwatch sw1 = new Stopwatch();
        Random a=new Random(12);
        Random b=new Random(1);

        for(int i=3000;i<40000;i++){

            int temp=a.nextInt(1000000);

            double temp1=a.nextDouble();
            test1.changePriority("check"+i,temp1);
        }

        System.out.println("Total time elapsed: " + sw.elapsedTime() + " seconds.");


    }

    @Test
    public void main(){
        runtimeTest();
        runtimeTest1();
    }


}
