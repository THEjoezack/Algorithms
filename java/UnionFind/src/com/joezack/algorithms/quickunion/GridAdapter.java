package com.joezack.algorithms.quickunion;

public class GridAdapter implements IGridAdapter {

    private int size;

    public GridAdapter(int n) {
        size = n;
    }

    @Override
    public int coordinatesToIndex(int i, int j) {
        if(!isValidIndex(i,j)) {
            return InvalidIndex;
        }
        return (j * size) + i;
    }

    private boolean isValidIndex(int i, int j) {
        return i >= 0 && i < size && j >= 0 && j < size;
    }
}
