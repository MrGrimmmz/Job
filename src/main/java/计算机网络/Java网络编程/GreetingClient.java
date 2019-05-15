package 计算机网络.Java网络编程;

import java.net.*;
import java.io.*;

/**
 * @author LIFAN
 * 2019/3/26 11:55
 */
public class GreetingClient
{
    public static void main(String [] args)
    {
        String serverName = "localhost";
        int port = 9999;
        try
        {
            System.out.println("连接到主机：" + serverName + " ，端口号：" + port);

            Socket client = new Socket(serverName, port);

            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());

            //传送数据给服务端
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("Hello from " + client.getLocalSocketAddress());

            //接收服务端响应
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());

            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
