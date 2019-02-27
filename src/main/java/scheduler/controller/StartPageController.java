package scheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import scheduler.repository.HomeOfficeRepository;

@Controller
public class StartPageController {

    @Autowired
    private HomeOfficeRepository homeOfficeRepository;

    @GetMapping("/")
    String getStartPage (Model model) {
        model.addAttribute("HomeOfficeRecords",homeOfficeRepository.findAll());
        return "index";
    }
}
