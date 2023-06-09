package org.dubiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

public class Matrix {
    private double[][] matrix;
    private final LinkedBlockingQueue<MultOp> multQueue;
    private final ThreadQueue threadQueue;

    public Matrix(double[]... matrix) {
        this.matrix = matrix;
        multQueue = new LinkedBlockingQueue<>();
        threadQueue = new ThreadQueue(4, multQueue);
    }

    public Matrix(int w, int h) {
        this(new double[h][w]);
    }

    public void add(double n) {
        for (double[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] += n;
            }
        }
    }

    public void add(double[][] m) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] += m[i][j];
            }
        }
    }

    public void subtract(double n) {
        add(-n);
    }

    public void subtract(double[][] m) {

    }

    public void multiply(double n) {

    }

    public void multiply(Matrix m) {
//        double[][] n = new double[matrix.length][m[0].length];
        double[][] cols = m.getCols();
//        ArrayList<MultOp> test = new ArrayList<>();
//        System.out.println(m);
//        System.out.println(Arrays.deepToString(cols));


        int count = 0;
        for (double[] row : matrix) {
            for (double[] col : cols) {
                multQueue.add(new MultOp(row, col, count++));
            }
        }

        threadQueue.start();
        while (threadQueue.getResult().size() != matrix.length * m.getMatrix()[0].length) {}

        threadQueue.stop();
        System.out.println("thread queue stopped");

//        threadQueue.getResult().forEach(System.out::println);
//        System.out.println(threadQueue.getResult().size());
//        System.out.println(test);
//        test.forEach(a -> System.out.println(a.calculate()));

    }


    public void divide(double n) {

    }

    public void divide(double[][] m) {

    }

    public void inverse() {

    }

    public void appendRow(double... row) {
        insertRow(matrix.length, row);
    }

    public void prependRow(double... row) {
        insertRow(0, row);
    }

    public void insertRow(int i, double... row) {
        if (row.length != matrix[0].length) {
            throw new IllegalArgumentException("Row length must be equal to the matrix row length");
        }
        matrix = Arrays.copyOf(matrix, matrix.length + 1);
        for (int j = matrix.length - 1; j > i; j--) {
            matrix[j] = matrix[j - 1];
        }
        matrix[i] = row;
    }

    public void appendCol(double... col) {
        insertCol(matrix[0].length, col);
    }

    public void prependCol(double... col) {
        insertCol(0, col);
    }

    public void insertCol(int i, double... col) {
        if (col.length != matrix.length) {
            throw new IllegalArgumentException("Column length must be equal to the matrix column length");
        }
        for (int j = 0; j < matrix.length; j++) {
            matrix[j] = Arrays.copyOf(matrix[j], matrix[j].length + 1);
            for (int k = matrix[0].length - 1; k > i; k--) {
                matrix[j][k] = matrix[j][k - 1];
            }
            matrix[j][i] = col[j];
        }
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public double[][] getCols() {
        double[][] cols = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                cols[j][i] = matrix[i][j];
            }
        }
        return cols;
    }

    @Override
    public String toString() {
        return "Matrix {\n" +
                Arrays.deepToString(matrix).replace("],", "\n").replace(",", "\t")
                        .replaceAll("[\\[\\]]", " ")
                + "\n}";
    }
}
