package com.joezack.algorithms.percolation;

public interface IGridAdapter {
    int InvalidIndex = -1;

    int coordinatesToIndex(int i, int j);
    int indexToI(int index);
    int indexToJ(int index);
}
