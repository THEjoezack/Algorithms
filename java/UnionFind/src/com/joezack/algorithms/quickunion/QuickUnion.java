package com.joezack.algorithms.quickunion;

public class QuickUnion extends UnionFind implements IUnionFind {

    public QuickUnion(int size) {
        initialize(size);
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