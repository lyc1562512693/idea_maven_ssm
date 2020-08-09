package com.surfilter.model;

public class Factory {
    private int workerNum;
    private Worker worker;

    public Factory(Worker worker){
        this.worker = worker;
    }
    public int getWorkerNum() {
        return workerNum;
    }

    public void setWorkerNum(int workerNum) {
        this.workerNum = workerNum;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "workerNum=" + workerNum +
                ", worker=" + worker +
                '}';
    }
}
