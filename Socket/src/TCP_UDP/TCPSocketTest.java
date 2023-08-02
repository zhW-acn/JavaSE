package TCP_UDP;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketTest {

    @Test
    public void serverTest() throws IOException {
        // 创建ServerSocket
        ServerSocket server = new ServerSocket();
        // 绑定某个端口
        server.bind(new InetSocketAddress(8888));
        // 监听这个端口
        Socket socket = server.accept();// 阻塞

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024 * 1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        inputStream.close();
        socket.close();
    }

    @Test
    public void clientTest() throws IOException {
        // 创建Socket
        Socket socket = new Socket();// 随机分配端口
        // 使用这个Socket进行连接
        socket.connect(new InetSocketAddress(InetAddress.getLoopbackAddress(), 8888));// 连接8888端口

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());

        outputStream.close();
        inputStream.close();
        socket.close();
    }

    @Test
    public void T() {
        int[] a = {1,1};
        System.out.println(a[4]);
    }
}
