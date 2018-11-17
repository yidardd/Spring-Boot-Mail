package net.rdd.spring.job.listener;

import net.rdd.util.ZipStrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TaskMessageListener extends MessageListenerAdapter {
	
    private final Logger log = LoggerFactory.getLogger(getClass());

	private final RedisSerializer<String> stringSerializer = new StringRedisSerializer();
	
	@Override
	public void onMessage(Message message, byte[] pattern) {
		String key = stringSerializer.deserialize(message.getBody());

		String[] split = key.split("\\|");
		try {
			String s = ZipStrUtil.unCompress(split[2]);
			log.error(s);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}


}
