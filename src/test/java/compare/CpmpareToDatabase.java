package compare;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;

public class CpmpareToDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date dateStart = new Date();
		Long timeStart = dateStart.getTime();
		try{
			//读入原始文件
			FileInputStream infileSource= new FileInputStream("F:/test/fileSource.csv");
			InputStreamReader inputStreamReaderSource = new InputStreamReader(infileSource);
			BufferedReader readerSource = new BufferedReader(inputStreamReaderSource);
			
			//未入青铜器数据
			FileOutputStream outfile = new FileOutputStream("F:/test/out.txt");
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outfile);
			BufferedWriter writer = new BufferedWriter(outputStreamWriter);
			int countSource = 0;
			String strSource=null;
			while((strSource=readerSource.readLine())!=null){
				countSource++;
				boolean flag = true;
				String[] arrSource = strSource.split(",");
				if(arrSource.length>5){
					String compareSource = arrSource[1]+arrSource[2];
					//读入日志文件
					FileInputStream infileLog = new FileInputStream("F:/test/database.csv");
					InputStreamReader inputStreamReaderLog = new InputStreamReader(infileLog);
					BufferedReader readerLog = new BufferedReader(inputStreamReaderLog);
					int countLog = 0;
					String strLog = null;
					while((strLog = readerLog.readLine()) != null){
						countLog++;
						String[] arrLog = strLog.split(",");
						if(arrLog.length>4){
							String compareLog=arrLog[3]+arrLog[4];
							if(compareSource.equals(compareLog)){
								flag = false;
								break;
							}
						}else{
							//System.out.println("日志数据第"+countLog+"条不合法!");
						}
						
					}
					readerLog.close();
				}else{
					System.out.println("原始数据第"+countSource+"条不合法！");
				}
				if(flag){
					writer.write(countSource+strSource);
					writer.newLine();
				}
			}
			writer.flush();
			
			readerSource.close();			
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		Date dateEnd = new Date();
		Long timeEnd = dateEnd.getTime();
		System.out.println(timeEnd-timeStart);
		
	}

}
