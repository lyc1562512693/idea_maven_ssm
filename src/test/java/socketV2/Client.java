package socketV2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

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
		DataOutputStream dos = MessageUtil.setProcess(socket,"client");
		DataInputStream dis = MessageUtil.getProcess(socket);
		dos.close();
		dis.close();
		socket.close();
	}
	
}
