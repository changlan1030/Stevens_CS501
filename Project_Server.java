import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Project_Server {
	// create a hash table to output the stream
	private Hashtable outputStreams = new Hashtable();
	
	public static void main(String[] args) {
		new Project_Server();
	}
	
	public Project_Server() {
		monitor();
	}
	
	private void monitor() {
		try {
			// create a server socket
			ServerSocket serverSocket = new ServerSocket(8000);
			
			// display the server start time
			Date dateStart = new Date();
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss     ");
			String timeStart = format1.format(dateStart);
			System.out.println(timeStart + "Server start.");
			
			while (true) {
				// create a socket to monitor a new connection
				Socket socket = serverSocket.accept();
				
				// display the client connect time
				Date dateConnect = new Date();
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss     ");
				String timeConnect = format2.format(dateConnect);
				System.out.println(timeConnect + "Client connect(from " + socket + ").");
				
				// create an output stream and save it to the hash table
				DataOutputStream os = new DataOutputStream(socket.getOutputStream());
				outputStreams.put(socket, os);
				
				// create a thread to send message
				new ServerThread(this, socket);
			}
		}
		catch(IOException ex) {
			System.err.println(ex);
		}
	}
	
	class ServerThread extends Thread {
		private Socket socket;
		private Server server;
		
		// build a thread
		public ServerThread(Server server, Socket socket) {
			this.socket = socket;
			this.server = server;
			start();
		}
		
		public void run() {
			try {
				// create an input stream to receive message from client
				DataInputStream is = new DataInputStream(socket.getInputStream());
				
				while (true) {
					String msg = is.readUTF();
					
					// send the message to all clients
					for (Enumeration e = outputStreams.elements(); e.hasMoreElements();) {
						// create an output stream to send message to client
						DataOutputStream os = (DataOutputStream)e.nextElement();
						os.writeUTF(msg);
					}
					System.out.println(msg);
				}
			}
			catch(IOException e) {
				System.err.println(e);
			}
		}
	}
}