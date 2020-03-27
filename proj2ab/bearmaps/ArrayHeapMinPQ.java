package bearmaps;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ArrayHeapMinPQ <T>implements ExtrinsicMinPQ<T> {
    /* Adds an item with the given priority value. Throws an
     * IllegalArgumentExceptionb if item is already present.
     * You may assume that item is never null. */

    /**
     * If using an array representation for your min heap,
     * it should never be more than (edit: 3/13/19) approximately
     * 3/4s empty.
     * */

    /***
     * The priority is extrinsic to the object. That is,
     * rather than relying on some sort of comparison function to decide which item is less than another,
     * we simply assign a priority value using the add or changePriority functions.
     * There is an additional changePriority function
     * that allows us to set the extrinsic priority of an item after it has been added.
     * There is a contains method that returns true if the given item exists in the PQ.
     * There may only be one copy of a given item in the priority queue at any time.
     * Edit (3/13/19): To be more precise, if you try to add an item that is equal to another according to .equals,
     * the PQ should throw an exception.
     * If there are 2 items with the same priority, you may break ties arbitrarily.
     */

    private ArrayList<PriorityNode> items;

    private HashMap<T,Integer> index;

    private  int size;

    public ArrayHeapMinPQ(int initCapacity){
        items = new ArrayList<>(initCapacity+1);
        size = 0;
        items.add(null);
        index=new HashMap<>();
    }

    public ArrayHeapMinPQ(){
        this(3);
    }



    /* Adds an item with the given priority value. Throws an
     * IllegalArgumentExceptionb if item is already present.
     * You may assume that item is never null. */
   public void add(T item, double priority){
       if(contains(item))
           throw new IllegalArgumentException("item existed");
        PriorityNode temp=new PriorityNode(item,priority);
        items.add(temp);
        size++;
        index.put(item,size);

        swapUp(size);

    }
    /* Returns true if the PQ contains the given item. */
    public boolean contains(T item){
        return index.containsKey(item);
    }
    /* Returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    public T getSmallest(){

        return items.get(1).item;
    }
    /* Removes and returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    public T removeSmallest(){
        if(size==0)
            throw  new IllegalArgumentException("size is zero");
        T item=items.get(1).getItem();
        exch(1,size--);
        items.set(size+1,null);
        sink(1);
        return item;
    }
    /* Returns the number of items in the PQ. */
    public int size(){
        return size;
    }
    /* Changes the priority of the given item. Throws NoSuchElementException if the item
     * doesn't exist. */
    public void changePriority(T item, double priority){
        if(!contains(item))
            throw new NoSuchElementException();
        int index=this.index.get(item);

        PriorityNode temp=items.get(index);
        temp.setPriority(priority);
        if(index>1&&items.get(parent(index)).compareTo(temp)>0)
            swapUp(index);
        else if(items.get(index).compareTo(items.get(leftChild(index)))>0||items.get(index).compareTo(items.get(rightChild(index)))>0)
            sink(index);
    }



    private int leftChild(int k){

        return 2*k;
    }

    private  int rightChild(int k){
        return 2*k+1;
    }

    private int parent(int k){
        return k/2;
    }


    private void swapUp(int k) {
        while (k > 1) {
            int parent = parent(k);
            int cmp = items.get(k).compareTo(items.get(parent));
            if(cmp>0)
                break;
            exch(k,parent);
            k=parent;
        }
    }

    private  void exch(int i,int j){
        index.put(items.get(i).item,j);
        index.put(items.get(j).item,i);
        PriorityNode temp=items.get(i);
        items.set(i,items.get(j));
        items.set(j,temp);
    }

    private void sink(int k){
        while (leftChild(k)<=size){
            int j=leftChild(k);
            if(j<size()&&items.get(j).compareTo(items.get(j+1))>0) //right child has greater priority than left child
                j++;
            if(items.get(k).compareTo(items.get(j))<0)
                break;
            exch(k,j);
            k=j;
        }

    }



    private  class PriorityNode implements Comparable<PriorityNode> {
            private T item;
            private double priority;

            public PriorityNode(T item ,double priority){
                    this.item=item;
                    this.priority=priority;
            }

            public T getItem(){
                return item;
            }

            public double getPriority(){
                return priority;
            }

            public void setPriority(double a){
                priority=a;
            }

            @Override
            public int compareTo(PriorityNode o){
                if(o==null)
                    return -1;
                return (int)(this.priority-o.getPriority());
            }

            @Override
            public boolean equals(Object o){
                if(o==null)
                    return false;
                if(o.getClass()!=this.getClass())
                    return false;
                if(o==this)
                    return  true;
                return ((PriorityNode)o).getItem()==this.getItem();
            }

            @Override
            public int hashCode(){
                return this.getItem().hashCode();
            }
        }


}
