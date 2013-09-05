package test.com.joezack.algorithms.quickunion;

import com.joezack.algorithms.quickunion.QuickFind;
import org.junit.Before;

public class QuickFindTest extends UnionFindTest {
    @Before
    public void setUp() {
        finder = new QuickFind(10);
    }
}
