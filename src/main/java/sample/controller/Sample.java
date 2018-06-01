package sample.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sample {

    @CrossOrigin
    @GetMapping("/sample")
    String sample() {
        return "Hello world";
    }
}