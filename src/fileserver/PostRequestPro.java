package fileserver;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**  
 * @author �¼�
 * @version ����ʱ�䣺2018��9��16�� ����6:10:42
 * Copyright (C) 2018 ChenJi. All rights reserved.
 */

public class PostRequestPro {
	private static Connection conn;
	private String filePath;
	private String fileType;
	
	FileOutputStream fileOutputStream;
	
	public static void dataBaseConnection(){
		String db_driver = "com.mysql.jdbc.Driver";
		String db_username = "root";
		String db_password = "123456";
		String db_url = "jdbc:mysql://127.0.0.1:3306/file";
		try{
			Class.forName(db_driver);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("���ݿ���������ʧ��");
		}
		try{
			conn = DriverManager.getConnection(db_url, db_username, db_password);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}finally{
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("���ݿ����ӹر��쳣");
			}
			
		}
	}
}
