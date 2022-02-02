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


    @Override
    public List<String> GetSymptoms(String filepath) {
        ArrayList<String> result = new ArrayList<>();

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