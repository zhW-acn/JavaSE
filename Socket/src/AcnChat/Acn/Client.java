package AcnChat.Acn;

import AcnChat.Acn.constant.Constant;
import AcnChat.Acn.constant.MessageType;
import AcnChat.Acn.util.ScannerUtil;
import AcnChat.Acn.util.MsgUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Optional;

/**
 * 功能：1.给服务器发消息 2.给好友发  3.群发
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // 1.连接服务器
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(8888));
        // 2.发消息
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        String username = null;
        // 登录
        while (true) {
            if (username == null) {
                username = login(outputStream, inputStream);
            } else {
                // 登录后打印菜单
                printOrder();
                String input = ScannerUtil.input();
                switch (Integer.parseInt(input)) {
                    case MessageType.TO_SERVER:
                        sendToServer(username, outputStream, inputStream);
                        break;
                    case MessageType.TO_FRIEND:
                        sendToFRIEND(username, outputStream);
                        break;
                    case MessageType.TO_ALL:
                        sendToALL(username,outputStream);
                        break;
                    case MessageType.RECEIVER:
                        receiveMsg(inputStream);
                        break;
                    default:
                        break;
                }
            }

        }


    }

    private static void receiveMsg(InputStream inputStream) {
        while (true) {
            Optional<Message> message = MsgUtils.readMsg(inputStream);
            message.ifPresent(m -> System.out.println(m.getUsername() + ":" + m.getContent()));
        }

    }

    private static void sendToALL(String username, OutputStream outputStream) {
        boolean flag = true;
        while (flag) {
            System.out.println(username + ":");
            String msg = ScannerUtil.input();
            if ("bye".equals(msg)) flag = false;

            MsgUtils.writeMsg(outputStream,
                    new Message(MessageType.TO_ALL, msg, username));
        }
    }

    private static void sendToFRIEND(String username, OutputStream outputStream) {
        System.out.print("Friend name?");
        String friend = ScannerUtil.input();
        boolean flag = true;
        while (flag) {
            System.out.println(username + ":");
            String msg = ScannerUtil.input();
            if ("bye".equals(msg)) flag = false;

            MsgUtils.writeMsg(outputStream,
                    new Message(MessageType.TO_FRIEND, msg, username, friend));
//            Optional<Message> message = MsgUtils.readMsg(inputStream);
//            message.ifPresent(m -> System.out.println(m.getUsername() + ":" + m.getContent()));
        }

    }

    private static void sendToServer(String username, OutputStream outputStream, InputStream inputStream) {
        System.out.print(username + ":");
        String msg = ScannerUtil.input();
        MsgUtils.writeMsg(outputStream,
                new Message(MessageType.TO_SERVER, msg, username));
        Optional<Message> message = MsgUtils.readMsg(inputStream);
        message.ifPresent(m -> System.out.println(m.getUsername() + ":" + m.getContent()));
    }

    private static void printOrder() {
        System.out.println("选择功能：" +
                MessageType.TO_SERVER + ".给服务器发消息   " +
                MessageType.TO_FRIEND + ".给好友发消息    " +
                MessageType.TO_ALL + ".群发" +
                MessageType.RECEIVER + ".接收信息");
    }

    private static String login(OutputStream outputStream, InputStream inputStream) {
        System.out.println("请输入用户名");
        String name = ScannerUtil.input();
        System.out.println("请输入密码");
        String pwd = ScannerUtil.input();
        Message message = new Message();
        message.setType(MessageType.LOGIN);
        message.setUsername(name);
        message.setPassword(pwd);
        // 发送给服务器
        MsgUtils.writeMsg(outputStream, message);
        // 接受来自服务器的消息
        Optional<Message> msg = MsgUtils.readMsg(inputStream);
        if (msg.isPresent() && Constant.SUCCESS.equals(msg.get().getContent())) {
            return name;
        }
        return null;
    }
}
