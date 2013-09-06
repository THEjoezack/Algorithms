package com.joezack.algorithms.percolation;

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

    @Override
    public int indexToI(int index) {
        return index % size;
    }

    @Override
    public int indexToJ(int index) {
        return index / size;
    }

    private boolean isValidIndex(int i, int j) {
        return i >= 0 && i < size && j >= 0 && j < size;
    }
}
