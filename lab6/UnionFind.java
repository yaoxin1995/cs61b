public class UnionFind {

    // TODO - Add instance variables?
    int[] abc;


    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        abc=new int[n];
        for(int i=0;i<n;i++){
            abc[i]=-1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        // TODO
        if(vertex<0||vertex>=abc.length)
            throw new RuntimeException("v1 is not a valid index");
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        int index=find(v1);
        return abc[index];
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        // TODO
        return abc[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        int rootIndex1=find(v1);
        int rootIndex2=find(v2);
        if(rootIndex1==rootIndex2)
            return true;
        else
            return false;

    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        // TODO
        int rootIndex1=find(v1);
        int rootIndex2=find(v2);
        if(abc[rootIndex2]>=abc[rootIndex1]){
            int sizeTree1=abc[rootIndex1];
            abc[rootIndex2]+=sizeTree1;
            abc[rootIndex1]=rootIndex2;
        }
        else{
            int sizeTree2=abc[rootIndex2];
            abc[rootIndex1]+=sizeTree2;
            abc[rootIndex2]=rootIndex1;

        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        // TODO
        if(abc[vertex]<0)
            return vertex;
        return find(parent(vertex));
    }

}
