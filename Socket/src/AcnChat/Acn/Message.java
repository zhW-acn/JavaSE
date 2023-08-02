package AcnChat.Acn;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer type;
    private String content;
    private String username;
    private String password;
    private String friend;

    public Message(){}
    public Message(Integer type, String content, String username, String password, String friend) {
        this.type = type;
        this.content = content;
        this.username = username;
        this.password = password;
        this.friend = friend;
    }

    public Message(int type, String content, String username, String friend) {
        this.type = type;
        this.content = content;
        this.username = username;
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type=" + type +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", friend='" + friend + '\'' +
                '}';
    }

    public Message(Integer type, String content){
        this.type = type;
        this.content = content;
    }
    public Message(Integer type, String content,String username){
        this.type = type;
        this.content = content;
        this.username = username;
    }
    public Message(String username, String password,Integer type) {
        this.type = type;
        this.username = username;
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFriendUserName() {
        return friend;
    }

    public void setFriendUserName(String friendUserName) {
        this.friend = friend;
    }
}
