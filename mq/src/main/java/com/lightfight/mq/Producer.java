package com.lightfight.mq;

import javax.annotation.Resource;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	
	@Resource
	private JmsTemplate jmsTemplate;

	// 使用JMSTemplate发送消息
	public void send(String destinationName, PlayerTO to) {
		jmsTemplate.convertAndSend(destinationName, to);
//		jmsTemplate.send(new MessageCreator() {
//			public Message createMessage(Session session) throws JMSException {
//				return session.createTextMessage(msg);
//			}
//		});
	}
}
