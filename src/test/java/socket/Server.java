package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(8083);
			Socket s = null;
			BufferedReader br = null;
			BufferedWriter bw =null;
			while(true){
				s = ss.accept();
				//System.out.println("客户端成功与地址为"+s.getLocalSocketAddress()+"服务端建立连接");
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				//bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("F:\\he\\q.txt")));
				String line = null;
				while((line = br.readLine())!=null){
					//bw.write(line);
					System.out.println("客户端发来消息："+line);
				}
				s.shutdownInput();//关闭服务端输入流，但是仍然保持与客户端的连接
				bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				Scanner scanner = new Scanner(System.in);
				System.out.println("(server)请输入输入数据：");
				bw.write(scanner.nextLine());
				bw.flush();
				bw.close();
				br.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
