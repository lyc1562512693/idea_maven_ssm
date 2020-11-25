import effective.instance.builder.AlgorithmBuilder;
import effective.instance.serverprovide.Service;
import effective.instance.serverprovide.ServiceAccess;
import zhengzhe.RegexpDomain;

import java.util.Date;
import java.util.List;
import java.util.Stack;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {
        //regexpDomainTest();
        speedTest();

    }
    public static void regexpDomainTest(){
        String url1 = "whois.chinaz.comreverse?ddlSearchMode=1www.huya.com213www.tx.com";
        if(RegexpDomain.isContainTopDomain(url1)){
            String topDomain = RegexpDomain.splitTopDomain(url1);
            System.out.println(topDomain);
        }else{
            System.out.println("请输入url");
        }
    }

    public static void speedTest(){
        System.out.println("start...");
        long startTime = System.currentTimeMillis();
        long sum = 0L;
        for(int i = 0; i < Integer.MAX_VALUE; i++){
            sum += i;
        }
        System.out.println(sum);
        long endTime = System.currentTimeMillis();
        System.out.println("it total took " + (endTime - startTime) + "ms");
    }


}
