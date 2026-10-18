package org.core.homework.hw4.main;

import org.core.homework.hw4.matrix.Matrix;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String[][] matrix = new String[10][10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i * 10 + j) % 3 == 0) {
                    matrix[i][j] = Matrix.generateRandomNumber(random);
                } else {
                    matrix[i][j] = Matrix.generateRandomString(random);
                }
            }
        }

        String[] mainDiagonals = new String[10];
        String[] secondaryDiagonals = new String[10];
        boolean areDiagonalsEqual = true;
        for (int i = 0; i < 10; i++) {
            mainDiagonals[i] = matrix[i][i];
            secondaryDiagonals[i] = matrix[i][9 - i];
            if (!mainDiagonals[i].equals(secondaryDiagonals[i])) {
                areDiagonalsEqual = false;
            }
        }
        if (areDiagonalsEqual) {
            System.out.println("Диагонали совпадают");
        } else {
            System.out.println("Диагонали различаются");
        }

        String[] diagonals = new String[20];
        for (int i = 0; i < 10; i++) {
            diagonals[i] = mainDiagonals[i];
            diagonals[i + 10] = secondaryDiagonals[i];
        }

        StringBuilder sbString = new StringBuilder();
        StringBuilder sbNumber = new StringBuilder();

        for (String value : diagonals) {
            try {
                double number = Double.parseDouble(value);
                double fraction = number - Math.floor(number);
                long rounded = (fraction >= 0.7) ? (long) Math.ceil(number) : (long) Math.floor(number);
                sbNumber.append(rounded).append("_");
            } catch (NumberFormatException e) {
                String part = value.substring(1, 4);
                sbString.append(part).append(",");
            }
        }
        System.out.println(sbNumber);
        System.out.println(sbString);

        Matrix.printMatrix(matrix);
    }
}


