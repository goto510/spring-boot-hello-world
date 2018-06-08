package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.model.SampleModel;
import sample.service.SampleService;

@RestController
public class Sample {

    @Autowired
    private SampleService sampleService;

    @CrossOrigin
    @GetMapping("/sample")
    public String getSample() {
        return "Hello world";
    }

    @CrossOrigin
    @GetMapping("/model")
    public String getModel() {
        SampleModel res = sampleService.getSample();
        return res.getName();
    }
}