package fileserver;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**  
 * @author 陈吉
 * @version 创建时间：2018年9月16日 下午6:10:42
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
			System.out.println("数据库驱动加载失败");
		}
		try{
			conn = DriverManager.getConnection(db_url, db_username, db_password);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}finally{
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("数据库连接关闭异常");
			}
			
		}
	}
}
