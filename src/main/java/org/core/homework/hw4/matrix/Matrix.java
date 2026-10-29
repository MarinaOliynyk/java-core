package org.core.homework.hw4.matrix;

import java.util.Random;

public class Matrix {
    public static String generateRandomString(Random random) {
        int stringLength = 7;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder reqString = new StringBuilder();

        for (int i = 0; i < stringLength; i++) {
            int index = random.nextInt(alphabet.length());
            reqString.append(alphabet.charAt(index));
        }
        return reqString.toString();
    }

    public static String generateRandomNumber(Random random) {
        int numberLength = 5;
        int randomFirstNumber = random.nextInt(10);
        StringBuilder req = new StringBuilder();
        req.append(randomFirstNumber).append(".");

        for (int i = 0; i < numberLength; i++) {
            int decimalDigit = random.nextInt(10);
            req.append(decimalDigit);
        }
        return req.toString();
    }

    public static void printMatrix(String[][] matrix) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%-10s", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
