package sample.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @CrossOrigin
    @GetMapping("/json")
    public String getJson() throws JsonProcessingException {
        SampleModel res = sampleService.getSample();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(res);
        return json;
    }
}