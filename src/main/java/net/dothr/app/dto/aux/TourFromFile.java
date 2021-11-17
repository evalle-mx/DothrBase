package net.dothr.app.dto.aux;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
//import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Demo from exploreCali
 * @author 
 *
 */
public class TourFromFile {

	String title;
    String packageName;
    Map<String, String> details;

    public TourFromFile(Map<String, String> record) {
        this.title =  record.get("title");
        this.packageName = record.get("packageType");
        this.details = record;
        this.details.remove("packageType");
        this.details.remove("title");
    }
    
    //reader
    static List<TourFromFile> read(String fileToImport) throws IOException {
    	/*/Codigo para leer como MAP (MongoDB)
    	System.out.println("Reading from file " + fileToImport + " to map as List<Map<String, String>>");
        List<Map<String, String>> records = new ObjectMapper().setVisibility(FIELD, ANY).
                readValue(new FileInputStream(fileToImport),
                        new TypeReference<List<Map<String, String>>>() {});
        return records.stream().map(TourFromFile::new)
                .collect(Collectors.toList()); //*/
    	return new ObjectMapper().setVisibility(FIELD, ANY).
                readValue(new FileInputStream(fileToImport), new TypeReference<List<TourFromFile>>() {});
    }

    public String getTitle() {
        return title;
    }

    public String getPackageName() {
        return packageName;
    }

    public Map<String, String> getDetails() {
        return details;
    }
}
