package com.test.test0304;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.test.test0304.api.HttpRequestExample;
import com.test.test0304.api.xxxx.XxxxRequestExample;
import com.test.test0304.api.wanandroid.WanAndroidRequestExample;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private HttpRequestExample httpRequestExample;
    private WanAndroidRequestExample wanAndroidRequestExample;
    private XxxxRequestExample xxxxRequestExample;
    
    // 按钮控件
    private Button btnGetRequest;
    private Button btnPostFormRequest;
    private Button btnPostJsonRequest;
    private Button btnPutRequest;
//    private Button btnDeleteRequest;
    private Button btnBatchDeleteRequest;
    private Button btnWanAndroidLogin;
    private Button btnxxxxLogin;
    private Button btnUpdateUser;
//    private Button btnDeleteData;
    private Button btnAddHeader;
    private Button btnClearHeaders;
    
    // 登录输入框
    private EditText etUsername;
    private EditText etPassword;
    private LinearLayout loginLayout;
    
    // x业xxxxx登录输入框
    private EditText etxxxxPhone;
    private EditText etxxxxVerifyCode;
    private LinearLayout xxxxLoginLayout;
    
    // 用户信息更新输入框
    private EditText etUserId;
    private EditText etUserName;
    private EditText etUpdatePhone;
    private EditText etVerifyCode;
    private EditText etBirth;
    private Spinner spinnerSex;
    private EditText etAddress;
    private EditText etRegion;
    private LinearLayout userUpdateLayout;
    
    private EditText etDeleteId;
    private LinearLayout deleteDataLayout;
    
    private EditText etHeaderKey;
    private EditText etHeaderValue;
    private LinearLayout headerSettingsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        httpRequestExample = new HttpRequestExample(this);
        wanAndroidRequestExample = new WanAndroidRequestExample(this);
        xxxxRequestExample = new XxxxRequestExample(this);
        
        initViews();
    }
    
    /**
     * 初始化视图控件
     */
    private void initViews() {
        // 获取按钮引用
        btnGetRequest = findViewById(R.id.btn_get_request);
        btnPostFormRequest = findViewById(R.id.btn_post_form_request);
        btnPostJsonRequest = findViewById(R.id.btn_post_json_request);
        btnPutRequest = findViewById(R.id.btn_put_request);
//        btnDeleteRequest = findViewById(R.id.btn_delete_request);
        btnBatchDeleteRequest = findViewById(R.id.btn_batch_delete_request);
        btnWanAndroidLogin = findViewById(R.id.btn_wanandroid_login);
        btnxxxxLogin = findViewById(R.id.btn_xxxx_login);
        btnUpdateUser = findViewById(R.id.btn_update_user);
//        btnDeleteData = findViewById(R.id.btn_delete_data);
        btnAddHeader = findViewById(R.id.btn_add_header);
        btnClearHeaders = findViewById(R.id.btn_clear_headers);
        
        // 登录输入框
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        loginLayout = findViewById(R.id.login_layout);
        
        // x业xxxxx登录输入框
        etxxxxPhone = findViewById(R.id.et_xxxx_phone);
        etxxxxVerifyCode = findViewById(R.id.et_xxxx_verify_code);
        xxxxLoginLayout = findViewById(R.id.xxxx_login_layout);
        
        // 用户信息更新输入框
        etUserId = findViewById(R.id.et_user_id);
        etUserName = findViewById(R.id.et_user_name);
        etUpdatePhone = findViewById(R.id.et_update_phone);
        etVerifyCode = findViewById(R.id.et_verify_code);
        etBirth = findViewById(R.id.et_birth);
        spinnerSex = findViewById(R.id.spinner_sex);
        etAddress = findViewById(R.id.et_address);
        etRegion = findViewById(R.id.et_region);
        userUpdateLayout = findViewById(R.id.user_update_layout);
        

        // 请求头设置输入框
        headerSettingsLayout = findViewById(R.id.header_settings_layout);
        etHeaderKey = findViewById(R.id.et_header_key);
        etHeaderValue = findViewById(R.id.et_header_value);
        
        // 设置点击监听器
        btnGetRequest.setOnClickListener(this);
        btnPostFormRequest.setOnClickListener(this);
        btnPostJsonRequest.setOnClickListener(this);
        btnPutRequest.setOnClickListener(this);
        btnBatchDeleteRequest.setOnClickListener(this);
        btnWanAndroidLogin.setOnClickListener(this);
        btnxxxxLogin.setOnClickListener(this);
        btnUpdateUser.setOnClickListener(this);
        btnAddHeader.setOnClickListener(this);
        btnClearHeaders.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        
        if (id == R.id.btn_get_request) {
            // GET请求示例
            httpRequestExample.getRequestExample();
        } else if (id == R.id.btn_post_form_request) {
            // POST表单请求示例
            httpRequestExample.postFormRequestExample();
        } else if (id == R.id.btn_post_json_request) {
            // POST JSON请求示例
            httpRequestExample.postJsonRequestExample();
        } else if (id == R.id.btn_put_request) {
            // PUT请求示例
            httpRequestExample.putRequestExample();
        } else if (id == R.id.btn_batch_delete_request) {
            // DELETE请求示例(批量)
            httpRequestExample.batchDeleteRequestExample();
        } else if (id == R.id.btn_wanandroid_login) {
            attemptLogin();
        } else if (id == R.id.btn_xxxx_login) {
            attemptxxxxLogin();
        } else if (id == R.id.btn_update_user) {
            attemptUpdateUserInfo();
        } else if (id == R.id.btn_add_header) {
            addCustomHeader();
        } else if (id == R.id.btn_clear_headers) {
            clearCustomHeaders();
        }
    }
    
    /**
     * 尝试登录WanAndroid
     */
    private void attemptLogin() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        
        // 简单验证
        if (username.isEmpty()) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            etUsername.requestFocus();
            return;
        }
        
        if (password.isEmpty()) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            etPassword.requestFocus();
            return;
        }
        
        // 执行登录请求
        wanAndroidRequestExample.loginExample(username, password);
    }
    
    /**
     * 尝试登录x业xxxxx
     */
    private void attemptxxxxLogin() {
        String phone = etxxxxPhone.getText().toString().trim();
        String verifyCode = etxxxxVerifyCode.getText().toString().trim();
        
        // 简单验证
        if (phone.isEmpty()) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            etxxxxPhone.requestFocus();
            return;
        }
        
        if (verifyCode.isEmpty()) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            etxxxxVerifyCode.requestFocus();
            return;
        }
        
        // 执行登录请求
        xxxxRequestExample.loginJsonExample(phone, verifyCode);
    }
    
    /**
     * 尝试更新用户信息
     */
    private void attemptUpdateUserInfo() {
        // 获取输入值
        String userIdStr = etUserId.getText().toString().trim();
        String userName = etUserName.getText().toString().trim();
        String phone = etUpdatePhone.getText().toString().trim();
        String verifyCode = etVerifyCode.getText().toString().trim();
        String birth = etBirth.getText().toString().trim();
        String address = etAddress.getText().toString().trim();
        String region = etRegion.getText().toString().trim();
        
        // 获取性别值(0-未知, 1-男, 2-女)
        int sex = spinnerSex.getSelectedItemPosition();
        
        // 解析用户ID
        int userId = 0;
        try {
            userId = Integer.parseInt(userIdStr);
        } catch (NumberFormatException e) {
            // 保持默认值0
        }
        
        // 执行更新请求
        xxxxRequestExample.updateUserInfoExample(
            userId, userName, phone, sex, birth, address, region, verifyCode
        );
    }
    
    private void attemptDeleteData() {
        String deleteId = etDeleteId.getText().toString().trim();
        
        // 执行删除请求，如果ID为空则执行批量删除示例
        xxxxRequestExample.quickDeleteExample(deleteId);
    }
    
    /**
     * 添加自定义请求头
     */
    private void addCustomHeader() {
        String headerKey = etHeaderKey.getText().toString().trim();
        String headerValue = etHeaderValue.getText().toString().trim();
        
        if (headerKey.isEmpty()) {
            Toast.makeText(this, "请输入请求头名称", Toast.LENGTH_SHORT).show();
            return;
        }
        
        if (headerValue.isEmpty()) {
            Toast.makeText(this, "请输入请求头值", Toast.LENGTH_SHORT).show();
            return;
        }
        
        // 设置自定义请求头
        xxxxRequestExample.setCustomHeaderExample(headerKey, headerValue);
    }
    
    /**
     * 清除指定的请求头
     */
    private void clearCustomHeaders() {
        String headerKey = etHeaderKey.getText().toString().trim();

        // 如果输入框为空，则默认清除token请求头
        if (headerKey.isEmpty()) {
            headerKey = "token";
            etHeaderKey.setText(headerKey); // 设置输入框为token，便于用户看到
        }

        // 清除指定请求头
        xxxxRequestExample.clearHeadersExample(headerKey);
        
        // 显示成功提示
//        Toast.makeText(this, "已清除请求头: " + headerKey, Toast.LENGTH_SHORT).show();
    }
}