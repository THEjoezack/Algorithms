package test.com.joezack.algorithms.quickunion;

import com.joezack.algorithms.percolation.*;
import com.joezack.algorithms.quickunion.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PercolationTest {
    int size = 4;
    IPercolation target;

    @Before
    public void setUp() {
        IGridAdapter adapter = new GridAdapter(size); // TODO Cheating!!
        IUnionFind finder = new QuickFind(size * size); // TODO Cheating!!
        target = new Percolation(size,adapter,finder);
    }

    @Test
    public void open() {
        target.open(3,3);
        boolean actual = target.isOpen(3, 3);
        boolean expected = true;

        Assert.assertEquals("Self should be opened",expected,actual);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void openInvalidIndex() {
        target.open(size,size);
    }

    @Test
    public void isFullIndexOpen() {
        boolean expected = false;
        boolean actual = target.isOpen(3,3);
        Assert.assertEquals("Should initially be full", expected, actual);
    }

    @Test
    public void isOpenIndexOpen() {
        target.open(0,1);
        boolean expected = true;
        boolean actual = target.isOpen(0,1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isFullIndexFull() {
        boolean expected = true;
        boolean actual = target.isFull(3,3);
        Assert.assertEquals("Should initially be full", expected, actual);
    }

    @Test
    public void isOpenIndexFull() {
        target.open(3,3);
        boolean expected = false;
        boolean actual = target.isFull(3,3);
        Assert.assertEquals("Should initially be full", expected, actual);
    }

    @Test
    public void diagonalsDoNotPercolate() {
        target.open(0,0);
        target.open(1,1);
        target.open(2,2);
        target.open(3,3);
        Assert.assertEquals(false, target.percolates());
    }

    @Test
    public void verticalPercolates() {
        target.open(0,0);
        target.open(0,1);
        target.open(0,2);
        target.open(0,3);
        Assert.assertEquals(true, target.percolates());
    }

    @Test
    public void horizontalPercolates() {
        target.open(2,0);
        target.open(2,1);
        target.open(1,1);
        target.open(1,2);
        target.open(1,3);
        Assert.assertEquals(true, target.percolates());
    }
}
