package my.app.first_Project.controller;

import my.app.first_Project.dto.Animal;
import my.app.first_Project.dto.Fruits;
import my.app.first_Project.dto.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
public class ThymeleafController {
    //     http://localhost:8080/basic/text-basic
    @GetMapping("text-basic")
    public String textBasic(Model model) {
        model.addAttribute("name", "안유진");
        model.addAttribute("mylove", "형민이");
        return "/basic/text-basic";
    }

    @GetMapping("variables")
    public String variables(Model model) {

//        UserData userData = new UserData("장원영",
//                    20, "서울");
        UserData userData = new UserData();
        userData.setUserName("안유진");
        userData.setUserAge(22);
        userData.setUserAddress("제주");
//        UserData userData = new UserData("홍길동", 10);
        System.out.println(userData);
        model.addAttribute("userData", userData);
        model.addAttribute("data", "장원영");

//      리스트 작업하기
        List<Fruits> fruits = new ArrayList<>();
        Fruits apple = new Fruits("사과", "신맛");
        Fruits mango = new Fruits("망고", "노란맛");

        fruits.add(apple);
        fruits.add(mango);

        model.addAttribute("fruits", fruits);
        System.out.println(fruits);

//        맵으로 작업하기
        Map<String, Animal> animalMap = new HashMap<>();
        Animal dog = new Animal();
        dog.setName("멍멍이");
        dog.setSound("멍멍");

        Animal cat = new Animal();
        cat.setName("야옹이");
        cat.setSound("야옹");

        animalMap.put("dog", dog);
        animalMap.put("cat", cat);
        model.addAttribute("map", animalMap);
        return "/basic/variables";
    }
}
