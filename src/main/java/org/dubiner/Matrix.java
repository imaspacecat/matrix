package org.dubiner;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class IntMatrix extends Matrix<Integer> {

    public IntMatrix(Integer[][] matrix) {
        super(matrix);
    }

    public IntMatrix(int[][] matrix) {
        super(matrix);
    }

    @Override
    public void add(Integer n) {
        for (Integer[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] += n;
            }
        }
    }

    @Override
    public void add(Integer[][] m) {
        for (Integer[] rowM : m) {
            for (Integer integer : rowM) {
                for (Integer[] row : matrix) {
                    for (int j = 0; j < row.length; j++) {
                        row[j] += integer;
                    }
                }
            }
        }
    }

    @Override
    public void subtract(Integer n) {

    }

    @Override
    public void subtract(Integer[][] m) {

    }

    @Override
    public void multiply(Integer n) {

    }

    @Override
    public void multiply(Integer[][] m) {

    }

    @Override
    public void divide(Integer n) {

    }

    @Override
    public void divide(Integer[][] m) {

    }

    @Override
    public void inverse() {

    }
}
