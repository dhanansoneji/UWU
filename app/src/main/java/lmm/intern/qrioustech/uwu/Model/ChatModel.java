package lmm.intern.qrioustech.uwu.Model;

public class ChatModel {
    String name,msg;
    int status;

    public ChatModel(String name, String msg, int status) {
        this.name = name;
        this.msg = msg;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
