package sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void basic() {
        redisTemplate.opsForValue().set("my_key", "my_val");
        System.out.println(redisTemplate.opsForValue().get("my_key"));
    }
}
