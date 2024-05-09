package com.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RecPow {
    /**
     * Calculates the power of numbers using recursion.
     *
     * This program reads input from a file named input.txt,
     * where each line contains the base and exponent separated by a space.
     * It then calculates the power for each line using the recursive function "power",
     * and writes the results to a file named output.txt.
     *
     * @author Tamer
     * @version 1.0
     * @since 2024-05-06
     */

    // Recursive function to calculate power
    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return base * power(base, exponent - 1);
        }
    }

    public static void main(String[] args) {
        try {
            // Open input file for reading
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);

            // Open output file for writing
            File outputFile = new File("output.txt");
            FileWriter writer = new FileWriter(outputFile);

            // Read input file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                try {
                    if (parts.length != 2) {
                        throw new IllegalArgumentException("Each line must contain exactly two integers separated by a space.");
                    }
                    int base = Integer.parseInt(parts[0]);
                    int exponent = Integer.parseInt(parts[1]);

                    // Calculating power using the recursive function
                    int result = power(base, exponent);

                    // Writing the result to output.txt
                    writer.write("Result for base " + base + " and exponent " + exponent + ": " + result + "\n");
                } catch (NumberFormatException e) {
                    writer.write("Error: Non-integer value found in the input.\n");
                } catch (IllegalArgumentException e) {
                    writer.write("Error: " + e.getMessage() + "\n");
                }
            }

            // Close scanner and writer
            scanner.close();
            writer.close();
            System.out.println("Results written to output.txt");

        } catch (IOException e) {
            // Handle IOException
            System.err.println("Error: " + e.getMessage());
        }
    }
}
