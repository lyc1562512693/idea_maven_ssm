package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s = null;
			OutputStreamWriter w = null;
			//w.flush();
			while(true){				
				s = new Socket("192.168.50.189",8083);
				w =  new OutputStreamWriter(s.getOutputStream());
				//w.write("你好，我是客户端用户A"+(int)(Math.random()*10000)+"，很高兴与服务端大佬交流");
				System.out.println("(client)请输入输入数据：");
				Scanner scanner = new Scanner(System.in);
				String data = scanner.nextLine();
				w.write(data);
				w.flush();
				s.shutdownOutput();//只关闭输出流，但是仍然保持连接
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String line = null;
				while((line = br.readLine())!=null){
					System.out.println("服务端传来的消息："+line);
				}
				br.close();
				w.close();
				s.close();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
