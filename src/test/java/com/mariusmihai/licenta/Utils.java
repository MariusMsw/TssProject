package com.mariusmihai.licenta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Utils {

    public static void writeInFile(int K, int N, List<Interval> S, int M, List<Interval> T) {

        try {
            PrintWriter printWriter = new PrintWriter(new File("licenta.in"));
            printWriter.write(K + "\n");
            printWriter.write(N + "\n");

            S.forEach(interval -> printWriter.write(interval.getX() + " " + interval.getY() + "\n"));

            printWriter.write(M + "\n");

            T.forEach(interval -> printWriter.write(interval.getX() + " " + interval.getY() + "\n"));

            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        }

    }
}
