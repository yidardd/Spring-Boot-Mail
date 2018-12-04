package net.rdd.testMail;

import com.google.common.io.Files;
import net.rdd.common.Person;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

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
    public void test01() {

        try {

            final BASE64Encoder encoder = new BASE64Encoder();
            final BASE64Decoder decoder = new BASE64Decoder();
            final String text = "{\"buyer_nick\":\"丶劳资94灬神\",\"payment\":\"2.00\",\"status\":\"TRADE_FINISHED\",\"iid\":576601112865,\"oid\":267762403889391751,\"rater\":\"buyer\",\"tid\":267762403889391751,\"type\":\"guarantee_trade\",\"seller_nick\":\"apis2018\"}";
            final byte[] textByte = text.getBytes("UTF-8");
//编码
            final String encodedText = encoder.encode(textByte);
            taskRedisTemplate.opsForValue().set("EVALUATION|GOOD_EVALUATION|" + encodedText, "");
//解码
            System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));
        } catch (Exception e) {
        }
    }

    @Test
    public void test02() {

        long bef = System.currentTimeMillis();
        File banner = new File("C:\\Users\\My\\Desktop\\file\\20w2.txt");
        List<String> list = null;
        try {
            list = Files.readLines(banner, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        long aft = System.currentTimeMillis();
        for (String  s:
             list) {
            taskRedisTemplate.opsForValue().set(s, s);
        }
    }

    @Test
    public void test03() {

        String redisKey = "SMS_LIMIT_32";
        long count = taskRedisTemplate.opsForValue().increment(redisKey, 1);
        long bef = System.currentTimeMillis();
         count = taskRedisTemplate.opsForValue().increment(redisKey, 1);
        long after = System.currentTimeMillis();

        System.out.println("插入时间:"+(after-bef));

        count = taskRedisTemplate.opsForValue().increment(redisKey, 1);

        taskRedisTemplate.opsForValue().set("rdd:2131","rdd:2131");
        taskRedisTemplate.opsForValue().set("rdd:2132321","rdd:2131");
        taskRedisTemplate.opsForValue().set("rdd:2134321","rdd:2131");
        taskRedisTemplate.opsForValue().set("rdd:2134321","rdd:2131");

        if (count == 1) {
            //设置有效期一分钟
            taskRedisTemplate.expire(redisKey, 60, TimeUnit.SECONDS);
        }
        if (count > 1) {
            System.out.println(1231);
            return;
        }

    }

    @Test
    public void test04() {

        Set<String> keys = taskRedisTemplate.keys("task.sync.group*");
        Set<String>  keys1 = taskRedisTemplate.keys("task.sync.item*");
        Set<String> keys2 = taskRedisTemplate.keys("task.sync.shop*");
        for (String key:
             keys) {
            System.out.println("对应的:"+key);
        }
        taskRedisTemplate.delete(keys);
        taskRedisTemplate.delete(keys1);
        taskRedisTemplate.delete(keys2);


    }

    @Test
    public void test05(){
        taskRedisTemplate.opsForValue().set("rdd:2131","rdd:2131",10,TimeUnit.SECONDS);
        taskRedisTemplate.opsForValue().set("rdd:2132321","rdd:2131",10,TimeUnit.SECONDS);
        taskRedisTemplate.opsForValue().set("rdd:2134fds321","rdd:2131",10,TimeUnit.SECONDS);
        taskRedisTemplate.opsForValue().set("rdd:2134321","rdd:2131",10,TimeUnit.SECONDS);

        Set<String> keys = taskRedisTemplate.keys("rdd:*");
        for (String key:
                keys) {
            System.out.println("对应的:"+key);
        }
        Long delete = taskRedisTemplate.delete(keys);

    }

}
