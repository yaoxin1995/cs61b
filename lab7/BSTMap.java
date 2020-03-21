import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import  java.util.NoSuchElementException;
import  java.lang.Object;

public class BSTMap<K extends  Comparable<K> ,V> implements Map61B<K,V>{
    private Node root;

    private K[] key;


    private class Node {
        private K key;           // sorted by key
        private V val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(K key, V val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public  BSTMap(){

    }
    /** Removes all of the mappings from this map. */
    @Override
    public void clear(){
        root=null;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key){
        if(get(key)!=null)
            return true;
        return false;
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
   public V get(K key){
     if(key==null)
         return  null;
     return getKey(root,key);
    }

    private V getKey(Node root,K key) {
        if (root == null)
            return null;
        int cmp = root.key.compareTo(key);
        if (cmp < 0) {   //go left
            return getKey(root.left, key);
        } else if (cmp > 0) { //go right
            return getKey(root.right, key);
        } else
            return root.val;
            //return null;

    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size(){
        if(root==null)
            return 0;
        return root.size;}

    private int size(Node x){
        if(x==null) return 0;
        else return x.size;
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        if(key==null)
            throw new java.lang.IllegalArgumentException("call put() with a null key");
        root=put(root,key,value);
    }

    private Node put(Node root,K key,V value){
        if(root==null) return new Node(key,value,1);
        int cmp=root.key.compareTo(key);
        if(cmp<0) root.left=put(root.left, key,value);
        else if(cmp>0) root.right=put(root.right,key,value);
        else root.val=value;
        root.size=size(root.left)+size(root.right)+1;
        return root;

    }

    /**
     * prints out your BSTMap in order of increasing Key.
     * */
    public void printInOrder(){
        helPPrintInOrder(root);
    }

    private  void helPPrintInOrder(Node node){
        if(node==null)
            return;

        helPPrintInOrder(node.left);

        if(node.val!=null)
            System.out.print(node.val+" ");

        helPPrintInOrder(node.right);
    }



    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet(){
        Set<K> a=new java.util.HashSet<K>();
        helpKeySet(root,a);
        return a;

    }

    private  void helpKeySet(Node node,Set a){
        if(node==null)
            return;

        helpKeySet(node.left,a);

        a.add(node.key);


        helpKeySet(node.right,a);
    }


    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key){
             throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

}
