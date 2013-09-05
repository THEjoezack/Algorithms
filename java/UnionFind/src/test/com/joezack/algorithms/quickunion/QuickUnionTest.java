package test.com.joezack.algorithms.quickunion;

import com.joezack.algorithms.quickunion.QuickUnion;
import org.junit.Before;

public class QuickUnionTest extends UnionFindTest {
    @Before
    public void setUp() {
        finder = new QuickUnion(10);
    }
}
