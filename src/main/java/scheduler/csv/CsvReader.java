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
public class CsvReader {

    public List<HomeOfficeRecord> getHomeOfficeRecordFromFile(String filename, String dataFormat) throws IOException{
        String data = readCsvFile(filename);
        List<String> records = Arrays.asList(data.replace("\r","").split("\n"));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dataFormat);

        return records.stream().map(record -> {
            String[] fields = record.split(",");
            return new HomeOfficeRecord(fields[0],LocalDate.parse(fields[1],dateFormatter),fields[2],fields[3],fields[4]);
        }).collect(Collectors.toList());

    }
    private String readCsvFile (String fileName) throws IOException {
        InputStream inputStream = CsvReader.class.getResourceAsStream(fileName);
        return IOUtils.toString(inputStream, "UTF-8");
    }
}
