package com.surfilter.pattern.strategy.factoryAStrategy;

public class CashReturn implements CashSuper {

	/*private ReturnStyle style ;
	public void setStyle(ReturnStyle style){
		this.style = style;
	}*/
	@Override
	public double getCash(double money) {
		// TODO Auto-generated method stub
		if(money > 300 && money <= 700){
			return money -= 100; 
		}else if(money > 700){
			return money -= 300;
		}else{
			return money;
		}
	}

}
