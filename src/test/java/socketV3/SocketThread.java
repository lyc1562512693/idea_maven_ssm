package socketV3;

import java.util.ArrayList;
import java.util.List;

public class SocketThread implements Runnable{
/*现在想能不能在服务端开两个线程，第一个线程包含一个检测消息阻塞队列，有消息就拿出来现世，没消息就等待，第二个线程负责发送消息
 * */
	public List<Message> list = new ArrayList<>();
	public SocketThread(Message mes){
		list.add(mes);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized(list){			
				while(list.isEmpty()){
					try {
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(!list.isEmpty()){
			System.out.println(list.remove(0));
			}
		}
	}

}
