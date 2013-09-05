package test.com.joezack.algorithms.quickunion;

import com.joezack.algorithms.quickunion.IUnionFind;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public abstract class UnionFindTest {

    protected IUnionFind finder;

    @Test
    public void keysInitialized() {
        int[] keys = finder.getKeys();

        Assert.assertEquals(keys[0], 0);
        Assert.assertEquals(keys[1], 1);
        Assert.assertEquals(keys[2], 2);
    }

    @Test
    public void connectReplacesAWithB() {
        finder.union(0,1);

        int[] keys = finder.getKeys();
        Assert.assertEquals(keys[0], 1);
        Assert.assertEquals(keys[1], 1);
    }

    @Test
    public void connectedIsReflexive() {
        boolean result = finder.connected(0,0);
        Assert.assertTrue(result);
    }

    @Test
    public void connectedIsSymmetric() {
        finder.union(0,9);

        boolean result = finder.connected(0,9) && finder.connected(9,0);
        Assert.assertTrue(result);
    }

    @Test
    public void connectedIsTransitive() {
        finder.union(0,1);
        finder.union(1,2);

        boolean result = finder.connected(0,2);
        Assert.assertTrue(result);
    }
}
