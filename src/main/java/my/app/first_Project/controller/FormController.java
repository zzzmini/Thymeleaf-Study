package my.app.first_Project.controller;

import my.app.first_Project.dto.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {
    //     처음 Form 로딩할때 바인딩 되어 있는 UserInfo Dto의
//    껍데기를 보냄.
    @GetMapping("/userForm")
    public String showForm(Model model) {
//        Map<String, String> map = favorite();
//        model.addAttribute("map", map);
        model.addAttribute("user", new UserInfo());
        return "/form/basicForm";
    }

    @ModelAttribute("hobbies")
    private Map<String, String> favorite() {
        Map<String, String> map = new HashMap<>();
        map.put("movie", "영화보기");
        map.put("music", "음악듣기");
        map.put("running", "런닝하기");
        map.put("game", "게임하기");
        return map;
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
            @ModelAttribute("user") UserInfo info,
            Model model) {
        System.out.println(info);
        model.addAttribute("info", info);

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
