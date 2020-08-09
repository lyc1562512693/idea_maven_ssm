package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransforCSV {

	private static Logger logger = LoggerFactory.getLogger(TransforCSV.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readLog("F:\\csv\\tz\\qwq.log", "F:\\csv\\tz\\myCsv.csv");

	}

	public static List<String> readLog(String fileSourcePath, String fileDesPath) {
		List<String> list = new ArrayList<String>();
		try {
			/*FileInputStream is = new FileInputStream(fileSourcePath);
			InputStreamReader isr = new InputStreamReader(is);*/
			BufferedReader br = new BufferedReader(new FileReader(fileSourcePath));
			/*FileOutputStream os = new FileOutputStream(fileDesPath);
			OutputStreamWriter osr = new OutputStreamWriter(os);*/
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileDesPath));
			String csvHead = "Key,Operation,Acc type,MSISDN,IMEI,IMSI,Src addr,Dst addr,Sgsn addr,Ggsn addr,Sgsn teid,Ggsn teid,Tac,Eci";
			bw.write(csvHead);
			bw.newLine();
			String line = null;
			List<String> listS = new ArrayList<String>();	
			while ((line = br.readLine()) != null) {
				if ("---".equals(line.substring(0, 3)) || "Seq".equals(line.substring(0, 3))) {
					continue;
				} else {
					String[] s = line.split("[:\\[\\]]");
					if (s.length > 2) {
						s[1] += ":" + s[2];
					}
					listS.add(s[1]);
					if (listS.size() == 14) {
						String s1 = "";
						for (String l : listS) {
							s1 += l + ",";
						}
						s1 = s1.substring(0, s1.length() - 1);
						bw.write(s1);
						bw.newLine();
						listS.clear();
					}

				}
			}
			bw.flush();
			br.close();
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("转换完成！");
		return list;
	}

}
