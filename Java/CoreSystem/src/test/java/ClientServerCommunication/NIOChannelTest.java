package ClientServerCommunication;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ChannelClient.Client;
import ChannelServer.CoreServer;

public class NIOChannelTest {
	Process server;
	Client coreClient;

	@Before
	public void setUp() throws Exception {
		server = CoreServer.start();
		coreClient = Client.getClient();
	}

	@After
	public void tearDown() throws Exception {
		coreClient.close();
		server.destroy();
	}

	@Test
	public void test() throws IOException {
		String message1 = "Hello";
		String message2 = "World";
		String response1 = coreClient.sendMessageToServer(message1);
		String response2 = coreClient.sendMessageToServer(message2);
		assertEquals(response1, "Hello1");
		assertEquals(response2, "World");
	}

}
