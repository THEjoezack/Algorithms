package com.joezack.algorithms.quickunion;

public abstract class UnionFind {
    public int[] getKeys() {
        return keys;
    }
    protected int[] keys;

    protected void initialize(int size) {
        int[] initialState = new int[size];
        for(int i = 0; i < size; i++) {
            initialState[i] = i;
        }
        keys = initialState;
    }
}
