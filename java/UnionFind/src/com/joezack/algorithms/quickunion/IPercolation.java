package com.joezack.algorithms.quickunion;

public interface IPercolation {

    /**
     * Open site (row i, column j) if it is not already
     * @param i
     * @param j
     */
    public void open(int i, int j);

    /**
     * Is site (row i, column j) open?
     * @param i
     * @param j
     * @return
     */
    public boolean isOpen(int i, int j);

    /**
     * Is site (row i, column j) full?
     * @param i
     * @param j
     * @return
     */
    public boolean isFull(int i, int j);

    /**
     * Does the system percolate?
     * @return
     */
    public boolean percolates();
}
