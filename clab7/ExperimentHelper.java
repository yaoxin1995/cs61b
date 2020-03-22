/**
 * Created by hug.
 */
public class ExperimentHelper {

    /** Returns the internal path length for an optimum binary search tree of
     *  size N. Examples:
     *  N = 1, OIPL: 0
     *  N = 2, OIPL: 1
     *  N = 3, OIPL: 2
     *  N = 4, OIPL: 4
     *  N = 5, OIPL: 6
     *  N = 6, OIPL: 8
     *  N = 7, OIPL: 10
     *  N = 8, OIPL: 13
     */
    public static int optimalIPL(int N) {
        int result=(int)(N*optimalAverageDepth(N));
        return result;
    }

    /** Returns the average depth for nodes in an optimal BST of
     *  size N.
     *  Examples:
     *  N = 1, OAD: 0
     *  N = 5, OAD: 1.2
     *  N = 8, OAD: 1.625
     * @return
     */
    public static double optimalAverageDepth(int N) {
        int height=log2(N);
        int nodeInDepthst=N;
        double optimalAverageDepth=0;
        for(double i=0.0;i<=height-1;i++){
            nodeInDepthst-=(int)Math.pow(2.0,i);
            optimalAverageDepth+=(int)Math.pow(2.0,i)*i;
        }
        optimalAverageDepth+=nodeInDepthst*height;
        return (optimalAverageDepth)/N;


    }


    /**
     * The Math.floor() function returns the largest integer less than or equal to a given number.
     * */
    public static final int log2(int f)
    {
        return (int)Math.floor(Math.log(f)/Math.log(2.0));
    }

    public static void getInt(BST<Integer> T){
        int temp = RandomGenerator.getRandomInt(10000);
        while(true){
            if(!T.contains(temp)){
                T.add(temp);
                break;
            }else{
                temp = RandomGenerator.getRandomInt(10000);
            }
        }
    }

    public static void deleteRandom(BST<Integer> test){
        int randomKey=test.getRandomKey();
        test.deleteTakingSuccessor(randomKey);
    }

}
