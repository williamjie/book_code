package com.irish.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class CustomerConfig {

	
	//自定义redisTemplate
	@Bean
	@SuppressWarnings("all")
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();

		template.setConnectionFactory(factory);

		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

		ObjectMapper om = new ObjectMapper();

		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

		jackson2JsonRedisSerializer.setObjectMapper(om);

		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

		// key采用String的序列化方式

		template.setKeySerializer(stringRedisSerializer);

		// hash的key也采用String的序列化方式

		template.setHashKeySerializer(stringRedisSerializer);

		// value序列化方式采用jackson

		template.setValueSerializer(jackson2JsonRedisSerializer);

		// hash的value序列化方式采用jackson

		template.setHashValueSerializer(jackson2JsonRedisSerializer);

		template.afterPropertiesSet();

		return template;

	}

	
	//这里是在存储到mongodb中的"_class"字段去掉
	@Bean
	public MongoConverter createMongoConverter(MongoDbFactory mongoDbFactory, MongoMappingContext mappingContext) {
		MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory),
				mappingContext);
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		return converter;
	}
}