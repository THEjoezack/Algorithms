package com.joezack.algorithms.percolation;

import com.joezack.algorithms.quickunion.IUnionFind;

public class Percolation implements IPercolation {
    private int size;
    private IGridAdapter adapter;
    private status sites[];
    private IUnionFind finder;

    private enum status {
        Open,
        Full
    }

    public Percolation(int size, IGridAdapter adapter, IUnionFind finder) {
        this.size = size;
        this.adapter = adapter;
        this.finder = finder;

        sites = new status[size * size];
        initializeSites();
    }

    @Override
    public void open(int i, int j) throws IndexOutOfBoundsException {
        int index = adapter.coordinatesToIndex(i, j);
        if(index == adapter.InvalidIndex)
        {
            throw new IndexOutOfBoundsException("Invalid index given: " + i + " " + j);
        }

        if(sites[index] == status.Open) {
            return;
        }

        sites[index] = status.Open;
        connectNeighbor(index, i - 1, j);
        connectNeighbor(index, i + 1, j);
        connectNeighbor(index, i, j - 1);
        connectNeighbor(index, i, j + 1);
    }

    @Override
    public boolean isOpen(int i, int j) throws IndexOutOfBoundsException {
        int index = adapter.coordinatesToIndex(i,j);
        if(index == adapter.InvalidIndex)
        {
            throw new IndexOutOfBoundsException("Invalid index given: " + i + " " + j);
        }
        return sites[index] == status.Open;
    }

    @Override
    public boolean isFull(int i, int j) throws IndexOutOfBoundsException {
        return !isOpen(i,j);
    }

    @Override
    public boolean percolates() {
        /// TODO: This could be better
        int bottomRow = size * (size - 1);
        int lastSite = size * size;
        for(int topIndex = 0; topIndex < size; topIndex++) {
           for(int bottomIndex = bottomRow; bottomIndex < lastSite; bottomIndex++) {
               if(finder.connected(topIndex, bottomIndex))
               {
                   return true;
               }
            }
        }
        return false;
    }

    private void initializeSites() {
        int max = size * size;
        for(int i = 0; i < max; i++) {
            sites[i] = status.Full;
        }
    }

    private void connectNeighbor(int index, int i, int j) throws IndexOutOfBoundsException {
        if(index == adapter.InvalidIndex) {
            throw new IndexOutOfBoundsException("Index is invalid");
        }

        int neighborIndex = adapter.coordinatesToIndex(i,j);
        if(neighborIndex != adapter.InvalidIndex && isOpen(i,j)) {
            finder.union(index, neighborIndex);
        }
    }

}
