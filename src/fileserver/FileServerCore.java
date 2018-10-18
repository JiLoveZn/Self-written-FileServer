package fileserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

/**  
 * @author �¼�
 * @version ����ʱ�䣺2018��9��13�� ����6:08:10
 * Copyright (C) 2018 ChenJi. All rights reserved.
 */

public class FileServerCore extends Thread{
	
	ServerSocket serverSocket;
	Socket socket;
	InputStream inputStream;
	OutputStream outputStream;
	BufferedReader bufferedReader;
	FileInputStream fileInputStream;
	
	private String handler;
	private String fileName;
	private String fileType;
	private String filePath;
	private String requestType;
	
	private final String WRAP ="\r\n";
	
	public FileServerCore(){
		super();
	}

	public FileServerCore(Socket socket) throws IOException {
		super();
		this.socket = socket;
		inputStream = socket.getInputStream();
		outputStream = socket.getOutputStream();
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	}

	public FileServerCore(ServerSocket serverSocket, Socket socket, InputStream inputStream, OutputStream outputStream,
			BufferedReader bufferedReader) {
		super();
		this.serverSocket = serverSocket;
		this.socket = socket;
		this.inputStream = inputStream;
		this.outputStream = outputStream;
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			requestPro();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("����SQL�쳣");
		}
	}
	
	public void requestPro() throws SQLException{
		//TODO:ȷ��ǰ�˷�������post����get
		try{
			handler = bufferedReader.readLine();
			if(handler.equals("") || handler.equals(null) || handler.equals(WRAP)){
				handler = bufferedReader.readLine();
			}
			if(handler.contains("POST")){
				//TODO:doPost
			}
			if(handler.contains("GET")){
				//TODO:doGet
			}
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("����IO�쳣");
		}
	}
	
	public void doPost() throws IOException,SQLException{
		do{
			handler = bufferedReader.readLine();
			if(handler.contains("{")){
				handler = bufferedReader.readLine();
				requestType = handler.substring(handler.indexOf(":\""), handler.indexOf("\","));
				//TODO:��ȡPOST����
				readPostRequest();
			}
			if(handler.contains("}")){
				break;
			}
		}while(true);
	}
	
	public void doGet() throws IOException,SQLException{
		
	}
	
	public void readPostRequest() throws IOException,SQLException{
		PostRequestPro postRequestPro = new PostRequestPro();
		BufferedReader bufferedReader_postRequest = new BufferedReader(new FileReader(new File("")));
		
	}
}
