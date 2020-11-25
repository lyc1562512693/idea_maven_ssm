package effective.instance.serverprovide;

public class MysqlService implements Service {
    private String name;
    private static volatile MysqlService service;
    private MysqlService(String name){
        this.name = name;
    }
    public static Service getInstance(String name){
        if(service == null){
            synchronized (MysqlService.class){
                if(service == null){
                    service = new MysqlService(name);
                }
            }
        }
        return service;
    }
    @Override
    public void server() {
        System.out.println("Mysql start service");
    }

    @Override
    public String getName() {
        return name;
    }
}
