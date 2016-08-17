package com.lightfight.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * 消息转换器
 * 
 * @author deliang
 *
 */
public class JmsMessageConverter implements MessageConverter {

	Logger log = LoggerFactory.getLogger(JmsMessageConverter.class);

	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		
		if (log.isDebugEnabled()) {
			log.debug("fromMessage...");
		}
		if (message instanceof ObjectMessage) {
			ObjectMessage objectMessage = (ObjectMessage) message;
			if (objectMessage instanceof ActiveMQObjectMessage) {
				ActiveMQObjectMessage activeMQObjectMessage = (ActiveMQObjectMessage) objectMessage;
				try {
					PlayerTO msg = (PlayerTO) activeMQObjectMessage.getObject();
					return msg;
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		}
		return null;
	}

	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		
		if (log.isDebugEnabled()) {
			log.debug("toMessage...");
		}
		
		if (object instanceof PlayerTO) {
			ActiveMQObjectMessage msg = (ActiveMQObjectMessage) session.createObjectMessage();
			msg.setObject((PlayerTO) object);
			
			if (log.isDebugEnabled()) {
				log.debug(object.toString());
			}
			
			return msg;
		}
		return null;
	}

}
