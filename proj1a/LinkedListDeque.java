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
public class LinkedListDeque <BleepBlorp> {

    private int size;
    private StaffNode sentinel; //the first item if existe is sentinel.next




    /**
     * the node
     ***/
    class StaffNode{
        public BleepBlorp item;
        public StaffNode next;
        public StaffNode prev;
        StaffNode(BleepBlorp item,StaffNode nnext,StaffNode pprev){
            this.item= item;
            next=nnext;
            prev=pprev;
        }


    }


    /**
     * empty list
     **/
    public LinkedListDeque(){

        sentinel =new StaffNode(null,null,null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size=0;
    }
    /**
     *
     * */


    public LinkedListDeque(LinkedListDeque other){
        sentinel =new StaffNode(null,null,null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size=0;

        for(int i=0;i<other.size();i++){
            addLast((BleepBlorp)other.get(i));
        }

    }


    /**add an item of type T to the front of the deque */
    public void adddFirst(BleepBlorp item){
        StaffNode Node =new StaffNode(item,sentinel.next,sentinel);
        sentinel.next.prev=Node;
        sentinel.next=Node;
        size++;
    }

    /**
     * add an item of type T to the back of the deque
     * */
    public void addLast(BleepBlorp item){
        StaffNode Node=new StaffNode(item,sentinel,sentinel.prev);
        sentinel.prev.next=Node;
        sentinel.prev=Node;
        size++;

    }

    /**
     * Return ture if deque is empty
     * */

    public boolean isEmptu(){
        if(size==0)
            return true;
        else
            return false;

    }

    /**
     * return the number of the items in the deque
     * */
    public int size(){
        return size;
    }

    /**
     * prints the items in the deque from first to last ,separated
     * by a spave,once all items habe been print out a new line
     * */
    public void printDeque(){
        StaffNode P=sentinel;
        for(int i=0;i<size;i++){
            System.out.print(P.item.toString()+" ");
            P=P.next;
        }
        System.out.println();

    }

    /**
     * removes and returns the item at the front of the deque
     * if no such item exists ,return null
     * */
    public BleepBlorp removefirst(){
        if(size==0)
            return  null;

        sentinel.next=sentinel.next.next;
        sentinel.next.prev=sentinel;
        size--;
        if(size==0)
            return  null;
        else
            return  sentinel.next.item;
    }

    /**
     * removes and returns the item at the back of the deque
     * if no such item exists return null*/
    public BleepBlorp removeLast(){
        if(size==0)
            return  null;
        sentinel.prev=sentinel.prev.prev;
        sentinel.prev.next=sentinel;
        size--;
        if(size==0)
            return null;
        else
            return  sentinel.prev.item;
    }

    /**
     * gets the item at the given index,
     * where 0 is the front,1 is the next item,an so forth
     * if no such item exists ,returns null. must not alter the deque
     * */
    public BleepBlorp get(int index){
        if(size==0)
            return  null;
        StaffNode p= sentinel.next;
        for(int i=0;i<index;i++){
            p=p.next;
        }
        return p.item;
    }


    public BleepBlorp getTecursive(int index){
        if(size==0)
            return null;
        return getTecursiveHelp(index,sentinel.next);

    }

    private  BleepBlorp getTecursiveHelp(int Index,StaffNode curr){
        if(Index==0)
            return  curr.item;
        else{
            return getTecursiveHelp(Index--,curr.next);
        }
    }

}
