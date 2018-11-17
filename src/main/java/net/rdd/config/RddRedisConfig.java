package net.rdd.config;

import net.rdd.spring.job.listener.TaskMessageListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.scripting.support.ResourceScriptSource;

@Configuration
public class RddRedisConfig {

    @Value("${redis.task.host}")
    private String redisHost;

    @Value("${redis.task.port}")
    private int redisPort;

    @Value("${redis.task.pass}")
    private String redisPass;

    @Value("${redis.task.db}")
    private int redisDb;


//    @Bean("rddConnectionFactory")
    public RedisConnectionFactory rddConnectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setPort(redisPort);
        connectionFactory.setHostName(redisHost);
        connectionFactory.setDatabase(13);
        connectionFactory.setPassword(redisPass);
        return connectionFactory;
    }

//    @Bean("rddRedisTemplate")
    public StringRedisTemplate rddRedisTemplate(@Qualifier(value = "rddConnectionFactory") RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(factory);
        return template;
    }

    @Bean
    public RedisScript<Boolean> lockScript() {
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<Boolean>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/redis-lock.lua")));
        redisScript.setResultType(Boolean.class);
        return redisScript;
    }

    @Bean
    public RedisScript<Boolean> unlockScript() {
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<Boolean>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/redis-unlock.lua")));
        redisScript.setResultType(Boolean.class);
        return redisScript;
    }

}
