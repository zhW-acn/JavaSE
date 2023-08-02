package AcnChat.Acn.constant;

import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Constant {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";
    public static final String DEFAULT_PASSWORD = "acn";
    public static final String SERVER_NAME = "server";
    public static final String OK = "OK";
    // 保存用户
    public static final Map<String, Socket> Online_USERS = new ConcurrentHashMap<>(8);
}
