import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CLASS TO READ THE FILE AND ADD THE SYMPTOMS IN AN ARRAYLIST
 *
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

    /**
     *
     * @param filepath
     * @return an ArrayList of all Symptoms obtained from a data source, duplicates are possible/probable
     */

    @Override
    public List<String> getSymptoms(String filepath) {
        List<String> result = new ArrayList<>();

        if (filepath != null) {
            try {
                BufferedReader reader = new BufferedReader (new FileReader(filepath));
                String line = reader.readLine();

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}


