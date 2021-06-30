package com.shantalia.BabyNames;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabyNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the year 2001-2010");
        String year = sc.next();
        System.out.print("Enter the gender");
        String gender = sc.next();
        System.out.print("Enter the name");
        String name = sc.next();
        //close the scanner object
        sc.close();
        //create a file object and open the input file
        File infile = new File("babynameranking" + year + ".txt");
        if (!infile.exists()) {
            System.out.println("no record for " + year);
            System.exit(1);
        }
        int rank = 0;
        try {
            Scanner in = new Scanner(infile);
            while (in.hasNext()) {
                String line = in.nextLine();
                String[] details = line.split("\t");

                if (gender.equalsIgnoreCase("M") && details[1].contains(name))
                    rank = new Integer(details[0]);

                else if (details[3].contains(name))
                    rank = new Integer(details[0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (rank == 0) {
            System.out.println("The name " + name + "is not ranked in year " + year);

        } else {
            System.out.println(name + "is ranked # " + rank + "in year" + year);
        }
    }
}


