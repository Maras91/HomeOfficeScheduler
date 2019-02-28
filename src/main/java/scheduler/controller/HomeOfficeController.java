package scheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import scheduler.csv.csvReader;
import scheduler.model.FieldNames;
import scheduler.model.HomeOfficeRecord;
import scheduler.repository.HomeOfficeRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        model.addAttribute("HomeOfficeRecords",homeOfficeRepository.findAll());
        return "index";
    }

    @PostMapping("/query")
    public String search (@RequestParam FieldNames field, String value, Model model) {
        List<HomeOfficeRecord> findPerson = new ArrayList<>();
        if (field==FieldNames.firstName) {
           findPerson = homeOfficeRepository.findByFirstName(value);
        }
        if (field==FieldNames.lastName) {
            findPerson = homeOfficeRepository.findByLastName(value);
        }
        if (field==FieldNames.dasId) {
            findPerson = homeOfficeRepository.findByDasId(value);
        }
        if (field==FieldNames.day) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            findPerson = homeOfficeRepository.findByDay(LocalDate.parse(value,dateFormat));
        }
        model.addAttribute("HomeOfficeRecords", findPerson);
        return "index";
    }
}
