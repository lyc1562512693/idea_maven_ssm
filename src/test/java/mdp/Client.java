package mdp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Subject realObject = new RealObject();
		
		InvocationHandler hander = new MyDynamicProxy(realObject);
		
		Subject sub = (Subject) Proxy.newProxyInstance(hander.getClass().getClassLoader(), realObject.getClass().getInterfaces(), hander);
		
		System.out.println(sub.getClass().getName());
		
		sub.rent();
		sub.hello("lyc");
		
	}

}
