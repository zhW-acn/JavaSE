package TCP_UDP;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class UDPSocketTest {

    @Test
    public void clientTest() throws IOException {
        // 创建Socket，可以自己绑定端口
        DatagramSocket socket = new DatagramSocket();
        // 构建数据包
        String data = "hello";
        DatagramPacket packet = new DatagramPacket(
                data.getBytes(),0,data.getBytes().length,
                new InetSocketAddress(InetAddress.getByName("localhost"),8080)
        );

        socket.send(packet);
        socket.close();
    }

    @Test
    public void serverTest() throws IOException {
        // 创建Socket，可以自己绑定端口
        DatagramSocket socket = new DatagramSocket(8080);

        byte[] buffer = new byte[1024];
        // 空的数据包，用于接受数据，放入buffer里
        DatagramPacket packet = new DatagramPacket(
                buffer,0,buffer.length
        );

        socket.receive(packet);
        System.out.println(new String(buffer,0, packet.getLength()));
        socket.close();
    }
}
