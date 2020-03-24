import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solver for the Flight problem (#9) from CS 61B Spring 2018 Midterm 2.
 * Assumes valid input, i.e. all Flight start times are >= end times.
 * If a flight starts at the same time as a flight's end time, they are
 * considered to be in the air at the same time.
 */
public class FlightSolver {
    ArrayList<Flight> flights;

    public FlightSolver(ArrayList<Flight> flights) {
        /* FIX ME */
        this.flights=flights;
    }

    public int solve() {
        /* FIX ME */
        PriorityQueue<Flight> minStartTime=new PriorityQueue<>(new ComparatorStartTime());
        PriorityQueue<Flight> minEndTime=new PriorityQueue<>(new ComparatorEndTime());
        for(int i=0;i<flights.size();i++){
            minEndTime.add(flights.get(i));
            minStartTime.add(flights.get(i));
        }

        int pre=0;
        int count=0;
        while (!minStartTime.isEmpty()){
            if(minStartTime.peek().startTime<minEndTime.peek().endTime()) {
                count += minStartTime.remove().passengers;
                if(count>pre)
                    pre=count;
            }
            else if(minStartTime.peek().startTime>minEndTime.peek().endTime){
                count-=minEndTime.remove().passengers;
            }
        }
        return pre;

    }



    private class ComparatorStartTime implements java.util.Comparator<Flight>{
        /**
         * Compares its two arguments for order. Returns a negative integer,
         * zero, or a positive integer as the first argument is less than,
         * equal to, or greater than the second.
         * */
        @Override
        public int	compare(Flight o1, Flight o2){
            return o1.startTime-o2.startTime;
        }
    }

    private class ComparatorEndTime implements Comparator<Flight>{
        /**
         * Compares its two arguments for order. Returns a negative integer,
         * zero, or a positive integer as the first argument is less than,
         * equal to, or greater than the second.
         * */
        @Override
        public int	compare(Flight o1, Flight o2){
            return o1.endTime-o2.endTime;
        }
    }
}
