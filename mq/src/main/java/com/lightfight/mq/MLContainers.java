package com.lightfight.mq;

import javax.annotation.Resource;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Service;

/**
 * 消息监听器
 * 
 * @author deliang
 *
 */
@Service
public class MLContainers {

	@Resource
	PooledConnectionFactory pooledConnectionFactory;
	
	@Resource
	Consumer consumer;
	
	public void init(String[] qnames){
		for (String item : qnames) { // 有多少个队列就创建多少个消息监听
			DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
			container.setConnectionFactory(pooledConnectionFactory);
			container.setPubSubDomain(false);
			container.setDestination(new ActiveMQQueue(item));
			container.setMessageListener(consumer);
			container.setSessionTransacted(false);
			container.initialize();
			
			container.start();
		}
	}
}
