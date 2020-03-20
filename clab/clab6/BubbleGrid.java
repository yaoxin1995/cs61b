public class BubbleGrid {
    private int[][] grid;

    /* Create new BubbleGrid with bubble/space locations specified by grid.
     * Grid is composed of only 1's and 0's, where 1's denote a bubble, and
     * 0's denote a space. */
    public BubbleGrid(int[][] grid) {
        this.grid = grid;
    }

    /* Returns an array whose i-th element is the number of bubbles that
     * fall after the i-th dart is thrown. Assume all elements of darts
     * are unique, valid locations in the grid. Must be non-destructive
     * and have no side-effects to grid. */
    public int[] popBubbles(int[][] darts) {
        int row =grid.length; //行
        int column=grid[0].length;//列
        int [][] a=new int[row][column];
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};  //数组中某个点的上下左右四个方向分量


        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                a[i][j]=grid[i][j];
            }
        }

        //初始化，去除所有darts中出现的点
        for(int i=0;i<darts.length;i++){
            if(a[darts[i][0]][darts[i][1]]==1)
                a[darts[i][0]][darts[i][1]]=0;
        }

        /**
         *  构建set,在顶部的泡泡与点R*C相连，R*C为树的顶点*/
        UnionFind dsu=new UnionFind(row*column+1);
        for(int r=0;r<row;r++){
            for(int c=0;c<column;c++){
                if(r==0&&a[r][c]==1)
                    dsu.union(r*column+c,row*column);
                else if(r>0&&a[r][c]==1&&a[r-1][c]==1)
                    dsu.union(r*column+c,(r-1)*row+c);
                else if(c>0&&a[r][c]==1&&a[r][c-1]==1)
                    dsu.union(r*column+c,r*column+c-1);
            }
        }

        int[] answer = new int[darts.length];
        int t=darts.length-1;
        while (t>=0){
            int x=darts[t][0];
            int y=darts[t][1]; //取出飞镖要向地址的横纵坐标
            int preroof=dsu.sizeOf(row*column);
            if(grid[x][y]==0){
                t--;
            }
            else {
                int index=x*column+y;
                for(int i=0;i<4;i++){
                    int nr=x+dr[i];
                    int nc=y+dc[i];
                    if(nr>=0&&nc>=0&&nr<grid.length&&nc<grid[0].length&&a[nr][nc]==1){
                        dsu.union(index,nr*column+nc);
                    }
                }
                a[x][y]=1;
                answer[t]=dsu.sizeOf(row*column)-preroof-1;//逆向添加的进去被飞镖砸碎的点不能算进去
                t--;


            }

        }
        return answer;

    }
}
