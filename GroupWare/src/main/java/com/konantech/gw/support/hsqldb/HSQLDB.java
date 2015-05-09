package com.konantech.gw.support.hsqldb;

import java.util.Properties;

import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;

public class HSQLDB implements SmartLifecycle {

	private final Logger logger = LoggerFactory.getLogger(HSQLDB.class);
	private HsqlProperties properties;
	private Server server;
	private boolean running = false;

	public HSQLDB(Properties props) {
		properties = new HsqlProperties(props);
	}

	public boolean isRunning() {
		if(server != null)
			server.checkRunning(running);
		return running;
	}

	public void start() {
		if(server == null) {
			logger.info("Starting HSQL server...");
			server = new Server();

			try {
				server.setProperties(properties);
				server.start();
				running = true;
			} catch(Exception afe) {
				logger.error("Error starting HSQL server.", afe);
			}
		}
	}

	public void stop() {
		logger.info("Stopping HSQL server...");
		if(server != null) {
			server.stop();
			running = false;
		}
	}

	public int getPhase() {
		return 0;
	}

	public boolean isAutoStartup() {
		return true;
	}

	public void stop(Runnable runnable) {
		stop();
		runnable.run();
	}

}
