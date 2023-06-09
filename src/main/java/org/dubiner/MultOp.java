package org.dubiner;

public class Mult {
    private final double[] row;
    private final double[] col;

    public Mult(double[] row, double[] col) {
        this.row = row;
        this.col = col;
    }

    public double[] getRow() {
        return row;
    }

    public double[] getCol() {
        return col;
    }

    public double calculate() {
        double sum = 0;
        for (double i : row) {
            for (double j : col) {
                sum += i * j;
            }
        }
        return sum;
    }
}
