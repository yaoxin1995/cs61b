package es.datastructur.synthesizer;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        rb=(T[])new Object[capacity];
        first=0;
        last=0;
        fillCount=0;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update
        //       last.
        if(fillCount==capacity())
            throw new RuntimeException("Ring buffer overflow");
        fillCount++;
        rb[last]=x;
        if(last==rb.length-1)
            last=0;
        else
            last++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and
        //       update first.
        if(fillCount==0)
            throw new RuntimeException("Ring buffer underflow");
        fillCount--;
        T item=rb[first];
        if(first==rb.length-1)
            first=0;
        else
            first++;
        return  item;

    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should
        //       change.
        if(fillCount==0)
            throw new RuntimeException("Ring buffer underflow");
        return rb[first];
    }

    @Override
    public int capacity(){
        return rb.length;
    }

    @Override
    public int fillCount(){
        return fillCount;
    }




    // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.

    @Override
    public Iterator<T> iterator(){
        return new arrayRingBufferIterator();
    }

    private class arrayRingBufferIterator implements Iterator{
        private int wizPos;
        public arrayRingBufferIterator() { wizPos = first; }
        public boolean hasNext() {
            if(wizPos==last){
                return false;
            }
            return true;
        }
        public T next() {
            T returnItem = rb[wizPos];
            wizPos = getNextWizPos(wizPos);
            return returnItem;
        }

        private int getNextWizPos(int wizPos){
            if(wizPos==capacity()-1)
                return 0;
            else
                return wizPos+1;

        }

    }

    @Override
    public boolean equals(Object o){
        if(o==null)
            return false;
        else if(this==o)
            return true;
        else if(this.getClass()!=o.getClass())
            return false;
        ArrayRingBuffer<T> other=(ArrayRingBuffer<T>)o;

        if(this.fillCount!=other.fillCount)
            return false;
        for(T item:this){
            if(!other.contain(item))
                return false;

        }
        return  true;

    }

    public boolean contain(T item){
        for(T a:rb){
            if(item==a)
                return true;
        }
        return false;
    }
}
    // TODO: Remove all comments that say TODO when you're done.
