import org.junit.Assert;
import org.junit.Test;

public class TestUnionFind {

    @Test
    public void Test(){
        UnionFind a=new UnionFind(10);
        a.union(0,1);
        a.union(2,3);
        a.union(4,5);
        a.union(6,7);
        a.union(8,9);
        a.union(1,3);

        Assert.assertTrue(a.connected(1,2));
        Assert.assertFalse(a.connected(9,1));
    }
}
