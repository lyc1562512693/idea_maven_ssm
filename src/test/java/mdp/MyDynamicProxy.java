package mdp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类，必须要实现InvocationHandler接口
 * @author Rzxuser
 *
 */
public class MyDynamicProxy implements InvocationHandler {

	private Object subject;
	
	public MyDynamicProxy(Object subject){
		this.subject = subject;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("在租房子前保洁员要先打扫房间！");
		System.out.println("method:"+method);
		
		method.invoke(subject, args);
		
		System.out.println("租完房子保洁员再次打扫，确保干净");
		return null;
	}

}
