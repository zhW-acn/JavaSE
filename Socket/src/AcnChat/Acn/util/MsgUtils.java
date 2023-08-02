package AcnChat.Acn.util;

import AcnChat.Acn.Message;

import java.io.*;
import java.util.Optional;

public class MsgUtils {

    // 从流中读取Msg
    public static Optional<Message> readMsg(InputStream inputStream){
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            // 封装成optional，避免空指针
            return Optional.ofNullable((Message)objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    // 向流中写Msg
    public static void writeMsg(OutputStream outputStream,Message message) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();// 刷新
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
