package com.fengclub.test.mongodb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongodbConnect {

	public static void main(String[] args) {
		List<String> li = MongodbConnect.readTxtFile("C:\\Users\\Administrator\\Desktop\\22.txt");
		MongoClient client = null;
		try {
			// 用户名 数据库 密码
			MongoCredential credential = MongoCredential.createCredential(li.get(0), li.get(1),
					li.get(2).toCharArray());
			// IP port
			ServerAddress addr = new ServerAddress(li.get(3), 27017);
			client = new MongoClient(addr, Arrays.asList(credential));
			// 得到数据库
			DB mdb = client.getDB("HappyCommunity");

			// 得到Table
			DBCollection table = mdb.getCollection("test"); // 查询所有
			DBCursor fi = table.find(); // 遍历结果
			for (Object o : fi) {
				System.out.println(o);
			}

		} catch (

		Exception e) {

			e.printStackTrace();
		} finally {
			if (client != null) {
				client.close();
			}
		}
	}

	public static List<String> readTxtFile(String filePath) {
		List<String> li = new ArrayList<String>();
		try {
			String encoding = "UTF-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					li.add(lineTxt);
					System.out.println(lineTxt);
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return li;
	}

}
