package niotest.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable {
	private Socket socket;

	public TimeServerHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			
			String body = null;
			String resp = null;
			while (true) {
				body = in.readLine();
				if (body == null) {
					break;
				}
				System.out.println("time server received command:" + body);
				resp = "query time".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "bad command";
				out.println(resp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
			if (out != null) {
				out.close();
				out = null;
			}
			if (this.socket != null) {
				try {
					this.socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				this.socket = null;
			}
		}
		

	}

}
