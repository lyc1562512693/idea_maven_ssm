package com.surfilter.component.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**具体要执行的实体任务类
 * @author Administrator
 *
 */
public class MyJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd	HH:mm:ss");
		System.out.println("第一个	quartz任务在"+sdf.format(date)+"时运行了");
		JobDataMap detailmap = arg0.getJobDetail().getJobDataMap();
		System.out.println("姓名："+detailmap.getString("name"));
		JobDataMap triggermap = arg0.getTrigger().getJobDataMap();
		System.out.println("邮件："+triggermap.getString("mail"));
	}

}
