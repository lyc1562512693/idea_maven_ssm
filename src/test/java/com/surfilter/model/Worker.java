package com.surfilter.model;

public class Worker {
    private int id;
    private String name;

    public Worker(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Woker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
