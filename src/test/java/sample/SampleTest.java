package sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;
import sample.model.SampleModel;
import sample.repository.SampleRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SampleRepository sampleRepository;

    @Test
    public void basic() {
        stringRedisTemplate.opsForValue().set("my_key", "my_val");
        System.out.println(stringRedisTemplate.opsForValue().get("my_key"));
    }

    @Test
    public void jsonTest() throws JsonProcessingException {
        SampleModel res = sampleRepository.getSample();
        ArrayList<SampleModel> reses = new ArrayList();
        ArrayList resea; resea = new ArrayList();
        reses.add(res);
        Collection<SampleModel> col = Collections.unmodifiableCollection(reses);
        resea.add(col);
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(resea);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setHashKeySerializer(redisTemplate.getKeySerializer());
        redisTemplate.setHashValueSerializer(redisTemplate.getValueSerializer());
        redisTemplate.opsForValue().set("json_key", json);
        System.out.println(stringRedisTemplate.opsForValue().get("json_key"));
    }
}
