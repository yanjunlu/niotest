package niotest.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

	public static void main(String[] args) {
		int port = 8888;
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(port);
			System.out.println("time server is start in port:" + port);
			while (true) {
				Socket socket = server.accept();
				new Thread(new TimeServerHandler(socket)).start();
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
