package ChannelClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
	private static SocketChannel socket;
	private static ByteBuffer buffer;
	private static Client instance;
	
	private Client() {
		try {
			socket = SocketChannel.open(new InetSocketAddress("127.0.0.1", 5454));
			buffer = ByteBuffer.allocate(256);
		} catch(IOException ex)  {
			System.out.println("error in creating client socket");
		}
	}
	
	public static Client getClient() {
		if(instance == null)
			instance = 	new Client();
		return instance;
	}
	
	public String sendMessageToServer(String message) {
		buffer = ByteBuffer.wrap(message.getBytes());
		String response = null;
		
		try {
			socket.write(buffer);
			buffer.clear();
			socket.read(buffer);
			response = new String(buffer.array()).trim();
			System.out.println("response=" + response);
			buffer.clear();
		}
		catch(IOException ex) {
			System.out.println("Failed to communicate with Server Channel");
		}
		return response;
	}
	
	public void close() throws IOException {
		socket.close();
		buffer = null;
	}

}
