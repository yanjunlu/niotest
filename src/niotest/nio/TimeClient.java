package niotest.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {

	public static void main(String[] args) {
		int port = 8888;
		
		new Thread(new TimeClientHandle("127.0.0.1", port)).start();
		

	}

}
