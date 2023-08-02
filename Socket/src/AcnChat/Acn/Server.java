package AcnChat.Acn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) {

        try (// 1.创建服务器
             ServerSocket serverSocket = new ServerSocket()
        ) {
            // 2.绑定端口
            serverSocket.bind(new InetSocketAddress(8888));
            // 3.开始监听
            System.out.println("acnServer is starting in 8888");
            while (true) {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
