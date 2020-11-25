package siddhi;

import io.siddhi.core.SiddhiAppRuntime;
import io.siddhi.core.SiddhiManager;
import io.siddhi.core.event.Event;
import io.siddhi.core.stream.input.InputHandler;
import io.siddhi.core.stream.output.StreamCallback;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SiddhiAppRuntimeTest {
    //public List<>
    public static int appCount = 100;
    public static int dataCount = 1000000;
    public static void siddhiMultiApp(List<String> sqls, String streamName){
        List<InputHandler> handlers = new ArrayList<>();
        List<SiddhiAppRuntime> apps = new ArrayList<>();
        SiddhiManager manager = new SiddhiManager();
        for (String sql : sqls){
            SiddhiAppRuntime appRuntime = manager.createSiddhiAppRuntime(sql);
            InputHandler handler = appRuntime.getInputHandler(streamName);
            handlers.add(handler);
            appRuntime.start();
            apps.add(appRuntime);
            System.out.println(appRuntime.getName() + "��ʼ������");
        }
        addCallBacks(apps);
        putDataForMultiHander(handlers);
        /*for(SiddhiAppRuntime appRuntime: apps){
            appRuntime.shutdown();
        }
        manager.shutdown();*/
    }
    private static void addCallBacks(List<SiddhiAppRuntime> apps) {
        if(apps.size() > 1){
            int i = 0;
            for(SiddhiAppRuntime app: apps){
                app.addCallback("aggPriceItem" + i++, new StreamCallback() {
                    @Override
                    public void receive(Event[] events) {
                        System.out.println(app.getName()+ " call back function is running:");
                        System.out.println(events[0].toString());
                    }
                });
            }
        }else if(apps.size() == 1){
            SiddhiAppRuntime app = apps.get(0);
            for(int i = 0;i < appCount; i++){
                app.addCallback("aggPriceItem" + i++, new StreamCallback() {
                    @Override
                    public void receive(Event[] events) {
                        System.out.println(app.getName()+ " call back function is running:");
                        System.out.println(events[0].toString());
                    }
                });
            }
        }

    }
    public static void putDataForMultiHander(List<InputHandler> handlers){
        for(int i = 0; i < dataCount; i++){
            Object[] event = new Object[3];
            //event[0] = "1.1." + (int)(Math.random()*10) + "." + (int)(Math.random()*100);
            event[0] = "phone" + i;
            event[1] = 2;
            event[2] = 12312L;
            try {
                for(InputHandler handler: handlers) {
                    handler.send(event);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> getSqls(){
        List<String> sqls = new ArrayList<>();
        for(int i = 0;i < appCount;i++){
            /*String defSql = "Define stream tcp_stream(ts long, uid string, src_ip string,src_port int,src_mac string, dst_ip string, dst_port int,dst_mac string, proto string, start_state int, session_state int, elapsedtime long, up_linklength long, up_applength long, up_pkts long, down_linklength long, down_applength long, down_pkts long, apptype_crc long, appname_crc long);" +
                    " @info from tcp_stream#window.time(5 min) " +
                    "select srcip, max(src_port) as max_port group by src_ip insert into tcp_table0;";*/
            String defSql = "Define stream item(name string,price int, stime long); @info(name='query') from item #window.time(1 min) " +
                    "select name,sum(price) as total group by name insert into aggPriceItem" + i + ";";
            sqls.add(defSql);
        }
        return sqls;
    }
    public static List<String> getSingleSql(){
        /*String defSql = "Define stream tcp_stream(ts long, uid string, src_ip string,src_port int,src_mac string, dst_ip string, dst_port int,dst_mac string, proto string, start_state int, session_state int, elapsedtime long, up_linklength long, up_applength long, up_pkts long, down_linklength long, down_applength long, down_pkts long, apptype_crc long, appname_crc long);";
        for(int i = 0; i< count; i++){
            defSql += "@info from tcp_stream#window.time(5 min) " +
                    "select src_ip, max(port) as max_port group by src_ip insert into tcp_table"+i+ ";";
        }*/
        String defSql = "Define stream item(name string,price int, stime long);";
        for(int i = 0; i< appCount; i++){
            defSql += "@info from item#window.time(1 min) " +
                    "select name,sum(price) as total group by name insert into aggPriceItem"+i+ ";";
        }
        List<String> sqls = new ArrayList<>();
        sqls.add(defSql);
        return sqls;
    }
    public static void main(String[] args) {
        List<String> sqls = getSingleSql();
        //List<String> sqls = getSqls();
        long startTime = new Date().getTime() / 1000;
        siddhiMultiApp(sqls, "item");
        long endTime = new Date().getTime() / 1000;
        System.out.println("����ʱ��" + (endTime - startTime) + "s");
    }
}
