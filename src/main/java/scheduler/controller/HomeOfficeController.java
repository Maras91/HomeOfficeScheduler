package scheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import scheduler.csv.DataBaseSender;
import scheduler.model.HomeOfficeRecord;
import scheduler.repository.HomeOfficeRepository;

import java.io.IOException;
import java.util.List;

@RestController
public class HomeOfficeController {

    @Autowired
    private HomeOfficeRepository homeOfficeRepository;

    @Value("${csv.file.name}")
    private String fileName;

    @Autowired
    private DataBaseSender dataBaseSender;

    @GetMapping("/allho")
    public List<HomeOfficeRecord> getAllHO() {
        return homeOfficeRepository.findAll();
    }

    @GetMapping("/add")
    public void addRecords () throws IOException {
        List<HomeOfficeRecord> homeOfficeRecords = dataBaseSender.getHomeOfficeRecordFromFile(fileName);
        homeOfficeRepository.saveAll(homeOfficeRecords);
    }
}
