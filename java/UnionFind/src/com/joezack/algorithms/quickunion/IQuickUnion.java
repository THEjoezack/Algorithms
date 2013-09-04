package com.joezack.algorithms.quickunion;

/**
 * Created with IntelliJ IDEA.
 * User: joe
 * Date: 9/4/13
 * Time: 7:49 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IQuickUnion {
    int[] getKeys();

    void union(int a, int b);

    boolean connected(int a, int b);
}
