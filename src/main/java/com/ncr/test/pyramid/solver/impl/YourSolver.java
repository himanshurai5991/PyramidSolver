package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: This is your 3rd task.
 * Please implement the class to satisfy the interface. *
 */
public class YourSolver implements PyramidSolver {

    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        if (pyramid == null || pyramid.getRows() == 0) {
            return 0L;
        }

        final int rows = pyramid.getRows();
        long[] dp = new long[rows+1];

        for (int row = 0; row < rows; row++) {
            final int width = pyramid.getData()[row].length;
            for (int col = 0; col < width; col++) {
                dp[col] = Math.max(dp[col], dp[col + 1]) +pyramid.get(row, col);
            }
        }
        return dp[0];
    }
    
}
