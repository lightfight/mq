package com.lightfight.mq;

import com.lightfight.context.LogbackConfig;
import com.lightfight.context.SpringContext;
import com.lightfight.properties.ConfigProperties;

/**
 * 客户端测试类
 * 
 * @author deliang
 *
 */
public class Client {

	public static void main(String[] args) {
		
		LogbackConfig.init(); // 创建日志
		
		Producer producer = SpringContext.getBean(Producer.class);
		MessageListenerContainers mLContainers = SpringContext.getBean(MessageListenerContainers.class);
		
		String qnamesStr = ConfigProperties.getStr("qname");
		String[] qnames = qnamesStr.split(","); // Queue Names
		
		mLContainers.init(qnames); // 创建消息监听容器
		
		// 发送消息
		for (int i = 0; i < 10; i++) {
			String qname = qnames[i%qnames.length];
			
			PlayerTO to = new PlayerTO();
			to.setPid(100L);
			to.setPname(qname);
			to.setFightforce(1000);
			
			producer.send(qname, to);
		}
	}

}
