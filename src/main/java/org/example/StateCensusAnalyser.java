package org.example;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StateCensusAnalyser {

//    public static void writeToFile(String csvFilePath,String[][] data){
//        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))){
//            writer.writeNext(data[0]);
//            for(int i=1; i< data.length;i++){
//                writer.writeNext(data[i]);
//            }
//            System.out.println("Data Added");
//        } catch (IOException exception){
//            exception.printStackTrace();
//        }
//    }

    public static List<String[]> readFromFile(String filePath) {
        List<String[]> records = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext();
            // System.out.println(Arrays.toString(header));
            String[] line;

            while ((line = reader.readNext()) != null) {
                records.add(line);
            }
        } catch (IOException | CsvValidationException exception) {
            throw new RuntimeException(exception);
        }

        return records;
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

    public static void main(String[] args) {
        String csvFilePath = "StateCensus.csv";

        System.out.println("Welcome to Indian States Census Analyser Problem");
        List<String[]> allRecords = readFromFile(csvFilePath);

        System.out.println(recordsToString(allRecords));


    }
}