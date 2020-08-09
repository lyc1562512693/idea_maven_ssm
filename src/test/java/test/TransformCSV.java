package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class TransformCSV {

	public static void main(String[] args) {
		String fileSourcePath = "E:\\xinlin\\XDR.log";
		String fileDesPath = new File(fileSourcePath).getParent() + File.separator + System.currentTimeMillis()
				+ ".csv";
		transformLogToCsv(fileSourcePath, fileDesPath);
	}

	public static void transformLogToCsv(String fileSourcePath, String fileDesPath) {

		try {
			FileInputStream is = new FileInputStream(fileSourcePath);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			FileOutputStream os = new FileOutputStream(fileDesPath);
			OutputStreamWriter osr = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osr);
			String csvHead = "Key,Operation,Acc type,MSISDN,IMEI,IMSI,Src addr,Dst addr,Sgsn addr,"
					+ "Ggsn addr,Sgsn teid,Ggsn teid,Tac,Eci";
			bw.write(csvHead);
			bw.newLine();
			String line = null;
			int count = 0;
			List<String> dataList = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				if ("---".equals(line.substring(0, 3)) || "Seq".equals(line.substring(0, 3))) {
					continue;
				} else {
					String[] arr = line.split("[:\\[\\]]");
					if (arr.length > 2) {
						arr[1] += ":" + arr[2];
					}
					//这里应该加一个判断arr长度大于1的判断
					if(arr.length>1){
						arr[1] = arr[1].trim();
						dataList.add(arr[1]);
					}else{
						dataList.add("");
					}
					if (dataList.size() == 14) {
						String strLine = "";
						for (String data : dataList) {
							strLine += data + ",";
						}
						strLine = strLine.substring(0, strLine.length() - 1);
						bw.write(strLine);
						bw.newLine();
						dataList.clear();
						count++;
						if (count % 20000 == 0 || count == 1) {
							System.out.println("系统日志：正在转换第" + count + "行。。。。。");
						}
					}
				}
			}
			System.out.println("系统日志：转换完成，本次共生成" + count + "行");
			bw.flush();
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
