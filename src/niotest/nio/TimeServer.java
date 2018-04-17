package niotest.nio;

import java.io.IOException;

public class TimeServer {

	public static void main(String[] args) {
		int port = 8888;
		TimeServerHandler timeServer = new TimeServerHandler(port);
		new Thread(timeServer).start();

	}

}
