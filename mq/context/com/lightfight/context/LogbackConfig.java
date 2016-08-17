package com.lightfight.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

public class LogbackConfig {
	
	 private static final Logger LOG = LoggerFactory.getLogger(LogbackConfig.class);
	 
	public static void init(){
		LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.reset();
        try {
            configurator.doConfigure("config/logback.xml");
       } catch (JoranException e) {
            e.printStackTrace();
        }
        
        LOG.info("LogbackConfig init successfully!");
	}
}
