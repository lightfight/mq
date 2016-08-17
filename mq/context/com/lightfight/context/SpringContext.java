package com.lightfight.context;

import java.io.File;
import java.net.SocketAddress;
import java.rmi.Remote;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringContext {

	private static SpringContext factory = new SpringContext();

	private static String configLocation = "config" + File.separator + "app*.xml";

	private static ApplicationContext ctx = new FileSystemXmlApplicationContext(configLocation);

	public static SpringContext getInstance() {
		return factory;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		return (T)ctx.getBean(beanName);
	}

	public static SocketAddress getBindSocketSide() {
		return (SocketAddress) ctx.getBean("socketSide");
	}

	public static Remote getRemoteBO(String remoteName) {
		return (Remote) ctx.getBean(remoteName);
	}
}
