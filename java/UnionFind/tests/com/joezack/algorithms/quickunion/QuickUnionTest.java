package com.joezack.algorithms.quickunion;

import org.junit.Before;

public class QuickUnionTest extends UnionFindTest {
    @Before
    public void setUp() {
        finder = new QuickUnion(10);
    }
}
