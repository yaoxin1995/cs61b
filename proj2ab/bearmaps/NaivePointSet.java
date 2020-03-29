package bearmaps;

import java.util.List;

/**
 * you will first create a naive linear-time solution to
 * solve the problem of finding the closest point to a given coordinate.
 * The goal of creating this class is that you will have a alternative,
 * albeit slower, solution that you can use to easily verify
 * if the result of your k-d tree’s nearest is correct.
 * */
public class NaivePointSet implements PointSet {
    List<Point> myPoints;


    /**
     * You can assume points has at least size 1
     * */
    public NaivePointSet(List<Point> points){
        myPoints=points;
    }
    /**
     * Returns the closest point to the inputted coordinates.
     * This should take θ(N) time where N is the number of points.
     * */

    public Point nearest(double x, double y) {
        Point myPoint = new Point(x, y);
        Point bestPoint = myPoints.get(0);
        double bestDist = Point.distance(myPoint, bestPoint);
        for(int i = 1; i < myPoints.size(); i++) {
            double currentDist = Point.distance(myPoint, myPoints.get(i));
            if(currentDist <= bestDist) {
                bestDist = currentDist;
                bestPoint = myPoints.get(i);
            }
        }
        return bestPoint;
    }


    public static void main(String[] args){
        Point p1 = new Point(1.1, 2.2); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(3.3, 4.4);
        Point p3 = new Point(-2.9, 4.2);

        NaivePointSet nn = new NaivePointSet(List.of(p1, p2, p3));
        Point ret = nn.nearest(3.0, 4.0); // returns p2
       System.out.println(ret.getX()); // evaluates to 3.3
        System.out.print(ret.getY()); // evaluates to 4.4
    }
}
