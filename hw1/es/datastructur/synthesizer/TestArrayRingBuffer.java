package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<String> arb = new ArrayRingBuffer(5);
        //arb.peek();

        //last 超过上边界
        arb.enqueue("a");
        arb.enqueue("b");
        arb.enqueue("c");
        arb.dequeue();
        arb.dequeue();
        arb.enqueue("d");
        arb.enqueue("e");
        arb.enqueue("g");
        String[] expected ={"c","d","e","g"};
        String[] actual=new String[4];

        int A=arb.fillCount();
        for(int i=0;i<A;i++){
            actual[i]=arb.dequeue();
        }

        assertArrayEquals(expected,actual);


        //first 超过上边界
        ArrayRingBuffer<String> ar = new ArrayRingBuffer(5);

        ar.enqueue("a");
        ar.enqueue("b");
        ar.enqueue("c");
        ar.enqueue("d");
        ar.enqueue("e");

        ar.dequeue();
        ar.dequeue();
        ar.dequeue();
        ar.dequeue();
        ar.enqueue("gg");
        ar.enqueue("bb");
        ar.dequeue();
        ar.dequeue();


        String[] expected1 ={"bb"};
        String[] actual1=new String[1];

        int B=ar.fillCount();
        for(int i=0;i<B;i++){
            actual1[i]=ar.dequeue();
        }
        assertArrayEquals(expected1,actual1);


    }

    @Test
    public void testIteration(){
        ArrayRingBuffer<String> arb = new ArrayRingBuffer(5);
        arb.enqueue("a");
        arb.enqueue("b");
        arb.enqueue("c");
        arb.dequeue();
        arb.dequeue();
        arb.enqueue("d");
        arb.enqueue("e");
        arb.enqueue("g");
        //String[] expected ={"c","d","e","g"};
        //String[] actual=new String[4];

        ArrayRingBuffer<String> c=new ArrayRingBuffer(4);
        c.enqueue("g");
        c.enqueue("e");
        c.enqueue("c");
        c.enqueue("d");


        for(String item:arb){
            System.out.print(item+" ");
        }

        arb.equals(c);
        assertTrue(arb.equals(c));




    }
}
