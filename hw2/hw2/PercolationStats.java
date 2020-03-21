package hw2;

import edu.princeton.cs.introcs.StdRandom;

public class PercolationStats {


    private int lengthOfArray;
    private int computeTimes;
    private  int[] openSites;
    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf){
        lengthOfArray=N;
        computeTimes=T;
        openSites=new int[T];
        for(int i=0;i<T;i++){
            openSites[i]=computePercolation(pf.make(N),N);
        }

    }

   private int computePercolation(Percolation abs,int N){
        while (!abs.percolates()){
            int a= StdRandom.uniform(0,N*N);
            int row=a/N;
            int column=a%N;
            abs.open(row,column);
        }
        return abs.numberOfOpenSites();

    }

    // sample mean of percolation threshold
    public double mean(){
        int sum=0;
        for(int i=0;i<openSites.length;i++){
            sum+=openSites[i];
        }
        return sum/(double)openSites.length;

    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        double sum=0;
        for(int i=0;i<openSites.length;i++){
            sum+=Math.pow(openSites[i]-mean(),2);
        }
        return Math.sqrt(sum/(openSites.length-1));
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow(){

        return mean()-1.96*stddev()/Math.sqrt(openSites.length);

    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh(){
        return mean()+1.96*stddev()/Math.sqrt(openSites.length);
    }

}
