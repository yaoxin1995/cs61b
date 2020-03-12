import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;

import javax.naming.SizeLimitExceededException;

public class ArrayDeque<T>{


    private T[] items;
    private int size;
    private  int nextLast;
    private int nextFirst;
    private int rFactor=2;
    private double usageRation=0.25;
    private  int capacity=8;


    //empty Alist
    public  ArrayDeque(){
       items=(T [])new Object[capacity];
       size=0;
       nextFirst=4;
       nextLast=5;
    }

    public ArrayDeque(ArrayDeque[] other){
        System.arraycopy(items,0,other,0,other.length);
    }

    private int minusOne(int index){
       return index-1+items.length%items.length;
    }

    private int plusOne(int index){
        return (nextLast+1)%items.length;
    }
    /**
     * Adds an item of type T to the front
     * of the deque*/
    public void addFirst(T item){
        if(size==items.length)
            resize(items.length*rFactor);
        items[nextFirst]=item;
        size=size+1;
        nextFirst=minusOne(nextFirst);
    }

    public void addLast(T item){
        if(size==items.length)
            resize(items.length*rFactor);
        items[nextLast]=item;
        size++;
        nextLast=plusOne(nextLast);
    }

    public boolean isEmpty(){
        if(size==0)
            return  true;
        else
            return  false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int first=plusOne(nextFirst);
        int position=0;
        for(int i=0;i<size;i++){
            position=first+i%items.length;
            System.out.print(items[position].toString());
        }
    }

    public T removeFirst(){
        if(isEmpty())
            return null;
        int first=plusOne(nextFirst);
        T First=items[first];
        items[first]=null;
        size--;
        saveMemory();
        return First;

    }

    public T removeLast(){
        if(isEmpty())
            return null;
        int last=minusOne(nextLast);
        T Last =items[last];
        items[last]=null;
        size--;
        saveMemory();
        return  Last;


    }
    private void saveMemory(){
        double curUsageRation=size/items.length;
        if(items.length>16&&usageRation<0.25){
            resize(items.length/2);
        }
    }

    public T get(int index){
        int first=plusOne(nextFirst);
        int realIndex=(first+index)/items.length;
        return items[realIndex];

    }

    private void resize(int Capacity){
        T[] a =(T[])new Object[Capacity];
        int first =plusOne(nextFirst);

        for(int i=0;i<size;i++){
            a[i]=items[i];
        }

        items=a;

        nextFirst=items.length-1;
        nextLast=size;
    }



}
