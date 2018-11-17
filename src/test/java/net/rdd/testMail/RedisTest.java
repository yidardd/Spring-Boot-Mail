package net.rdd.testMail;

import net.rdd.common.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.Serializable;

/**
 * Created by rdd on 2018/11/16.
 */
public class RedisTest extends MainTest {
//    @Qualifier(value = "rddRedisTemplate")
//    private StringRedisTemplate rddRedisTemplate;

    @Autowired
    @Qualifier(value = "taskRedisTemplate")
    private RedisTemplate taskRedisTemplate;

    @Test
    public void test01(){

        try {

            final BASE64Encoder encoder = new BASE64Encoder();
            final BASE64Decoder decoder = new BASE64Decoder();
            final String text = "{\"buyer_nick\":\"丶劳资94灬神\",\"payment\":\"2.00\",\"status\":\"TRADE_FINISHED\",\"iid\":576601112865,\"oid\":267762403889391751,\"rater\":\"buyer\",\"tid\":267762403889391751,\"type\":\"guarantee_trade\",\"seller_nick\":\"apis2018\"}";
            final byte[] textByte = text.getBytes("UTF-8");
//编码
            final String encodedText = encoder.encode(textByte);
            taskRedisTemplate.opsForValue().set("EVALUATION|GOOD_EVALUATION|"+encodedText,"");
//解码
            System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));
        }catch (Exception e) {}
    }

    @Test
    public void test02() {

        Person p = new Person();
        p.setName("rdd");
        p.setPass("123");
        HashOperations hashOperations = taskRedisTemplate.opsForHash();
        hashOperations.put("2", "3",p);
    }


    }
