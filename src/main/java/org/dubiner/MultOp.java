package org.dubiner;

import java.util.Arrays;

public class MultOp {
    private final double[] row;
    private final double[] col;
    private final int i;

    public MultOp(double[] row, double[] col, int i) {
        this.row = row;
        this.col = col;
        this.i = i;
    }

    public double[] getRow() {
        return row;
    }

    public double[] getCol() {
        return col;
    }

    public double calculate() {
        double sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i] * col[i];
        }
        return sum;
    }

    @Override
    public String toString() {
        return "MultOp{" +
                "row=" + Arrays.toString(row) +
                ", col=" + Arrays.toString(col) +
                ", i=" + i +
                '}';
    }
}
