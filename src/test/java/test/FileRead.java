package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileRead {

	public static void main(String[] args){
		
		readtest();
	}
	
	public static void readtest(){
		try {
			FileInputStream file= new FileInputStream("F://ehe.txt");
			byte[] buf =new byte[10];
			int length=0;			
				while((length=file.read(buf))!=-1){
					System.out.println(new String(buf,0,length));
				}		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
