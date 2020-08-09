package mdp;


/**
 * 需要被代理对象创建的真实对象（被代理类）
 * @author Rzxuser
 *
 */
public class RealObject implements Subject {

	@Override
	public void rent() {
		// TODO Auto-generated method stub
		System.out.println("我是房东realObject，我正在租房子！");
	}

	@Override
	public void hello(String str) {
		// TODO Auto-generated method stub
		System.out.println("hello，你要租房子吗，我是房东"+str);
	}

}
