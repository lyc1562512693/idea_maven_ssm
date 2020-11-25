package effective.instance.serverprovide;

public class MongoService implements Service{
    private String name;
    private static MongoService service;
    private MongoService(String name){
        this.name = name;
    }

    @Override
    public void server() {
        System.out.println("mongo start service");
    }

    @Override
    public String getName() {
        return name;
    }

    public static Service getInstance(String name){
        if(service == null){
            synchronized (MongoService.class) {
                if(service == null){
                    service = new MongoService(name);
                }
            }
        }
        return service;
    }
}
