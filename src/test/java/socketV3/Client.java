package socketV3;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		String ip = "192.168.50.189";
		int port = 8083;
		connectServer(ip,port);
	}
	//连接服务端
	public static void connectServer(String ip,int port){
		try {
			Socket socket = null;
			while(true){
				socket = new Socket(ip,port);
				requestMsg(socket);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//客户端消息
	public static void requestMsg(Socket socket) throws Exception{
		//OutputStreamWriter w =  new OutputStreamWriter(socket.getOutputStream());
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		System.out.println("client"+"请输入要传入的数据类型（1为字符串，2为文本文件，3为图片，4为音频文件）：");
		Scanner scanner = new Scanner(System.in);
		int type = scanner.nextInt();
		if(type == 1){//传输普通文本
			System.out.println("请输入要发送的内容：");
			Scanner scannerTxt = new Scanner(System.in);
			String str = scannerTxt.nextLine();
			//setMsg(dos,1,scannerTxt.nextLine());
			byte[] bytes = str.getBytes("utf-8");
			synchronized (bytes) {
				dos.writeInt(1);
				dos.writeLong(str.length());
				dos.write(bytes);
				dos.flush();
				bytes.notifyAll();
			}	
		}
		socket.shutdownOutput();//只关闭输出流，但是仍然保持连接
		DataInputStream dis = MessageUtil.getProcess(socket);
		dos.close();
		dis.close();
		socket.close();
	}
	
}
