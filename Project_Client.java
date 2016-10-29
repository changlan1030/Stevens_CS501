import java.io.*;
import java.net.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Project_Client extends Application implements Runnable {
	private Text text1 = new Text("   Name:");      // text for "name"
	private Text text2 = new Text("   Text:");      // text for "text"
	private TextField tfName = new TextField();     // text field for name
	private TextField tfText = new TextField();     // text field for text
	private Button button = new Button("Send");     // button to send
	private TextArea taText = new TextArea();       // text area to display message
	private DataInputStream is;                     // input stream
	private DataOutputStream os;                    // output stream
	private String ipAddress;                       // ip address
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// create a grid pane
		GridPane pane = new GridPane();
		pane.add(text1, 0, 0);
		pane.add(tfName, 1, 0);
		pane.add(text2, 0, 1);
		pane.add(tfText, 1, 1);
		pane.add(button, 1, 2);
		pane.add(taText, 1, 3);
		ColumnConstraints column1 = new ColumnConstraints(75);
		ColumnConstraints column2 = new ColumnConstraints(400);
		pane.getColumnConstraints().addAll(column1, column2);
		taText.setEditable(false);
		
		// send the message
		button.setOnAction(e -> send());
		
		// create a scene
		Scene scene = new Scene(pane, 500, 300);
		primaryStage.setTitle("Client");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		try {
			// get the ip address and display
			ipAddress = InetAddress.getLocalHost().getHostAddress();
			taText.appendText("My ip address: " + ipAddress + '\n');
			
			// create a socket to connect to the server
			Socket socket = new Socket(ipAddress, 8000);
			
			// create an input stream to receive message from the server
			is = new DataInputStream(socket.getInputStream());
			
			// create an output stream to send message to the server
			os = new DataOutputStream(socket.getOutputStream());
			
			// create a thread to receive message
			new Thread(this).start();
		}
		catch (IOException ex) {
			taText.appendText(ex.toString() + '\n');
		}
	}
	
	private void send() {
		try {
			// display the time and the message
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss     ");
			String time = format.format(date);
			String string = time + tfName.getText().trim() + ": " + tfText.getText().trim();
			
			// send the message
			os.writeUTF(string);
			
			// clear the text field for text
			tfText.setText("");
		}
		catch (IOException ex) {
			System.err.println(ex);
		}
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				// receive the message and display
				String text = is.readUTF();
				taText.appendText(text + '\n');
			}
		}
		catch (IOException ex) {
			System.err.println(ex);
		}
	}
}