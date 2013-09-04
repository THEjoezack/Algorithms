package com.joezack.algorithms.quickunion;

public class QuickFind implements IQuickUnion {

    @Override
    public int[] getKeys() {
        return keys;
    }
    private int[] keys;

    public QuickFind(int size) {
        int[] initialState = new int[size];
        for(int i = 0; i < size; i++) {
            initialState[i] = i;
        }
        keys = initialState;
    }

    @Override
    public void union(int a, int b) {
        int size = keys.length;
        for(int i = 0; i < size; i++) {
            if(keys[a] == keys[i]) {
                keys[i] = keys[b];
            }
        }
    }

    @Override
    public boolean connected(int a, int b) {
        return keys[a] == keys[b];
    }
}