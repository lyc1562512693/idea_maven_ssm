package com.surfilter.pattern.strategy.factoryAStrategy;

public class FandSMain {

	public static void main(String[] args) {
		
		CashSuper cs1 = FACandSTRController.getCashStyle("0.8");//策略及工厂类，计算出合适的折扣
		Context context = new Context();//包装类，在核心方法执行前后，执行公共的统一的操作
		context.setConetext(cs1);
		context.executeStrategy(90000);
		
		//测试枚举
		String str = "满300减100";
		int index = 0;
		if(str.equals(ReturnStyle.LIVEL1.getName())){
			index = ReturnStyle.LIVEL1.getIndex();
		}else if(str.equals(ReturnStyle.LIVEL2.getName())){
			index = ReturnStyle.LIVEL2.getIndex();
		}
		System.out.println(index);
	}

}
