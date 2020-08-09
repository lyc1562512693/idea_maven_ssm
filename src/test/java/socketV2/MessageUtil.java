package socketV2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Rzxuser
 * 通讯工具类
 */
public class MessageUtil {

	public static final int TXT = 1;
	public static final int FILE = 2;
	public static final int PICTURE = 3;
	public static final int VIDEO = 4;
	//发送过程
	public static DataOutputStream setProcess(Socket socket,String name) throws IOException{
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		System.out.println(name+"请输入要传入的数据类型（1为字符串，2为文本文件，3为图片，4为音频文件）：");
		Scanner scanner = new Scanner(System.in);
		int type = scanner.nextInt();
		if(type == TXT){//传输普通文本
			System.out.println("请输入要发送的内容：");
			Scanner scannerTxt = new Scanner(System.in);
			setMsg(dos,TXT,scannerTxt.nextLine());
		}else if(type == FILE){//传输文本文件
			System.out.println("请输入要发送的文件路径：");
			Scanner scannerFile = new Scanner(System.in);
			File file = new File(scannerFile.nextLine());
			setFile(dos,FILE,file);
		}else if(type == PICTURE){//传输图片
			System.out.println("请输入要发送的图片路径：");
			Scanner scannerPic = new Scanner(System.in);
			File pic = new File(scannerPic.nextLine());
			setFile(dos,PICTURE,pic);
		}else{//传输音频
			
		}
		socket.shutdownOutput();//只关闭输出流，但是仍然保持连接
		return dos;
	}
	//接收过程
	public static DataInputStream getProcess(Socket socket) throws IOException{
		DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		String line = null;
		//解析客户端请求，根据请求类型不同进行不同操作
		int dataType = dis.readInt();
		if(dataType==MessageUtil.TXT){//如果是字符串
			byte[] b = new byte[1024];
			int length = 0;
			while((length = dis.read(b))!=-1){
				System.out.println(new String(b,"utf-8"));
			}
		}else if(dataType==MessageUtil.FILE){
			/*byte[] b = new byte[1024];
			int length = 0;
			while((length = dis.read(b))!=-1){
				System.out.println(new String(b,"utf-8"));
			}*/
			System.out.println(dis.readLong());
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("F:\\hei\\lyc.txt")));
			byte[] by = new byte[2048];
			int len = 0;
			while((len=dis.read(by))!=-1){
				dos.write(by,0,len);
			}
			dos.flush();
			dos.close();
		}else if(dataType==MessageUtil.PICTURE){
			System.out.println(dis.readLong());
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("F:\\hei\\huaji.jpg")));
			byte[] by = new byte[2048];
			int len = 0;
			while((len=dis.read(by))!=-1){
				dos.write(by,0,len);
			}
			dos.flush();
			dos.close();
		}else{
			
		}
		socket.shutdownInput();//关闭服务端输入流，但是仍然保持与客户端的连接
		return dis;
	}
	//发送普通消息
	public static void setMsg(DataOutputStream out,int dataType,String msg) throws IOException{
		byte[] bytes = msg.getBytes("utf-8");
		out.writeInt(dataType);
		out.writeInt(msg.length());
		out.write(bytes);
		out.flush();
	}
	//发送文件类型消息（文本文档，图片，音频）
	public static void setFile(DataOutputStream out,int dataType,File file) throws IOException{
		out.writeInt(dataType);
		out.writeLong(file.length());
		FileInputStream fis = new FileInputStream(file);
		int len = 0;
		byte[] by = new byte[2048];
		while((len= fis.read(by))!=-1){
			out.write(by,0,len);
		}
		/*BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println(line);
			out.write(line.getBytes(),0,line.getBytes().length);
		}*/
		fis.close();
		out.flush();
	}
}
