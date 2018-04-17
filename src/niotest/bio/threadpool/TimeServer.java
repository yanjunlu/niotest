package niotest.bio.threadpool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimeServer {

	public static void main(String[] args) {
		int port = 8888;
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(port);
			ExecutorService threadPool = Executors.newFixedThreadPool(2);
			System.out.println("time server is start in port:" + port);
			while (true) {
				Socket socket = server.accept();
				
				threadPool.execute(new TimeServerHandler(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null) {
				try {
					server.close();
					server = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}

	}

}
