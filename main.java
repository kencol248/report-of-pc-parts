package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Program purpose: Generate a report of PC components and their total cost
 * @author Kenyah Collins
 * 4/12/2023
 */
public class Main {
    static final String INPUTFILE = "components.txt";
    static final String PRINTFFORMAT = "%20s %2d    %6.2f\n";
    public static void main(String[] args) {
    	double total = 0;
	    File infile = new File(INPUTFILE);
	    System.out.printf("%s%n","           Component Units Price");

    // add code that reads the input file
    try {
        Scanner input = new Scanner(infile);

       // Break up the String into its three components using the split() method
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] tokens = line.split(",");
            if (tokens.length != 3) {
                System.out.printf("Invalid input format: %s%n", line);
                continue;
            }
            String component = tokens[0];
            int units = 0;
            double price = 0;

            // determine for a given component, it’s # of units (int) and price (double). Use the Integer.parseInt()
            // and Double.parseDouble() methods to convert Strings to int and double respectively.
            try {
                units = Integer.parseInt(tokens[1].trim());
                price = Double.parseDouble(tokens[2].trim());
            } catch (NumberFormatException ex) {
                System.out.printf("Invalid input format: %s%n", line);
                continue;
            }
            // Calculate a running total cost using the # of units and the price of each component.
            // Print a line of output reporting each component, # of units, and price using the printf() method.
            double cost = units * price;
            total += cost;
            System.out.printf(PRINTFFORMAT, component, units, price);
        }
        input.close();

        // If the input file cannot be found, print an error message
    } catch (FileNotFoundException ex) {
        System.out.printf("Input file not found: %s%n", INPUTFILE);
    }
        // Print the total cost of PC components
	    System.out.println("Total cost: "+total);
    }
}
