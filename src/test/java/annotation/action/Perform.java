package annotation.action;

import annotation.Before;

public class Perform {
    @Before(value = "开始跳舞前要化妆")
    public void dance(){
        System.out.println("开始跳舞！！！");
    }
}
