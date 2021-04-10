package com.mariusmihai.licenta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Utils {

    public static void writeInFile(FileInput fileInput) {

        try (PrintWriter printWriter = new PrintWriter(new File("licenta.in"))) {
            printWriter.write(fileInput.getK() + "\n");
            printWriter.write(fileInput.getN() + "\n");

            fileInput.getS().forEach(interval -> printWriter.write(interval.getX() + " " + interval.getY() + "\n"));

            printWriter.write(fileInput.getM() + "\n");

            fileInput.getT().forEach(interval -> printWriter.write(interval.getX() + " " + interval.getY() + "\n"));

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        }
    }
}
