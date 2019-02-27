package scheduler.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        model.addAttribute("HomeOfficeRecords",homeOfficeRepository.findAll());
        return "index";
    }

    @PostMapping("/query")
    public String search (@RequestParam String lastName, Model model) {
        List<HomeOfficeRecord> findPerson = homeOfficeRepository.findByLastName(lastName);
        model.addAttribute("HomeOfficeRecords",findPerson);
//        SessionFactory sessionFactory = new Configuration()
//                .addClass(HomeOfficeRecord.class)
//                .setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect")
//                .setProperty("hibernate.connection.datasource", "jdbc:h2:file:~/test")
//                .setProperty("hibernate.order_updates", "true")
//                .buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Query query = session.createQuery("FROM Home_Office where :field = :value ");
//        query.setParameter("field",field);
//        query.setParameter("value",value);
//        List<HomeOfficeRecord> searchRecords = query.list();
//        model.addAttribute("HomeOfficeRecords",searchRecords);
        return "index";
    }
}
