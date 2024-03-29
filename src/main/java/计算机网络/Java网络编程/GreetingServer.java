package 计算机网络.Java网络编程;

import java.net.*;
import java.io.*;

/**
 * @author LIFAN
 * 2019/3/26 11:55
 */

public class GreetingServer extends Thread {
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run()
    {
        while(true)
        {
            try
            {
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");

                Socket server = serverSocket.accept();

                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());

                //接收客户端数据
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());

                //传送数据给客户端
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");

                server.close();

            }catch(SocketTimeoutException s)
            {
                System.out.println("Socket timed out!");
                break;
            }catch(IOException e)
            {
                e.printStackTrace();
                break;
            }
        }
    }
    public static void main(String [] args)
    {
        //int port = Integer.parseInt(args[0]);
        int port = 6066;
        try
        {
            Thread t = new GreetingServer(port);
            t.run();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}