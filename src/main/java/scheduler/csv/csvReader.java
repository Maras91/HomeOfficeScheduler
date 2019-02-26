package scheduler.csv;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import scheduler.model.HomeOfficeRecord;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class csvReader {

    public List<HomeOfficeRecord> getHomeOfficeRecordFromFile(String filename) throws IOException{
        String data = readCsvFile(filename);
        List<String> records = Arrays.asList(data.split("\r\n"));
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return records.stream().map(record -> {
            String[] fields = record.split(",");
            return new HomeOfficeRecord(fields[0],LocalDate.parse(fields[1],dateFormat),fields[2],fields[3],fields[4]);
        }).collect(Collectors.toList());

    }
    private String readCsvFile (String fileName) throws IOException {
        InputStream inputStream = csvReader.class.getResourceAsStream(fileName);
        return IOUtils.toString(inputStream, "UTF-8");
    }
}
