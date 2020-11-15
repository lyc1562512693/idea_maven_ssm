package myThread.threadpool;

/**
 * @author lyc
 *线程池接口
 */
public interface ThreadPool {
	//添加任务
	void execute(Task task);
	//关闭所有工人线程
	void shutDown();
	//添加指定数量的工人线程
	void addWorkers(int num);
	//停止指定数量的工人线程
	void removeWorkers(int num);
	//获取待执行任务总数
	int getTaskNum();
}
