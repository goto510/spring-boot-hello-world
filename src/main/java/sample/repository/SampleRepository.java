package sample.repository;

import org.springframework.stereotype.Component;
import sample.model.SampleModel;

@Component
public class SampleRepository {

    public SampleModel getSample() {
        SampleModel sampleModel = new SampleModel();
        sampleModel.setId(1);
        sampleModel.setName("hoge wourld");
        return sampleModel;
    }
}
