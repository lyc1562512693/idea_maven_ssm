package effective;

import effective.instance.builder.AlgorithmBuilder;
import effective.instance.serverprovide.Service;
import effective.instance.serverprovide.ServiceAccess;

public class EffectiveMain {
    public static void main(String[] args) {

    }
    /**
     * effective1-获取实例-使用静态工厂方法代替构造函数-服务提供者框架简写
     * 优点：有名称（对于有多个构造器的类，不好区分哪个构造器生产的类的具体情况），可用于单例，可返回对应类型子类，返回对像可变，返回的具体子类可以不存在
     */
    public static void effectiveInstanceServerProvideTest(){
        ServiceAccess.registerService("mysql");
        Service service = ServiceAccess.getService("mysql");
        service.server();
    }

    /**
     * effective2-获取实例-使用建造者模式构造器创建实例
     * 适用于一个类有多个可变参数构造器的代替，而且通过具体（后接方法）名字可以知道具体参数情况
     */
    public void effectInsBuilderTest(){
        AlgorithmBuilder abuilder1 = new AlgorithmBuilder.Builder(120,12).size(20).learningdays(30).build();
        abuilder1.toString();
        AlgorithmBuilder abuilder2 = new AlgorithmBuilder.Builder(120,12).build();
        abuilder2.toString();
    }
}
