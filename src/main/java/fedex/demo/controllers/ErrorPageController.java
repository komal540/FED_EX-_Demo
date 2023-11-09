package fedex.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPageController {
    @GetMapping("/errorPage")
    public String showErrorPage(){
        return "errorPage";
    }
}
