package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid;

    private WeightedQuickUnionUF isPercolates;
    private WeightedQuickUnionUF isFullWqu;

    private int sentinalTop;
    private int sentinalBottom;

    private int sizeOfOpen;

    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};  //数组中某个点的上下左右四个方向分量

    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N){

        grid=new boolean[N][N];  //all values will be false by default
        isPercolates=new WeightedQuickUnionUF(N*N+2);
        isFullWqu=new WeightedQuickUnionUF(N*N+1);

        sentinalTop=N*N;
        sentinalBottom=N*N+1;
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col){
        if(row>grid.length-1||row<0||col>grid[0].length-1||col<0)
            throw new java.lang.IndexOutOfBoundsException();
        if(isOpen(row,col))
            return;
        sizeOfOpen++;
        int index =row*grid.length+col;
        grid[row][col]=true;
        for(int i=0;i<4;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if(nr>=0&&nr<=grid.length-1&&nc>=0&&nc<grid[0].length&&isOpen(nr,nc)){
                isFullWqu.union(index,nr*grid.length+nc);
                isPercolates.union(index,nr*grid.length+nc);
            }
        }
        if(row==0){
            isPercolates.union(index,sentinalTop);
            isFullWqu.union(index,sentinalTop);
        }
        else if(row==grid.length-1){
            isPercolates.union(index,sentinalBottom);
        }




    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if(row>grid.length-1||row<0||col>grid[0].length-1||col<0)
            throw new java.lang.IndexOutOfBoundsException();
        if(grid[row][col]==true)
            return true;
        return false;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        if(row>grid.length-1||row<0||col>grid[0].length-1||col<0)
            throw new java.lang.IndexOutOfBoundsException();
        int index=row*grid.length+col;
        if(isFullWqu.connected(index,sentinalTop))
            return true;
        else
            return false;
    }

    // number of open sites
    public int numberOfOpenSites(){
        return sizeOfOpen;
    }

    // does the system percolate?
    public boolean percolates(){
        if(isPercolates.connected(sentinalTop,sentinalBottom))
            return true;
        else
            return false;
    }


    // use for unit testing (not required, but keep this here for the autograder)

    public static void main(String[] args){

    }

}


