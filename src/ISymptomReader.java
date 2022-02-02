import java.util.List;

/**
 READ SYMPTOMS FROM A FILE PASSED BY A STRING AS A PARAMETER
 */

public interface ISymptomReader {

    List<String> getSymptoms(String filepath);

    /**
     * If no data is available, return an empty List
     *
     * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
     */


}
