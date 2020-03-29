package bearmaps;

import java.util.List;

public class KDTree {
    final boolean  vertical = true;
    final boolean horizon= false;
    private Node root;
    List<Point> myPoints;

    public KDTree(List<Point> points){
        myPoints=points;
        for(Point p:points){
            root=add(p,root,horizon);
        }

    }


    /**
     Returns the closest point to the inputted coordinates.
     This should take O(logN) time on average, where N is the number of points.
     */
    public Point nearest(double x, double y){
        Node best =nearest(root,new Point(x,y),root);
        return best.point;
    }

    private Node nearest(Node n,Point goal,Node best){
        if(n==null) return best;
        if(Point.distance(n.point,goal)<Point.distance(best.point,goal))
            best=n;
        Node gutSide=n.leftChild;
        Node badSide=n.rightChild;
        int cmp =compareC(goal,n.point,n.orientation);
        if(cmp>=0){
            gutSide=n.rightChild;
            badSide=n.leftChild;
        }
        else{
            gutSide=n.leftChild;
            badSide=n.rightChild;
        }
        best=nearest(gutSide,goal,best);
        if(concodernB(n,best,goal,n.orientation))  //pruning rule
            best=nearest(badSide,goal,best);
        return best;
    }

    private boolean concodernB(Node n,Node best,Point goal,boolean orientation){
        double cmp=0;
        double bestD=Math.sqrt(Point.distance(best.point,goal));
        if(orientation==horizon){
            cmp=Math.abs((n.point.getX()-goal.getX()));
        }
        else {
            cmp=Math.abs(n.point.getY()-goal.getY());
        }


        if(cmp<=bestD)
            return true;
        return false;

    }


    private Node add(Point p,Node root,boolean orientation){
        if(root==null)
            return new Node(p.getX(),p.getY(),orientation);
        if(root.point.equals(p))
            return root;
        int cmp=compareC(p,root.point,orientation);
        if(cmp>=0){   //go right oder up
            root.rightChild=add(p,root.rightChild,!orientation);
        }
        else if(cmp<0){   //go left
            root.leftChild=add(p,root.leftChild,!orientation);
        }
        return root;
    }

    private int compareC(Point source,Point p,boolean orientation){
        if(orientation==horizon){
            return Double.compare(source.getX(),p.getX());

        }
        else{
            return Double.compare(source.getY(),p.getY());
        }
    }



    private class Node{
        private boolean orientation;

        private  Point point;

        private Node leftChild;     //also refer to the "down" child

        private Node rightChild;    //also refer to the "up"  child

        public Node(double x,double y,boolean orientation){
            point=new Point(x,y);
            this.orientation=orientation;
        }


        public Point getPoint(){
            return point;
        }


        public double distance(Point p){
            return  Point.distance(this.point,p);

        }
    }
}
