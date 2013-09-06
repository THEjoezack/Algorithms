package com.joezack.algorithms.percolation;

import com.joezack.algorithms.quickunion.QuickUnion;
import java.util.Random;

public class MonteCarloSimulation {

    public static void main(String[] args)  {
        int size = 100;
        int simulationCount = 100;

        for(int x = 0; x < simulationCount; x++) {
            int count = run(size);
            double percent = (double)count / (size * size);
            System.out.println(percent * 100.0 + "%");
        }
    }

    private static int run(int size) {
        int count = 0;

        IGridAdapter adapter = new GridAdapter(size);
        IPercolation p = new Percolation(size, adapter, new QuickUnion(size * size));
        Random generator = new Random();

        while(!p.percolates()) {
            int index = generator.nextInt(size * size);
            int i = adapter.indexToI(index);
            int j = adapter.indexToJ(index);
            if(!p.isOpen(i,j)) {
                count++;
                p.open(i,j);
            }
        }

        return count;
    }


}