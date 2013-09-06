package test.com.joezack.algorithms.quickunion;

import com.joezack.algorithms.percolation.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GridAdapterTest {
    private GridAdapter adapter;
    private static final int size = 100;

    @Before
    public void setUp() {
        adapter = new GridAdapter(size);
    }

    @Test
    public void firstIndex() {
        int expected = 0;
        int actual = adapter.coordinatesToIndex(0, 0);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void lastIndex() {
        int expected = size * size - 1;
        int actual = adapter.coordinatesToIndex(size - 1, size - 1);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void middleIndex() {
        int expected = 403;
        int actual = adapter.coordinatesToIndex(3,4);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void invalidMinIndex() {
        int expected = IGridAdapter.InvalidIndex;
        int actual = adapter.coordinatesToIndex(-1, 0);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void invalidMaxIndex() {
        int expected = IGridAdapter.InvalidIndex;
        int actual = adapter.coordinatesToIndex(0, size);
        Assert.assertEquals(expected,actual);
    }
}
