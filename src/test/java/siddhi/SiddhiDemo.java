package siddhi;

import io.siddhi.core.SiddhiAppRuntime;
import io.siddhi.core.SiddhiManager;
import io.siddhi.core.event.Event;
import io.siddhi.core.stream.input.InputHandler;
import io.siddhi.core.stream.output.StreamCallback;
import io.siddhi.query.api.SiddhiApp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SiddhiDemo {
    public static void siidhiAppRuntimeOne() {
        String sql = "define stream tcp_stream(srcip string, srcport int, uid String);@info(name='query') from tcp_stream select srcip, srcport, uid insert into tcp_table";
        SiddhiManager siddhiManager = new SiddhiManager();
        SiddhiAppRuntime appRuntime = siddhiManager.createSiddhiAppRuntime(sql);
        appRuntime.addCallback("tcp_table", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                System.out.println(events[0].toString());
            }
        });
        InputHandler handler = appRuntime.getInputHandler("tcp_stream");
        try {
            handler.send(new Object[]{"1.1.1.1", 60, "EAc12312"});
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void siddhiAppRuntimeMulti(List<String> sqls, String stream_name, String table_name) {
        List<InputHandler> handlers = new ArrayList<>();
        SiddhiManager manager = new SiddhiManager();
        for (String sql : sqls) {
            SiddhiAppRuntime appRuntime = manager.createSiddhiAppRuntime(sql);
            appRuntime.addCallback(table_name, new StreamCallback() {
                @Override
                public void receive(Event[] events) {
                    // System.out.println(events[0].toString());
                }
            });
            InputHandler handler = appRuntime.getInputHandler(stream_name);
            handlers.add(handler);
        }
        putData(handlers);
    }

    public static void putData(List<InputHandler> handlers) {
        int i = 100000000;
        while (i-- > 0) {
            Object[] event = new Object[3];
            event[0] = "1.1." + (int) (Math.random() * 100) + "." + (int) (Math.random() * 100);
            event[1] = i % 100;
            event[2] = "BEA" + (int) (Math.random() * 10);
            for (InputHandler handler : handlers) {
                try {
                    handler.send(event);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<String> getSqls(int count) {
        List<String> sqls = new ArrayList<>();
        while (count-- > 0) {
            String sql = "define stream tcp_stream (srcip String, srcport int, uid String); @info from tcp_stream select srcip, srcport, uid insert into tcp_table";
            sqls.add(sql);
        }
        return sqls;
    }

    public static void main(String[] args) {
        long startTime = new Date().getTime() / 1000;
        // siidhiAppRuntimeOne();
        List<String> sqls = getSqls(1);
        siddhiAppRuntimeMulti(sqls, "tcp_stream", "tcp_table");
        long endTime = new Date().getTime() / 1000;
    }
}
