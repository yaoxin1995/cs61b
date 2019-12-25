/**
 * add and remove operations must not involve any looping
 * or recursion. A single such operation must take “constant
 * time”, i.e. execution time should not depend on the size of the deque.
 * get must use iteration, not recursion.
 * size must take constant time.
 * The amount of memory that your program uses at any
 * given time must be proportional to the number of items.
 * For example, if you add 10,000 items to the deque, and
 * then remove 9,999 items, the resulting size should be more
 * like a deque with 1 item than 10,000. Do not maintain references
 * to items that are no longer in the deque.*/
class LinkedListDeque <T> {

    private int size;
    private IntNode sentinel;

    public class IntNode{
        public T item;
        public IntNode next;
        public IntNode prev;
        public IntNode(T item,IntNode nnext,IntNode pprev){
            this.item= item;
            next=nnext;
            prev=pprev;
        }
    }


    public LinkedListDeque(){

    }

    public LinkedListDeque(LinkedListDeque other){

    }


    /**add an item of type T to the front of the deque */
    public void adddFirst(T item){

    }

    /**
     * add an item of type T to the back of the deque
     * */
    public void addLast(T item){

    }

    /**
     * Return ture if deque is empty
     * */

    public boolean isEmptu(){

        return  true;

    }

    /**
     * return the number of the items in the deque
     * */
    public int size(){
        return 0;
    }

    /**
     * prints the items in the deque from first to last ,separated
     * by a spave,once all items habe been print out a new line
     * */
    public void printDeque(){

    }

    /**
     * removes and returns the item at the front of the deque
     * if no such item exists ,return null
     * */
    public T removefirst(){
        return null;
    }

    /**
     * removes and returns the item at the back of the deque
     * if no such item exists return null*/
    public T removeLast(){
        return null;
    }

    /**
     * gets the item at the given index,
     * where 0 is the front,1 is the next item,an so forth
     * if no such item exists ,returns null. must not alter the deque
     * */
    public T get(int index){
        return null;
    }

    public T getTecursive(int index){
        return null;
    }

}