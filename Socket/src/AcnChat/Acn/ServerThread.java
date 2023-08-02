package AcnChat.Acn;

import AcnChat.Acn.constant.Constant;
import AcnChat.Acn.constant.MessageType;
import AcnChat.Acn.util.MsgUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Optional;

public class ServerThread extends Thread {

    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public ServerThread() {
    }

    @Override
    public void run() {
       try(
           InputStream inputStream = socket.getInputStream();
           OutputStream outputStream = socket.getOutputStream();
       ){
           while (true) {
               Optional<Message> message = MsgUtils.readMsg(inputStream);

               if (message.isPresent()) {
                   Message msg = message.get();
                   switch (msg.getType()) {
                       case MessageType.LOGIN:
                           loginHandler(inputStream, outputStream, msg, socket);
                           break;
                       case MessageType.TO_SERVER:
                           sendToClient(inputStream, outputStream, msg);
                           break;
                       case MessageType.TO_FRIEND:
                           sendToTarget(msg);
                           break;
                       case MessageType.TO_ALL:
                           sendToAll(msg);
                           break;
                   }
               }

           }
       }catch (IOException e){

       }


    }

    private void sendToClient(InputStream inputStream, OutputStream outputStream, Message message) {
        // 接收消息并打印
        System.out.println(message.getUsername() + ":" + message.getContent());
        MsgUtils.writeMsg(outputStream, new Message(MessageType.FROM_SERVER, Constant.OK, Constant.SERVER_NAME));
    }

    private void sendToTarget(Message message) {// 给目标发送
        // 找到对应的socket
        Socket socket = Constant.Online_USERS.get(message.getFriendUserName());
        try {
            MsgUtils.writeMsg(socket.getOutputStream(),message);// 转发
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendToAll(Message message) {
        // 遍历所有在线用户，拿到socket
        for(Map.Entry<String,Socket> entry:Constant.Online_USERS.entrySet()){
            try {
                MsgUtils.writeMsg(entry.getValue().getOutputStream(), message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void loginHandler(InputStream inputStream, OutputStream outputStream, Message message, Socket socket) {
        if(Constant.Online_USERS.containsKey(message.getUsername())){
            MsgUtils.writeMsg(outputStream, new Message(MessageType.FROM_SERVER, "已经登陆", Constant.SERVER_NAME));
            return;
        }
        if (message.getUsername() == null || !Constant.DEFAULT_PASSWORD.equals(message.getPassword())) {
            MsgUtils.writeMsg(outputStream, new Message(MessageType.FROM_SERVER, Constant.FAIL));
        } else {
            Constant.Online_USERS.put(message.getUsername(), socket);
            System.out.println(message.getUsername() + Constant.SUCCESS);
            MsgUtils.writeMsg(outputStream, new Message(MessageType.FROM_SERVER, Constant.SUCCESS, Constant.SERVER_NAME));
        }
    }
}
