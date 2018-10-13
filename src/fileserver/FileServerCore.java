package fileserver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**  
 * @author 陈吉
 * @version 创建时间：2018年10月13日 下午6:08:10
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
		
	}
	
	
}
