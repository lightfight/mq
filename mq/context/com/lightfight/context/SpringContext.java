package com.lightfight.context;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringContext {

	private static SpringContext factory = new SpringContext();

	private static String configLocation = "config" + File.separator + "app*.xml";

	private static ApplicationContext ctx = new FileSystemXmlApplicationContext(configLocation);

	public static SpringContext getInstance() {
		return factory;
	}

	/**
	 * 采用class的方式可以避免使用名称命名带来的书写问题<BR>
	 * 在创建默认bean名称的时候如果第二个字母是大写,第一个字母不会小写<BR>
	 * 
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		return (T) ctx.getBean(clazz);
	}
}
