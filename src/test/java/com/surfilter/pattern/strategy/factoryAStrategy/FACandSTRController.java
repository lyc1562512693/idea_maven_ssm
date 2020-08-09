package com.surfilter.pattern.strategy.factoryAStrategy;

public class FACandSTRController {

	public static CashSuper getCashStyle(String style){
		CashSuper cs = null;
		switch(style){
		case "满减":
			cs = new CashReturn();			
			break;
		default:
			cs = new CashRebate(Double.valueOf(style));
		}
		return cs;
	}
}
