package scheduler.csv;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import scheduler.model.HomeOfficeRecord;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataBaseSender {

    public List<HomeOfficeRecord> getHomeOfficeRecordFromFile(String filename) throws IOException{
        String data = readCsvFile(filename);
        List<String> records = Arrays.asList(data.split("\r\n"));
        return records.stream().map(record -> {
            String[] fields = record.split(",");
            return new HomeOfficeRecord(Long.getLong(fields[0]),fields[1],fields[2],fields[3]);
        }).collect(Collectors.toList());

    }
    private String readCsvFile (String fileName) throws IOException {
        InputStream inputStream = DataBaseSender.class.getResourceAsStream(fileName);
        return IOUtils.toString(inputStream, "UTF-8");
    }
}
