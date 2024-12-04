package AdaptivePattern;

import java.io.*;
import java.util.*;

public class csvReader {

    /**
     * Main method to test CSV reading.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Stanley\\Desktop\\ibraRY TEAM BASE\\data\\LegacyCollectionFodder - Sheet1.csv"; // Adjust this path as needed
        
        // Read CSV data
        List<String[]> data = readCSV(filePath); 
        
        // Print out the data
        for (String[] row : data) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * Reads a CSV file and returns its contents as a list of string arrays.
     *
     * @param filePath The file path to the CSV file.
     * @return A list of string arrays representing rows in the CSV file.
     */
    public static List<String[]> readCSV(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // Read each line of the CSV file
            while ((line = br.readLine()) != null) {
                // Split the line by commas and add it to the list
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
