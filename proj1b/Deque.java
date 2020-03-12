public interface Deque <T>{

    void addFirst(T Item);

    void addLast(T item);


    default boolean isEmpty(){
        if(size()==0)
            return  true;
        return  false;
    }

    int size();

    /*
    Prints the items in the deque from first to last,
    separated by a space. Once all the items have been
    printed, print out a new line.
    */
    void printDeque();

    /*
    *Removes and returns the item at the front of the deque.
    *If no such item exists, returns nul
    * */
    T removeFirst();

    /*Removes and returns the item at the back of the deque.
    *If no such item exists, returns null.
    */
    T removeLast();


    /*
    * Gets the item at the given index,
    * where 0 is the front, 1 is the
    * next item, and so forth.
    * If no such item exists, returns null.
    * Must not alter the deque!
    * */
    T get(int index);

    /*methods in interface without any access control keyword are declare implicit as  "public "*/
}
