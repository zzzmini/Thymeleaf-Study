package my.app.first_Project.controller;

import my.app.first_Project.dto.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    @GetMapping("/userForm")
    public String showForm() {
        return "/form/basicForm";
    }

    @GetMapping("/sendData")
    public String sendData(
            UserInfo info,
            Model model
    ) {
        model.addAttribute("nickname", info.getNickname());
        model.addAttribute("email", info.getEmail());
        return "/form/returnForm";
    }

    @PostMapping("/sendData")
    public String sendPostData(
            UserInfo info,
            Model model) {
        System.out.println(info);
        model.addAttribute("nickname", info.getNickname());
        model.addAttribute("email", info.getEmail());
        return "/form/returnForm";
    }

    @GetMapping("viewData")
    public String viewData(Model model) {
        UserInfo user = new UserInfo();
        user.setNickname("원영이");
        user.setEmail("yong@ive.com");
        model.addAttribute("user", user);
        return "/form/basicForm";
    }

//    @PostMapping("/sendData")
//    public String sendPostData(
//            @RequestParam("nickname")String nickname,
//            @RequestParam("email")String email,
//            Model model
//    ) {
//        model.addAttribute("nickname", nickname);
//        model.addAttribute("email", email);
//        return "/form/returnForm";
//    }
}
