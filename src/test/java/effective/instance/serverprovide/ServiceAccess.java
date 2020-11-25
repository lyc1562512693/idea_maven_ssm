package effective.instance.serverprovide;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ServiceAccess {

    public ServiceAccess(){
        init();
    }
    public static void init(){

    }
    private static Map<String, Service> services = new HashMap<>();

    public static void registerService(String name) {
        if(serviceExist(name)){
            System.out.println(services.get(name).getName() + " exist,you need not register it again!");
            return;
        }
        Service service = newService(name);
        services.put(name, service);
        System.out.println(services.get(name).getClass() + "register success!");
    }
    public static boolean serviceExist(String name){
        Set<String> names = services.keySet();
        if(names.contains(name)){
            return true;
        }
        return false;
    }
    public static Service newService(String name){
        Service service = null;
        switch (name){
            case "mysql":
                service = MysqlService.getInstance(name);
                break;
            case "mongo":
                service = MongoService.getInstance(name);
        }
        return service;
    }
    public static Service getService(String name){
        return services.get(name);
    }

}
