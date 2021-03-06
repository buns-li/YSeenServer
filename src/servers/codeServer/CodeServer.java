package servers.codeServer;

import core.ServerBase;
import servers.codeServer.processors.*;
import servers.mqServer.MessageQueueServer;

/**
 * Created by Administrator on 2015/12/23.
 *
 * 操作逻辑:
 *  1.先加载
 */
public class CodeServer extends ServerBase {

    @Override
    public void run() throws Exception{

        System.out.println("CodeServer begin running...");

        System.out.println("CodeServer begin registering the routeKey processor in MessageQueueServer！");
        MessageQueueServer.registerRoute("code.createNode", new CreateNodeProcessor());
        MessageQueueServer.registerRoute("code.createLine", new CreateLineProcessor());
        MessageQueueServer.registerRoute("code.createApp", new CreateAppProcessor());
        MessageQueueServer.registerRoute("code.export", new ExportProcessor());
        MessageQueueServer.registerRoute("test.result", new CopyProcessor());
        System.out.println("CodeServer Complete registering the routeKey processor in MessageQueueServer！");

        System.out.println("CodeServer running success！\n");
    }
}
