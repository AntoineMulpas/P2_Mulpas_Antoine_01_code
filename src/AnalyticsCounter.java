import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Contains the main method
 * Sorts the symptoms using TreeMap and produce the output
 */

public class AnalyticsCounter {

/**
 * Main method, uses Object-Oriented Programming Principles
 */
    public static void main(String[] args) throws Exception {
        ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        analyticsCounter.writeFile(
                analyticsCounter.sortSymptoms(
                        readSymptomDataFromFile.getSymptoms("src/symptoms.txt")));
    }

    /**
     *
     * @param readSymptomDataFromFile
     * @return a TreeMap of symptoms which are sorted by alphabetic order, without duplicate
     */
    public Map<String, Integer> sortSymptoms(List<String> readSymptomDataFromFile) {
        Map<String, Integer> sortedSymptoms = new TreeMap<>();

        for (String s : readSymptomDataFromFile) {
            sortedSymptoms.putIfAbsent(s, 0);
            sortedSymptoms.put(s, sortedSymptoms.get(s) + 1);
        }
        System.out.println(sortedSymptoms);
        return sortedSymptoms;
    }

    /**
     * Write the output in a text file.
     * @param sortedSymptoms
     * @throws IOException
     */
    public void writeFile(Map<String, Integer> sortedSymptoms) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("results.out.txt"));
        for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue());
            writer.newLine();
        }
        writer.close();
    }
}