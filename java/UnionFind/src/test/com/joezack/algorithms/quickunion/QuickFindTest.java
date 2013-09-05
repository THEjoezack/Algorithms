package test.com.joezack.algorithms.quickunion;

import com.joezack.algorithms.quickunion.QuickFind;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class QuickFindTest extends UnionFindTest {
    @Before
    public void setUp() {
        finder = new QuickFind(10);
    }
}
