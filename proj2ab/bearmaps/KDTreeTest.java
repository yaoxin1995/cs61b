package bearmaps;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class KDTreeTest {
    Random r=new Random(500);

    @Test
    public void simpleTestnearst(){


            Point p1=new Point(2,3);
            Point p2=new Point(4,2);
            Point p3=new Point(4,2);
            Point p4=new Point(4,5);
            Point p5=new Point(3,3);
            Point p6=new Point(1,5);
            Point p7=new Point(4,4);
            Point p8=new Point(1,5);

           // KDTree kd =new KDTree(List.of(p1,p2,p3,p4,p5,p6,p7,p8));

            NaivePointSet kd =new NaivePointSet(List.of(p1,p2,p3,p4,p5,p6,p7,p8));

            Point actualBest=kd.nearest(0,7);

            Point expected=new Point(1,5);

            assertEquals(expected,actualBest);

    }

    private Point randomPoint(){
        double x=r.nextDouble();
        double y=r.nextDouble();
        return new Point(x,y);
    }

    private List<Point> randomPoints(int N){
        List<Point> points=new ArrayList<>();
        for(int i=0;i<N;i+=1){
            points.add(randomPoint());
        }
        return points;
    }

    private void testWithNPointsAndQQueries(int N,int Q){
        List<Point> points=randomPoints(N);
        NaivePointSet nps=new NaivePointSet(points);
        KDTree kd=new KDTree(points);

        List<Point> queries =randomPoints(Q);

        for(Point p:queries){
            Point expected=nps.nearest(p.getX(),p.getY());
            Point actual=kd.nearest(p.getX(),p.getY());
            assertEquals(expected,actual);
        }
    }


    @Test
    public void randomTestNearst1000to100(){
        testWithNPointsAndQQueries(20000,1000);



    }


    @Test
    public void randomTestNearst1000000to103000(){
        testWithNPointsAndQQueries(20000,1000);



    }



}
