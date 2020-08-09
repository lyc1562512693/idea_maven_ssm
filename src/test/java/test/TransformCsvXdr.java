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

public class TransformCsvXdr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileSourcePath = "E:\\xinlin\\XDR.log";
		String fileDesPath = new File(fileSourcePath).getParent() + File.separator + System.currentTimeMillis()
				+ ".csv";
		transformLogToCsvXdr(fileSourcePath, fileDesPath);
	}
	public static void transformLogToCsvXdr(String fileSourcePath, String fileDesPath) {

		try {
			FileInputStream is = new FileInputStream(fileSourcePath);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			FileOutputStream os = new FileOutputStream(fileDesPath);
			OutputStreamWriter osr = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osr);
			String csvHead = "ip version,policy_type,log_flags,FS_PhoneNum(5146),FS_IMSI(5147),FS_IMEI(5148),FS_RAT(5161),FS_NeSrcIp4(5149),FS_NeDestIp4(5151),"
					+ "FS_InterfaceType(5162),FS_ProcType(5163),FS_BTime(5164),FS_ETime(5165),FS_ProcStatus(5166),FS_LacTac(5157),FS_CiEcl(5158),FS_APN(5174),FS_IdcId(5012),FS_HouseId(5011),FS_ProbeId(5003),FS_SuperProto(5038),FS_ProtocolId(5026),FS_AppType(5039),FS_AuthorId(5010),FS_PolicyId(5002),FS_RefTaskId(5068),FS_TimeTv(5013),FS_LogSeq(5001),FS_IsGtpPack(5159),FS_KeyWordNum(5036),EN_CHARSET(7)";
			bw.write(csvHead);
			bw.newLine();
			String line = null;
			int count = 0;
			List<String> dataList = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				if ("".equals(line)||"+++".equals(line.substring(0, 3))||"Io".equals(line.substring(0, 2))) {
					continue;
				} else {
					String[] arr = line.split(":\\s");				
					//这里应该加一个判断arr长度大于1的判断
					if(arr.length>1){
						arr[1] = arr[1].trim();
						dataList.add(arr[1]);
					}else{
						dataList.add("");
					}
					
					if (dataList.size() == 31) {
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
