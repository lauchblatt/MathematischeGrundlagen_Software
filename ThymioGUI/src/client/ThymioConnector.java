package client;

import gui.ThymioInterface;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonReaderFactory;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.json.stream.JsonParserFactory;

public class ThymioConnector {
	private Socket clientSocket;
	private DataOutputStream toThymio;
	private BufferedReader fromThymio;
	private ThymioReadThread myReadThread;
	
	public ThymioConnector() {
	}
	
	public boolean thymioConnected() {
		return (clientSocket != null);
	}
	
	public void init(ThymioInterface mi) {
		try {
			// set up

			System.out.println("setting up Thymio Connection");
			
			clientSocket = new Socket("192.168.43.174", 6789);
			toThymio = new DataOutputStream(clientSocket.getOutputStream());
			fromThymio = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			myReadThread = new ThymioReadThread(fromThymio, mi);
			myReadThread.start();
			
			System.out.println("setup complete.");
		} catch (IOException e) {
			System.out.println("exception during setup: " + e.getMessage());
			if (e instanceof ConnectException) {
				fromThymio = null;
				toThymio = null;
				clientSocket = null;
				
				System.out.println("No Thymio available.");
			}
			else e.printStackTrace();
		}
	}
	
	public void close() {
		if (clientSocket == null) return; 
		else {
			try {
				clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendMessage(String input) {
		if (clientSocket == null) return;
		else {
			try {
				toThymio.writeBytes(input + "\n");
				toThymio.flush();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
