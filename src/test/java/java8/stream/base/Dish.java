package java8.stream.base;

public class Dish {

	private String name;
	private Boolean vegetarian;
	private int calories;
	private Type type;
	
	public Dish(String name, Boolean vegetarian,int calories, Type type){
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getVegetarian() {
		return vegetarian;
	}
	public void setVegetarian(Boolean vegetarian) {
		this.vegetarian = vegetarian;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public enum Type{MEAT,FISH,OTHER}
	@Override
	public String toString() {
		return "Dish [name=" + name + ", vegetarian=" + vegetarian + ", calories=" + calories + ", type=" + type + "]";
	}
	
}
