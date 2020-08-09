package com.surfilter.component.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzEating implements Job {

	public static int count = 0;
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		count++;
		System.out.println("开始进行第"+count+"次实验");
	}

}
