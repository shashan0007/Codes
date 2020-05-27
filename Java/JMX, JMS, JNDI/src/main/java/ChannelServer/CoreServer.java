package ChannelServer;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class CoreServer {
	
	public static void main(String args[]) throws IOException {
		InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 5454);
		
		Selector selector = Selector.open();
	
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.bind(socketAddress);
		serverChannel.configureBlocking(false);
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		ByteBuffer buffer = ByteBuffer.allocate(256);
		Boolean cont = true;
		while(cont) {
			try {
				selector.select();
			
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> keyIter = keys.iterator();
			
				while(keyIter.hasNext()) {
					SelectionKey keyFetched = keyIter.next();
					if(keyFetched.isAcceptable()) {
						register(selector,serverChannel);
					}
					if(keyFetched.isReadable()) {
						answerToClient(buffer,keyFetched);
					}
					keyIter.remove();
				}
			} catch(Exception e) {
				cont = Boolean.FALSE;
			}
			finally {
				serverChannel.close();
			}
		}
		
	}
	
	private static void answerToClient(ByteBuffer buffer, SelectionKey keyFetched) throws IOException {
		SocketChannel client = (SocketChannel) keyFetched.channel();
		client.read(buffer);
		if(new String(buffer.array()).trim().equals("POISON")) {
			client.close();
			System.out.println("Not accepting client messages anymore");
		}
		System.out.println("Writing message to Client");
		buffer.flip();
		client.write(buffer);
		buffer.clear();
		
	}

	private static void register(Selector selector, ServerSocketChannel serverSocket) throws IOException {
		SocketChannel clientChannel = serverSocket.accept();
		clientChannel.configureBlocking(false);
		clientChannel.register(selector, SelectionKey.OP_READ);
	}
	
	public static Process start() throws IOException {
		String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java"; 
		String classPath = System.getProperty("java.class.path");
		String className = CoreServer.class.getCanonicalName();
		ProcessBuilder processBuilder = new ProcessBuilder(javaBin,"-cp",classPath, className);
		return processBuilder.start();
	}
}
