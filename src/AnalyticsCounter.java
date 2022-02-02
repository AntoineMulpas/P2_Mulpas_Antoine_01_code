import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {


    public static void main(String[] args) throws Exception {
        ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        analyticsCounter.writeFile(
                analyticsCounter.sortSymptoms(
                        readSymptomDataFromFile.getSymptoms("src/symptoms.txt")));
    }


    public Map<String, Integer> sortSymptoms(List<String> readSymptomDataFromFile) {
        Map<String, Integer> sortedSymptoms = new TreeMap<>();

        for (String s : readSymptomDataFromFile) {
            sortedSymptoms.putIfAbsent(s, 0);
            sortedSymptoms.put(s, sortedSymptoms.get(s) + 1);
        }
        System.out.println(sortedSymptoms);
        return sortedSymptoms;
    }


    public void writeFile(Map<String, Integer> sortedSymptoms) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("results.out.txt"));
        for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue());
            writer.newLine();
        }
        writer.close();
    }


}