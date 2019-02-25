package scheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import scheduler.csv.csvReader;
import scheduler.model.HomeOfficeRecord;
import scheduler.repository.HomeOfficeRepository;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeOfficeController {

    @Autowired
    private HomeOfficeRepository homeOfficeRepository;

    @Value("${csv.file.name}")
    private String fileName;

    @Autowired
    private csvReader csvReader;

    @PostMapping("/showAll")
    public String getAllHO(Model model) {
        model.addAttribute("HomeOfficeRecords",homeOfficeRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addRecords (Model model) throws IOException {
        List<HomeOfficeRecord> homeOfficeRecords = csvReader.getHomeOfficeRecordFromFile(fileName);
        homeOfficeRepository.saveAll(homeOfficeRecords);
        return "index";
    }
}
