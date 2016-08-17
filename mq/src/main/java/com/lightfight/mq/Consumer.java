package com.lightfight.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.stereotype.Service;

@Service
public class Consumer implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage) {
			ObjectMessage objectMessage = (ObjectMessage) message;
			try {
				PlayerTO to = (PlayerTO) objectMessage.getObject();
				System.out.println("Consumer.onMessage = [ " + to + " ]");
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

	}

}
