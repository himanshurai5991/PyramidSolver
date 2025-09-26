package com.ncr.test.pyramid.solver;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.data.PyramidGenerator;
import com.ncr.test.pyramid.data.impl.RandomPyramidGenerator;
import com.ncr.test.pyramid.solver.impl.NaivePyramidSolver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NaivePyramidSolverTest {

    private static final int[][] SINGLE_VALUE = {
            { 42 }
    };

    private static final int[][] SAMPLE_DATA = {
            { 5, 9, 8, 4 },
            { 6, 4, 5, 0 },
            { 6, 7, 0, 0 },
            { 3, 0, 0, 0 }
    };

    private static final int[][] DEMO_DATA = {
            { 59, 207, 98, 95 },
            { 87,   1, 70,  0 },
            { 36,  41,  0,  0 },
            { 23,   0,  0,  0 }
    };

    private PyramidSolver solver;

    @Before
    public void setUp() {
        solver = new NaivePyramidSolver();
    }

    @Test
    public void solverHandlesSingleValuePyramid() {
        Pyramid pyramid = new Pyramid(SINGLE_VALUE);
        assertEquals("Max path for single value pyramid", 42L, solver.pyramidMaximumTotal(pyramid));
    }

    @Test
    public void solverHandlesSampleData() {
        Pyramid pyramid = new Pyramid(SAMPLE_DATA);
        assertEquals("Max path in Sample pyramid", 24L, solver.pyramidMaximumTotal(pyramid));
    }

    @Test
    public void solverHandlesDemoData() {
        Pyramid pyramid = new Pyramid(DEMO_DATA);
        assertEquals("Max path in Demo pyramid", 353L, solver.pyramidMaximumTotal(pyramid));
    }

    @Test
    public void solverHandlesRandomData() {
        RandomPyramidGenerator.setRandSeed(25321L);
        PyramidGenerator generator = new RandomPyramidGenerator(5, 99);
        Pyramid pyramid = generator.generatePyramid();

        assertEquals("Max path in 'random' pyramid", 398L, solver.pyramidMaximumTotal(pyramid));
    }

    @Test
    public void solverProducesPositiveTotalsForSmallRandomPyramids() {
        RandomPyramidGenerator.setRandSeed(5271L);
        PyramidGenerator generator = new RandomPyramidGenerator(6, 50);
        Pyramid pyramid = generator.generatePyramid();

        assertTrue("Max path should be positive", solver.pyramidMaximumTotal(pyramid) > 0L);
    }
}

