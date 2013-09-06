package com.joezack.algorithms.quickunion;

import org.junit.Before;

public class QuickFindTest extends UnionFindTest {
    @Before
    public void setUp() {
        finder = new QuickFind(10);
    }
}
