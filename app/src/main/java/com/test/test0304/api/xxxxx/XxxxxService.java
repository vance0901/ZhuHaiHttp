package com.test.test0304.api.xxxxx;



import com.test.test0304.model.xx.UserUpdateRequest;
import com.test.test0304.model.xx.UserUpdateResponse;
import com.test.test0304.model.xx.XxLoginRequest;
import com.test.test0304.model.xx.XxLoginResponse;
import com.zhuhai.network.http.callback.RequestCallback;
import com.zhuhai.network.http.service.BaseApiService;

/**
 * xxxx业xxxAPI服务类
 */
public class XxxxxService extends BaseApiService<XxxxxApiService> {
    private static volatile XxxxxService instance;
    
    private XxxxxService() {
        super();
    }
    
    /**
     * 获取服务单例实例
     * 
     * @return xxxxxService实例
     */
    public static XxxxxService getInstance() {
        if (instance == null) {
            synchronized (XxxxxService.class) {
                if (instance == null) {
                    instance = new XxxxxService();
                }
            }
        }
        return instance;
    }
    
    @Override
    protected Class<XxxxxApiService> getApiServiceClass() {
        return XxxxxApiService.class;
    }
    
    /**
     * 用户登录 - JSON提交方式
     * 
     * @param phone 手机号
     * @param verifyCode 验证码
     * @param callback 请求回调
     */
    public void login(String phone, String verifyCode, RequestCallback<XxLoginResponse> callback) {
        XxLoginRequest request = new XxLoginRequest(phone, verifyCode);
        executeRequest(apiService.login(request), callback);
    }
    
    /**
     * 更新用户信息 - PUT请求(JSON方式)
     * 
     * @param updateRequest 用户信息更新请求
     * @param callback 请求回调
     */
    public void updateUserInfo(UserUpdateRequest updateRequest, RequestCallback<UserUpdateResponse> callback) {
        executeRequest(apiService.updateUserInfo(updateRequest), callback);
    }
    
    /**
     * 执行删除数据请求 - 单个ID删除
     *
     * @param id 要删除的ID
     * @param callback 回调
     */
//    public void deleteData(String id, RequestCallback<DeleteResponse> callback) {
//        DeleteRequest request = new DeleteRequest();
//        request.addId(id);
//        executeRequest(apiService.deleteData(request), callback);
//    }
    
    /**
     * 执行批量删除数据请求
     *
     * @param ids 要删除的ID列表
     * @param callback 回调
     */
//    public void deleteData(List<String> ids, RequestCallback<DeleteResponse> callback) {
//        DeleteRequest request = new DeleteRequest(ids);
//        executeRequest(apiService.deleteData(request), callback);
//    }
} 