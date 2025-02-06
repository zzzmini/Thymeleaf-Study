package my.app.first_Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkController {
    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("name", "장원영");
        model.addAttribute("age", 21);
        return "link";
    }

    @GetMapping("/url")
    public String basicUrl(){
        return "/link/basicUrl";
    }
}
