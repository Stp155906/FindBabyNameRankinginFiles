package com.shantalia.BabyNames;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.module.FindException;
import java.util.Scanner;

public class Main {
    private static String[][] boyNames = new String[10][1000];
    private static String[][] girlNames = new String[10][1000];

    public static void readNames() throws FileNotFoundException {
        //Read all the files and load all the names from the files put the names inside boyNames and GirtNames
        String filename = "babynamesranking200";
        for (int i = 1; i < 11; i++) {
            if (i < 10) filename += i + ".txt";
            else {
                filename = "babynamesranking2010.txt";
            }
            File infile = new File(filename);
            try {
                Scanner input = new Scanner(infile);
                int j = 0;
                while (input.hasNext()) {
                    String line = input.nextLine();
                    String[] details = line.split("\\s");
                    String boy = details[2].trim();
                    String girl = details[5].trim();
                    boyNames[i - 1][j] = boy;// 2001 is 0 array etc
                    girlNames[i - 1][j] = girl;
                    j++;

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            filename = "babynamesranking200";
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readNames();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the year 2001-2010");
        int year = Integer.parseInt(sc.next());
        System.out.print("Enter the gender m or f");
        String gender = sc.next();
        System.out.print("Enter the a first name");
        String name = sc.next();
        sc.close();


        System.out.println(name+ " is ranked #     " + "babynameranking");
        year = (year - 2001);
        // 2001  % 2000 would leave remainder of 1 but 1 would be 2002 in the array, so we minus 1
        //iterate through the boys array to find the name

        if (gender.equalsIgnoreCase("m")) {
            for (int i = 0; i < boyNames[year].length; i++) {
                {
                    if (boyNames[year][i].equals(name)) {
                        System.out.println(name + "is ranked #" + year + 1);
                        //if statement to get the boyname and check if same as name entered;// boyNames[year][i]
                    } else if (gender.equals("f")) {
                        for (int k = 0; k < girlNames[year].length; k++) {
                            {
                                if (girlNames[year][k].equals(name)) {
                                    System.out.println(name + "is ranked #" + year + 1);
                                }
                            }
                        }
                         // 2001  % 2000 would leave remainder of 1 but 1 would be 2002 in the array, so we minus 1
                    }
                }
                }
            }
        }
    }







