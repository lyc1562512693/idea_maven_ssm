package socketV2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
		DataInputStream dis = MessageUtil.getProcess(socket);
		DataOutputStream dos = MessageUtil.setProcess(socket, "server");
		dis.close();
		dos.close();
		socket.close();
	}
	
}
