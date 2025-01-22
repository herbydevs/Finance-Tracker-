
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class dataManager{
    //reading the csv file
    public static void readCSV() {
        String filePath = "data.csv"; // CSV file name

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { //try catch yk this already
            String line; // no idea what this does i stole it
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Split by comma

                // Print row with tab spacing
                for (String value : values) {
                    System.out.print(value + "\t");
                }
                System.out.println(); // New line after each row
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
       
     }
    
}

    

        //writing to the csv file
    @SuppressWarnings("CallToPrintStackTrace") // not important adafa clearly
    public static void writeToCSV(String[] data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.csv", true))) { //try catch runs and throws a error if error
            // Convert data array to a CSV format row
            String row = String.join(",", data); // Join values with commas
            writer.write(row);                    // Write the row
            writer.newLine();                     // Move to the next line
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void seeBalance(){
       
        String filePath = "data.csv"; // CSV file name
        int columnIndex = 2; // Column index for "Amount" (zero-based)
        double sum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line; // still no idea what this does
            boolean isHeader = true; // something about the heading row i created earlier

            while ((line = br.readLine()) != null) { //while the first line is not null
                String[] values = line.split(",");

                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                try {
                    double value = Double.parseDouble(values[columnIndex]); // Convert to number
                    sum += value; // Add to sum
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid value: " + values[columnIndex]);
                }
            }
            System.out.println("Total Sum of Amount Column: " + sum);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }



}