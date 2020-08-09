package com.surfilter.pattern.strategy.factoryAStrategy;

public enum ReturnStyle {

	LIVEL1("满300减100",1),LIVEL2("满700减300",2);
	
	private String name;
	private int index;
	
	private ReturnStyle(String name, int index) {
		this.name = name;
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
