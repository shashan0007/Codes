package JMXClientServerTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import RMIRegistryandJMX.JMXClient;
import RMIRegistryandJMX.JMXServer;

public class JMXTest {
	Process server;
	JMXClient client;

	@Before
	public void setUp() throws Exception {
		JMXServer.startJMXServer();
		client = JMXClient.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		server.destroy();
		System.out.println("Test Completed");
	}

	@Test
	public void test() {
		client.start();
	}
	

}
