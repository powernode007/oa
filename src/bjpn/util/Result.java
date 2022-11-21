package bjpn.util;

public class Result {
    private String msg = "请求成功";//消息提示
    private Integer code = 200; //200正常 -1失败
    private Object result;//向前端响应的数据

    public Result(String msg, Integer code, Object result) {
        this.msg = msg;
        this.code = code;
        this.result = result;
    }

    public Result(Object result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
