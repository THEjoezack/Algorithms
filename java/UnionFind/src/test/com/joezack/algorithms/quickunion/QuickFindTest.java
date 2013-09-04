package test.com.joezack.algorithms.quickunion;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.joezack.algorithms.quickunion.QuickFind;

@RunWith(JUnit4.class)
public class QuickFindTest {
    @Test
    public void keysInitialized() {
        QuickFind finder = new QuickFind(3);
        int[] keys = finder.getKeys();

        Assert.assertEquals(keys[0], 0);
        Assert.assertEquals(keys[1], 1);
        Assert.assertEquals(keys[2], 2);
    }

    @Test
    public void connectReplacesAWithB() {
        QuickFind finder = new QuickFind(10);

        finder.union(0,1);

        int[] keys = finder.getKeys();
        Assert.assertEquals(keys[0], 1);
        Assert.assertEquals(keys[1], 1);
    }

    @Test
    public void connectedIsReflexive() {
        QuickFind finder = new QuickFind(10);
        boolean result = finder.connected(0,0);
        Assert.assertTrue(result);
    }

    @Test
    public void connectedIsSymmetric() {
        QuickFind finder = new QuickFind(10);

        finder.union(0,9);

        boolean result = finder.connected(0,9) && finder.connected(9,0);
        Assert.assertTrue(result);
    }

    @Test
    public void connectedIsTransitive() {
        QuickFind finder = new QuickFind(10);

        finder.union(0,1);
        finder.union(1,2);

        boolean result = finder.connected(0,2);
        Assert.assertTrue(result);
    }
}
