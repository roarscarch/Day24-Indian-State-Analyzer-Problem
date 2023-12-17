package org.example;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws StateCensusException {
        String csvFilePath = "StateCensus.csv";

        System.out.println("Welcome to Indian States Census Analyser Problem");
        StateCensusAnalyser stateCensusAnalyser= new StateCensusAnalyser(csvFilePath);

        Iterator<String[]> allRecords = stateCensusAnalyser.readFromFile();

        while (allRecords.hasNext()) {
            String[] record = allRecords.next();

            for (String field : record) {
                System.out.print(field + " ");
            }
            System.out.println(); // Move to the next line after printing one record
        }

        int countRecordsOfCSVfile = stateCensusAnalyser.countOfRecords();
        System.out.println("Total Records: " + countRecordsOfCSVfile);
    }

}
