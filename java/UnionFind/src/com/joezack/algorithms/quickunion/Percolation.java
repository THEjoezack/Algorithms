package com.joezack.algorithms.quickunion;

public class Percolation implements IPercolation {
    private int size;
    private IGridAdapter adapter;
    private status sites[];
    private IUnionFind finder;

    private enum status {
        Open,
        Full
    }

    public Percolation(int n, IGridAdapter gridAdapter) {
        size = n;
        adapter = gridAdapter;
        sites = new status[size * size];
        initializeSites();
    }

    @Override
    public void open(int i, int j) {
        int index = adapter.coordinatesToIndex(i, j);
        if(sites[index] == status.Open) {
            return;
        }

        sites[index] = status.Open;
        openNeighbor(index, i - 1, j);
        openNeighbor(index, i + 1, j);
        openNeighbor(index, i, j - 1);
        openNeighbor(index, i, j + 1);
    }

    @Override
    public boolean isOpen(int i, int j) {
        int index = adapter.coordinatesToIndex(i,j);
        return sites[index] == status.Open;
    }

    @Override
    public boolean isFull(int i, int j) {
        return !isOpen(i,j);
    }

    @Override
    public boolean percolates() {
        /// TODO: This could be better
        int bottomRow = size * (size - 1);
        int lastSite = size * size;
        for(int topIndex = 0; topIndex < size; topIndex++) {
           for(int bottomIndex = bottomRow; bottomIndex < lastSite; bottomIndex++) {
                return finder.connected(topIndex, bottomIndex);
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

    private void openNeighbor(int index, int i, int j) {
        int neighbor = adapter.coordinatesToIndex(i,j);
        openNeighbor(index, neighbor);
    }

    private void openNeighbor(int index, int neighbor) {
        if(neighbor != adapter.InvalidIndex) {
            sites[neighbor] = status.Open;
            finder.union(index, neighbor);
        }
    }

}
