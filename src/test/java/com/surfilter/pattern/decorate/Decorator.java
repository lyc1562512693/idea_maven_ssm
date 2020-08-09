package com.surfilter.pattern.decorate;
/**
 * 装饰者抽象类
 * @author Rzxuser
 *
 */
public class Decorator extends Component {

	//引入被装饰者抽象类
	private Component component;
	//使用set方法初始化被装饰着抽象类
	public void setComponet(Component component){
		this.component = component;
	}
	@Override
	public void Operation() {
		// TODO Auto-generated method stub

	}

}



