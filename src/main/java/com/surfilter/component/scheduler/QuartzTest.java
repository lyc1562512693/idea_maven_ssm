package com.surfilter.component.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {

	public static void main(String[] args) {	
		//handleQuartzJob();
		//quartzTaskForAppointTime();
	}
	
	public static void handleQuartzJob(){		
		try {
		//从调度程序工厂获取一个调度程序的实例
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();	
		//显示调度程序的名称（这里会展示我们在quartz.properties文件中的名称）
		System.out.println("任务"+scheduler.getSchedulerName()+"即将执行");
		/** 
		 * 定义一个job，并绑定到我们自定义的HelloJob的class对象
		 *  这里并不会马上创建一个HelloJob实例，实例创建是在scheduler安排任务触发执行时创建的
		 */
		JobDetail jobDetail = JobBuilder.newJob(MyJob.class).usingJobData("name","tony").withIdentity("myJobDetail").build();
		// 声明一个触发器，现在就执行(schedule.start()方法开始调用的时候执行)；并且每间隔2秒就执行一次
		Trigger trigger = TriggerBuilder.newTrigger().usingJobData("mail", "123@qq.com").withIdentity("myTrigger")
		.startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(2)).build();
		// 告诉quartz使用定义的触发器trigger安排执行任务job
		scheduler.scheduleJob(jobDetail, trigger);
		//启动任务调度程序,内部机制是线程的启动
		scheduler.start();
		Thread.sleep(10000);
		//关闭任务调度程序,如果不关闭，调度程序schedule会一直运行着
		scheduler.shutdown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void quartzTaskForAppointTime(){
		try {
			//在当前时间往后延迟2秒启动
			Date triggerStartTime = new Date(new Date().getTime()+1000*60*1);
			int intervalSeconds = 2;
			int triggerRepeatCount = 10;
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			JobDetail jobDetail = getJobDetail(MyJob.class,"jname","jgroup");
			Trigger trigger = getTriggerForAppointTimeInEveryday(new Date());
			scheduler.scheduleJob(jobDetail,trigger);
			scheduler.start();
			//Thread.sleep(40000);
			//scheduler.shutdown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**获取指定job的JobDetail
	 * @param jobClass 指定的job实体类
	 * @return
	 */
	public static JobDetail getJobDetail(Class<? extends Job> jobClass,String name,String group){
		JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(name, group).build();
		return jobDetail;
	}
	/**获取指定启动时间，任务每次执行间隔，重复执行次数的trigger触发器
	 * @param triggerStartTime 指定定时任务开始的时间
	 * @param intervalSeconds 定时任务每次执行的间隔（s）
	 * @param triggerRepeatCount 定时任务重复执行的次数
	 */
	public static Trigger getTriggerForAppointTimeAndCount(Date triggerStartTime,int intervalSeconds,int triggerRepeatCount){
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("key"+Math.random(), "group"+Math.random()).startAt(triggerStartTime).withSchedule(
				SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(intervalSeconds).withRepeatCount(triggerRepeatCount-1)
				).build();	
		return trigger;
	}
	/**获取指定启动时间，任务每次执行间隔且无限循环的trigger触发器
	 * @param triggerStartTime 指定定时任务开始的时间
	 * @param intervalSeconds 定时任务每次执行的间隔（s）
	 * @return
	 */
	public static Trigger getTriggerForAppointTimeForever(Date triggerStartTime,int intervalSeconds,String name,String group){
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group).startAt(triggerStartTime).withSchedule(
				SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(intervalSeconds).repeatForever()
				).build();	
		return trigger;
	}
	/**获取指定启动、结束时间，任务每次循环执行间隔的trigger触发器
	 * @param triggerStartTime 指定任务开始的时间
	 * @param triggerEndTime 指定任务结束的时间
	 * @param intervalSeconds 定时任务每次执行的间隔（s）
	 * @return
	 */
	public static Trigger getTriggerForStartTimeAndEndTime(Date triggerStartTime,Date triggerEndTime,int intervalSeconds){
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("tkey"+Math.random(), "tgroup"+Math.random()).startAt(triggerStartTime).withSchedule(
				SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(intervalSeconds)
				).endAt(triggerEndTime).build();
		return trigger;
	}
	//基于Cron表达式的触发器CronTrigger
	/**获取在每天指定时间执行的Cron触发器
	 * @param date
	 * @return
	 */
	public static Trigger getTriggerForAppointTimeInEveryday(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = df.format(date);
		String[] strArray = strDate.split("[ :]");
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("tkey"+Math.random(), "tgroup"+Math.random()).withSchedule(
				CronScheduleBuilder.cronSchedule("0 "+strArray[2]+" "+strArray[1]+" * * ?")
				).build();
		return trigger;
	}
	
	
}
