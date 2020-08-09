package http;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * 自定义restful客户端（使用HttpURLConnection）
 * 
 */
public class MyHttpClient {

	public static void main(String[] args) {
		//新增
		//String urlPost = "http://localhost:8081/demoApi/userInfo/insert.do";
		//String jsonStr = "{\"userName\":\"tomson1\",\"phoneNum\":\"12321321321\",\"email\":\"123432@qq.com\",\"userPwd\":\"qwe123\"}";
		//post(urlPost,jsonStr);
		//查询
		//String urlGet = "http://localhost:8081/demoApi/userInfo/query.do?pageNo=1&pageSize=15";
		//get(urlGet);
		//更新
		/*String urlPut = "http://localhost:8081/demoApi/userInfo/update.do";
		String jsonPut = "{\"userId\":17,\"userName\":\"tomson2\",\"phoneNum\":\"12321321321\",\"email\":\"123432@qq.com\",\"userPwd\":\"qwe123\"}";
		put(urlPut,jsonPut);*/
		//删除
		/*String urlDelete = "http://localhost:8081/demoApi/userInfo/delete.do?userId=17";
		delete(urlDelete);*/
		String urlPost = "http://localhost:8081/demoApi/userInfo/insert.do";
		String jsonStr = "{\"userName\":\"tomson2\",\"phoneNum\":\"12321321321\",\"email\":\"123432@qq.com\",\"userPwd\":\"qwe123\"}";
		httpUtil(urlPost,"POST",jsonStr);
	}
	/**
	 * post:新增
	 */
	public static void post(String url,String jsonStr){
		HttpURLConnection conn = null;
		try {
			URL restURL = new URL(url);
			conn = (HttpURLConnection) restURL.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "keep-alive");
			conn.setConnectTimeout(5000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestProperty("content-type", "application/json;charset=UTF-8");
			conn.connect();
			OutputStream out = new DataOutputStream(conn.getOutputStream());//读进来，写出去，写到服务端去
			out.write(jsonStr.getBytes());
			out.flush();
			out.close();
			if(conn.getResponseCode() == 200){
				System.out.println("get server connection success");
				InputStream in = conn.getInputStream();
				BufferedReader buff = new BufferedReader(new InputStreamReader(in));
				String line = "";
				String result = "";
				while((line = buff.readLine())!=null){
					result += line;
				}
				buff.close();
				System.out.println(result);
			}else if(conn.getResponseCode() >= 400 && conn.getResponseCode() < 500){
				System.out.println("client error!");
			}else if(conn.getResponseCode() >= 500){
				System.out.println("server error!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			conn.disconnect();//关闭连接
			System.out.println("connection has closed!");
		}
	}
	/**
	 * get:查询
	 */
	public static void get(String url){
		HttpURLConnection con = null;
		InputStream in = null;
		try {
			URL resURL = new URL(url);
			con = (HttpURLConnection)resURL.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("content-type", "text/html;charset=utf-8");
			con.setRequestProperty("accept", "*/*");
			con.setRequestProperty("connection", "keep-alive");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();
			if(con.getResponseCode() == 200){
				in = con.getInputStream();
				byte[] buff = new byte[2048];
				int length = 0;
				while((length = in.read(buff)) != -1){
					System.out.println(new String(buff,0,length));
				}			
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			con.disconnect();
			System.out.println("connection has closed!");
		}
	}
	/**
	 * put:更新
	 */
	public static void put(String url,String jsr){
		HttpURLConnection con = null;
		try {
			URL resURL = new URL(url);
			con = (HttpURLConnection)resURL.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("content-type", "application/json;charset=utf-8");
			con.setRequestProperty("accept", "*/*");
			con.setRequestProperty("connection", "keep-alive");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();
			OutputStream out = new DataOutputStream(con.getOutputStream());
			out.write(jsr.getBytes());
			if(con.getResponseCode() == 200){
				InputStream in = new DataInputStream(con.getInputStream());
				byte[] b = new byte[1024];
				int length = 0;
				while((length = in.read(b)) != -1){
					System.out.println(new String(b,0,length));
				}
				in.close();
				System.out.println("------------");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.disconnect();
			System.out.println("connection has closed");
		}
	}
	/**
	 * 删除：delete
	 */
	public static void delete(String url){
		HttpURLConnection con = null;
		InputStream in = null;
		try {
			URL resURL = new URL(url);
			con = (HttpURLConnection)resURL.openConnection();
			con.setRequestMethod("DELETE");
			con.setRequestProperty("content-type", "text/html");
			con.setRequestProperty("accept", "*/*");
			con.setRequestProperty("connection", "keep-alive");
			con.connect();
			if(con.getResponseCode() == 200){			
				in = new DataInputStream(con.getInputStream());
				byte[] buff = new byte[1024];
				int length = 0;
				while((length = in.read(buff)) != -1){
					System.out.println(new String(buff,0,length));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			con.disconnect();
			System.out.println("connection has closed");
		}
	}
	
	public static void httpUtil(String url,String method,String json){
		HttpURLConnection con = null;
		InputStream in = null;
		try {
			URL resURL = new URL(url);
			con = (HttpURLConnection)resURL.openConnection();
			con.setRequestMethod(method);
			con.setRequestProperty("accept", "*/*");
			con.setRequestProperty("connection", "keep-alive");
			switch(method){
			case "POST":
				con.setRequestProperty("content-type", "application/json;charset=utf-8");
				con.setUseCaches(false);
				break;
			case "PUT":
				con.setRequestProperty("content-type", "application/json;charset=utf-8");
				break;
			case "GET":
				con.setRequestProperty("content-type", "text/html;charset=utf-8");
				break;
			case "DELETE":
				con.setRequestProperty("content-type", "text/html;charset=utf-8");
			}
			con.setConnectTimeout(5000);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();
			if("POST".equals(method) || "PUT".equals(method)){
				OutputStream out = new DataOutputStream(con.getOutputStream());
				out.write(json.getBytes());
				out.flush();
				out.close();
			}
			while(con.getResponseCode() == 200){
				in = new DataInputStream(con.getInputStream());
				byte[] buff = new byte[1024];
				int length = 0;
				while((length = in.read(buff)) != -1){
					System.out.println(new String(buff,0,length));
				}
			}
			if(con.getResponseCode() == 200){}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				in.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			con.disconnect();
			System.out.println("connection is closed");
		}
	}
}
