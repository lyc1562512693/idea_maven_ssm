package socketV3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	public static void main(String[] args) {
		int port = 8083;
		listenAccept(port);
	}
	//监听客户端请求
	public static void listenAccept(int port){
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			Socket socket = null;
			while(true){
				socket = serverSocket.accept();
				responseMsg(socket);				
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//服务端消息
	public static void responseMsg(Socket socket) throws Exception{
		// TODO Auto-generated method stub
		DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		String line = null;
		//解析客户端请求，根据请求类型不同进行不同操作
		Message mes = new Message();
		int dataType = dis.readInt();
		long dataLen = dis.readLong();
		mes.setDataType(dataType);
		mes.setDataLen(dataLen);
		String str = null;
		if(dataType==MessageUtil.TXT){//如果是字符串
			byte[] b = new byte[1024];
			int length = 0;
			while((length = dis.read(b))!=-1){
				str+=new String(b,"utf-8");
			}
		}
		mes.setContent(str);
		socket.shutdownInput();//关闭服务端输入流，但是仍然保持与客户端的连接
		
		//线程一负责服务端的处理客户端发送过来的消息队列
		SocketThread st = new SocketThread(mes);
		Thread t = new Thread(st);
		t.start();
		
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		System.out.println("server"+"请输入要传入的数据类型（1为字符串，2为文本文件，3为图片，4为音频文件）：");
		Scanner scanner = new Scanner(System.in);
		int type = scanner.nextInt();
		if(type == MessageUtil.TXT){//传输普通文本
			System.out.println("请输入要发送的内容：");
			Scanner scannerTxt = new Scanner(System.in);
			MessageUtil.setMsg(dos,MessageUtil.TXT,scannerTxt.nextLine());
		}
		socket.shutdownOutput();//只关闭输出流，但是仍然保持连接
			
		dis.close();
		dos.close();
		socket.close();
				
		
		//线程二负责服务端发送消息
		/*new Thread(new Runnable(){

			@Override
			public void run() {
				
			}
			
		}).start();*/
	}
	
}
