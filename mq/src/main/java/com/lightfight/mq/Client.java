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
		
		Producer producer = SpringContext.getBean("producer");
		MLContainers mLContainers = SpringContext.getBean("MLContainers"); // 在创建默认bean名称的时候如果第二个字母是大写,第一个字母不会小写
		//Pre-instantiating singletons in DefaultListableBeanFactory@13dbee4: defining beans [consumer,MLContainers,producer,
		
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
