import javax.swing.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class MyHashMap<K,V> implements  Map61B<K,V>,Iterable<K> {

    int initialSize;
    double loadFactor;
    private int size;
    private ULLMap<K,V> []ABS;
    private Set<K> set;

    /**
     * increase the size of your MyHashMap
     * when the load factor exceeds the set loadFactor.
     * If initialSize and loadFactor aren’t given,
     * you should set defaults initialSize = 16 and loadFactor = 0.75
     *  */
    public MyHashMap(){
        this(16,0.75);
    }

    public MyHashMap(int initialSize){
        this(initialSize,0.75);
    }

    public MyHashMap(int initialSize, double loadFactor){
        this.initialSize=initialSize;
        this.loadFactor=loadFactor;
        ABS=new ULLMap[this.initialSize];
        size=0;
        set=new HashSet<>();
    }

    /** Removes all of the mappings from this map. */
    @Override
    public void clear(){
        ABS=new ULLMap[this.initialSize];
        size=0;
        set=new HashSet<>();

    }

    /** Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key){
        if(get(key)==null)
            return false;
        return true;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key){
        int index=getHasch(key,ABS.length);
        if(ABS[index]==null)
            return null;
        return ABS[index].get(key);
    }

    /** Returns the number of key-value mappings in this map. */
    @Override
    public int size(){
        return  size;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key,
     * the old value is replaced.
     */
    @Override
    public void put(K key, V value){
        if(key==null)
            throw new IllegalArgumentException("key is null");
        double currentLoadFactor=size/(double)(ABS.length);
        if(currentLoadFactor>=loadFactor)
            resize();
        int Index =getHasch(key,ABS.length);

        if(ABS[Index]==null)
            ABS[Index]=new ULLMap();
        if(!containsKey(key))
            size++;
        ABS[Index].put(key, value);
        set.add(key);

    }

    private void put(K key,V value,ULLMap[] temp){
        if(key==null)
            throw new IllegalArgumentException("key is null");
        int Index =getHasch(key,temp.length);
        if(temp[Index]==null)
            temp[Index]=new ULLMap();
        temp[Index].put(key, value);
        //set.add(key);
    }

    /** Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet(){
        return set;
    }
    /**iterator returns an Iterator that iterates over the stored keys
     * @return*/
    @Override
    public Iterator<K> iterator(){
         return set.iterator();
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException.
     */
    @Override
    public V remove(K key){
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.
     */
    @Override
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }

    private int getHasch(Object key,int modul){
        if(key==null)
            throw  new IllegalArgumentException("key is null,thus key doesn't have hash code");

        return Math.floorMod(key.hashCode(),modul);
    }

    private void resize(){
        int currentSize=ABS.length;
        ULLMap<K,V>[] temp=new ULLMap[currentSize*2];
        for(K key: set){
            V tempValue=get(key);
            put(key,tempValue,temp);
        }
        ABS=temp;
    }
}