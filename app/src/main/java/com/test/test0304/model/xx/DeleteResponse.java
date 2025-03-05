package com.test.test0304.model.xx;

/**
 * 删除响应模型类
 * 用于接收删除操作的响应数据
 */
public class DeleteResponse {
    /**
     * {"code":0,"msg":"操作成功","data":"操作成功"}
     */
//    private boolean success;
    private String msg;
    private int code;
    private String data;

//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DeleteResponse{" +
//                "success=" + success +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                ", data='" + data + '\'' +
                '}';
    }
}