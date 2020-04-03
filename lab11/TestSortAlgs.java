import edu.princeton.cs.algs4.Queue;

import org.junit.Test;



import static org.junit.Assert.assertEquals;

public class TestSortAlgs {

    @Test
    public void testQuickSort() {

    }

    @Test
    public void testMergeSort() {
        Queue<String> tas = new Queue<String>();
        tas.enqueue("Joe");
        tas.enqueue("Omar");
        tas.enqueue("Itai");
        tas.enqueue("Zzz");
        tas.enqueue("Yes");

       Queue<String> test= MergeSort.mergeSort(tas);
        String[] expect={"Itai","Joe","Omar","Yes","Zzz"};
        for(int i=0;i<tas.size();i++){
            assertEquals(test.dequeue(),expect[i]);
        }

    }

    /**
     * Returns whether a Queue is sorted or not.
     *
     * @param items  A Queue of items
     * @return       true/false - whether "items" is sorted
     */
    private <Item extends Comparable> boolean isSorted(Queue<Item> items) {
        if (items.size() <= 1) {
            return true;
        }
        Item curr = items.dequeue();
        Item prev = curr;
        while (!items.isEmpty()) {
            prev = curr;
            curr = items.dequeue();
            if (curr.compareTo(prev) < 0) {
                return false;
            }
        }
        return true;
    }
}
