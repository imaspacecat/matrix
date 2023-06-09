package org.dubiner;

public class Main {
    public static void main(String[] args) {

        double[][] test = new double[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        };

        double[][] test2 = new double[][]{
                {12, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

//        Matrix a = new Matrix(3, 3);
//        a.appendRow(1, 41, 1);
//        System.out.println(a);
//        a.insertRow(0, 2, 2, 2);
//        System.out.println(a);
//        a.insertRow(2, 3, 3, 3);
//        System.out.println(a);
//
//        a.prependRow(6, 6, 6);
//        System.out.println(a);
//
//        a.insertCol(0, 21111, -1, 2, -1, -1, 2, -1);
//        System.out.println(a);
//
//        Matrix m = new Matrix(3, 2);
//        m.appendCol(1, 1);
//        System.out.println(m);
//        m.prependCol(2, 2);
//        System.out.println(m);
//        m.insertCol(2, 6, 6);
//        System.out.println(m);
//        m.add(1);
//        System.out.println(m);

        Matrix t = new Matrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        Matrix s = new Matrix(new double[][]{
                {7, 8},
                {9, 10},
                {11, 12}
        });

        Matrix d = new Matrix(1000, 1000);
        d.add(2);

        Matrix e = new Matrix(1000, 1000);
        e.add(3);




        long start = System.currentTimeMillis();
        d.multiply(e);
        long end = System.currentTimeMillis();
        System.out.println("millis: " + (end - start));


    }
}