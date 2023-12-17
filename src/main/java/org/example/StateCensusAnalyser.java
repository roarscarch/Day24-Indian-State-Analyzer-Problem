package org.example;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


public class StateCensusAnalyser {

    private  String filePath;

    public StateCensusAnalyser(String filePath) {
        this.filePath = filePath;
    }

    public Iterator<String[]> readFromFile() throws StateCensusException {
        List<String[]> records = new ArrayList<>();

        if (!filePath.endsWith(".csv")) {
            throw new StateCensusException("This is not a CSV format");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line= reader.readLine();
            if(line==null || !line.equals("SrNo,StateName,TIN,StateCode")){
                reader.close();
                throw new StateCensusException("Header Part is not correct");
            }

            while ((line = reader.readLine()) != null) {
                if (Stream.of("-", "_", ";").anyMatch(line::contains)) {
                    throw new StateCensusException("Wrong Delimiter");
                }

                String[] fields = line.split(",");
                records.add(fields);
            }
        } catch (IOException exception) {
            throw new StateCensusException("Error reading the file");
        }

        return records.iterator();
    }


    public int countOfRecords() {
        int count = 0;
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.readNext(); // Skip header
            while (reader.readNext() != null) {
                count++;
            }
        } catch (IOException | CsvValidationException exception) {
            throw new RuntimeException(exception);
        }
        return count;
    }
    public static String recordsToString(List<String[]> records) {
        StringBuilder result = new StringBuilder();
        for (String[] record : records) {
            for (String value : record) {
                result.append(value).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}