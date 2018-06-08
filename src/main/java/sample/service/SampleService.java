package sample.service;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.model.SampleModel;
import sample.repository.SampleRepository;

@Component
@NoArgsConstructor
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    public SampleModel getSample() {
        return sampleRepository.getSample();
    }
}
