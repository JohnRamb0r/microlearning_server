package application.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/a")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}