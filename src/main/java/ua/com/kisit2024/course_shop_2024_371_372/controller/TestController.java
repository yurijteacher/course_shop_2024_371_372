package ua.com.kisit2024.course_shop_2024_371_372.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {


    @GetMapping("/")
    public String getPageHome(Model model){
        model.addAttribute("hello", "Hello Student!!");
        return "index3";
    }


    @GetMapping("/payment")
    public String getPagePayment(){
        return "payment";
    }

    @GetMapping("/delivery")
    public String getPageDelivery(){
        return "delivery";
    }

    @GetMapping("/login")
    public String getPageLogin(){
        return "login";
    }


}
