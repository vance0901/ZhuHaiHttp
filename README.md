# HTTP Network Request Library

A Retrofit-based HTTP network request encapsulation library that provides simple and easy-to-use API interfaces with complete network request functionality.
基于Retrofit的HTTP网络请求封装库，提供简单易用的API接口和完整的网络请求功能。

## Features
## 功能特点

- Built on Retrofit2 and OkHttp
- 基于Retrofit2和OkHttp构建
- Support for common HTTP request methods (GET, POST, PUT, DELETE, etc.)
- 支持常见的HTTP请求方法（GET、POST、PUT、DELETE等）
- Unified request and response handling
- 统一的请求和响应处理
- Flexible request configuration
- 灵活的请求配置
- Custom request headers
- 自定义请求头
- Log interception and printing
- 日志拦截和打印
- Thread-safe singleton implementation
- 线程安全的单例实现

## Integration
## 集成方式

### Gradle

```gradle
dependencies {
    implementation 'io.github.vance0901:http:1.0.0'
}
```

### 加入网络权限 Add network permissions
```xml
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

## Usage
## 使用方法

### 1. Initialization
### 1. 初始化

Initialize in the Application class:
在Application类中初始化：

```java
HttpConfig config = new HttpConfig.Builder()
        .baseUrl("https://api.example.com/")
        .connectTimeout(10000)
        .readTimeout(10000)
        .writeTimeout(10000)
        .debug(BuildConfig.DEBUG)
        .logLevel(BuildConfig.DEBUG ? 
            HttpLoggingInterceptor.Level.BODY : 
            HttpLoggingInterceptor.Level.NONE)
        .build();
        
HttpManager.init(config);
```

### 2. Define API Interfaces
### 2. 定义API接口

```java
public interface ApiService {
    // GET request example
    // GET请求示例
    @GET("users/{id}")
    Call<BaseResponse<UserInfo>> getUserInfo(@Path("id") long id);
    
    // GET request with query parameters
    // 带查询参数的GET请求
    @GET("users")
    Call<BaseResponse<List<UserInfo>>> getUserList(@Query("page") int page, @Query("size") int size);
    
    // POST request example - form submission
    // POST请求示例 - 表单提交
    @FormUrlEncoded
    @POST("users/login")
    Call<BaseResponse<LoginResponse>> login(
        @Field("username") String username,
        @Field("password") String password
    );
    
    // POST request example - JSON submission
    // POST请求示例 - JSON提交
    @POST("users/create")
    Call<BaseResponse<UserInfo>> createUser(@Body UserInfo userInfo);
    
    // PUT request example
    // PUT请求示例
    @PUT("users/{id}")
    Call<BaseResponse<UserInfo>> updateUser(
        @Path("id") long id, 
        @Body UserInfo userInfo
    );
    
    // DELETE request example
    // DELETE请求示例
    @DELETE("users/{id}")
    Call<BaseResponse<Void>> deleteUser(@Path("id") long id);
    
    // DELETE request with body
    // 带请求体的DELETE请求
    @HTTP(method = "DELETE", path = "users", hasBody = true)
    Call<BaseResponse<Void>> batchDeleteUsers(@Body List<Long> userIds);
}
```

### 3. Create API Service Class
### 3. 创建API服务类

```java
public class UserService extends BaseApiService<ApiService> {
    private static volatile UserService instance;
    
    private UserService() {
        super();
    }
    
    public static UserService getInstance() {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    instance = new UserService();
                }
            }
        }
        return instance;
    }
    
    @Override
    protected Class<ApiService> getApiServiceClass() {
        return ApiService.class;
    }
    
    // GET request example
    // GET请求示例
    public void getUserInfo(long userId, RequestCallback<UserInfo> callback) {
        executeRequest(apiService.getUserInfo(userId), callback);
    }
    
    // GET request with parameters example
    // 带参数的GET请求示例
    public void getUserList(int page, int size, RequestCallback<List<UserInfo>> callback) {
        executeRequest(apiService.getUserList(page, size), callback);
    }
    
    // POST request example
    // POST请求示例
    public void login(String username, String password, RequestCallback<LoginResponse> callback) {
        executeRequest(apiService.login(username, password), callback);
    }
    
    // POST request with JSON example
    // 带JSON的POST请求示例
    public void createUser(UserInfo userInfo, RequestCallback<UserInfo> callback) {
        executeRequest(apiService.createUser(userInfo), callback);
    }
    
    // PUT request example
    // PUT请求示例
    public void updateUser(long userId, UserInfo userInfo, RequestCallback<UserInfo> callback) {
        executeRequest(apiService.updateUser(userId, userInfo), callback);
    }
    
    // DELETE request example
    // DELETE请求示例
    public void deleteUser(long userId, RequestCallback<Void> callback) {
        executeRequest(apiService.deleteUser(userId), callback);
    }
    
    // DELETE request with body example
    // 带请求体的DELETE请求示例
    public void batchDeleteUsers(List<Long> userIds, RequestCallback<Void> callback) {
        executeRequest(apiService.batchDeleteUsers(userIds), callback);
    }
}
```

### 4. Make Network Requests
### 4. 发起网络请求

#### 4.1 POST Request Example
#### 4.1 POST请求示例

```java
UserService.getInstance().login("username", "password", new RequestCallback<LoginResponse>() {
    @Override
    public void onStart() {
        // Show loading state
        // 显示加载状态
    }
    
    @Override
    public void onSuccess(LoginResponse data) {
        // Handle successful response
        // 处理成功响应
    }
    
    @Override
    public void onError(int code, String message) {
        // Handle error response
        // 处理错误响应
    }
    
    @Override
    public void onComplete() {
        // Request completed
        // 请求完成
    }
});
```

#### 4.2 GET Request Example
#### 4.2 GET请求示例

```java
UserService.getInstance().getUserInfo(123, new RequestCallback<UserInfo>() {
    @Override
    public void onStart() {
        // Show loading state
        // 显示加载状态
    }
    
    @Override
    public void onSuccess(UserInfo data) {
        // Handle user information
        // 处理用户信息
        String username = data.getUsername();
        String email = data.getEmail();
    }
    
    @Override
    public void onError(int code, String message) {
        // Handle errors, e.g., user not found
        // 处理错误，例如用户未找到
    }
    
    @Override
    public void onComplete() {
        // Request completed
        // 请求完成
    }
});
```

#### 4.3 PUT Request Example
#### 4.3 PUT请求示例

```java
// Create user information to update
// 创建要更新的用户信息
UserInfo userInfo = new UserInfo();
userInfo.setUsername("newUsername");
userInfo.setEmail("new.email@example.com");

UserService.getInstance().updateUser(123, userInfo, new RequestCallback<UserInfo>() {
    @Override
    public void onStart() {
        // Show updating state
        // 显示更新状态
    }
    
    @Override
    public void onSuccess(UserInfo data) {
        // Handle updated user information
        // 处理更新后的用户信息
    }
    
    @Override
    public void onError(int code, String message) {
        // Handle update failure
        // 处理更新失败
    }
    
    @Override
    public void onComplete() {
        // Update request completed
        // 更新请求完成
    }
});
```

#### 4.4 DELETE Request Example
#### 4.4 DELETE请求示例

```java
UserService.getInstance().deleteUser(123, new RequestCallback<Void>() {
    @Override
    public void onStart() {
        // Show deleting state
        // 显示删除状态
    }
    
    @Override
    public void onSuccess(Void data) {
        // Handle successful deletion
        // 处理成功删除
    }
    
    @Override
    public void onError(int code, String message) {
        // Handle deletion failure
        // 处理删除失败
    }
    
    @Override
    public void onComplete() {
        // Deletion request completed
        // 删除请求完成
    }
});
```

### 5. Managing Request Headers
### 5. 管理请求头

#### 5.1 Setting Global Authentication Token
#### 5.1 设置全局认证令牌

```java
// Set a global authentication token that will be used for all requests
// 设置一个全局认证令牌，用于所有请求
HttpManager.getInstance().setGlobalToken("your-auth-token-here");
```

#### 5.2 Adding Custom Headers
#### 5.2 添加自定义请求头

```java
// Add a single custom header
// 添加单个自定义请求头
HttpManager.getInstance().addGlobalHeader("Custom-Header", "Header-Value");

// Add multiple headers at once
// 一次添加多个请求头
Map<String, String> headers = new HashMap<>();
headers.put("X-API-Key", "api-key-value");
headers.put("Accept-Language", "en-US");
HttpManager.getInstance().addGlobalHeaders(headers);
```

#### 5.3 Removing Headers
#### 5.3 移除请求头

```java
// Remove a specific header
// 移除特定请求头
HttpManager.getInstance().removeGlobalHeader("Custom-Header");

// Clear all global headers
// 清除所有全局请求头
HttpManager.getInstance().clearGlobalHeaders();
```

#### 5.4 Example: Managing Authentication Token After Login
#### 5.4 示例：登录后管理认证令牌

```java
UserService.getInstance().login("username", "password", new RequestCallback<LoginResponse>() {
    @Override
    public void onStart() {
        // Show loading state
        // 显示加载状态
    }
    
    @Override
    public void onSuccess(LoginResponse data) {
        // After successful login, set the authentication token
        // 登录成功后，设置认证令牌
        if (data != null && data.getToken() != null) {
            HttpManager.getInstance().setGlobalToken(data.getToken());
        }
        // Handle other login response data
        // 处理其他登录响应数据
    }
    
    @Override
    public void onError(int code, String message) {
        // Handle login failure
        // 处理登录失败
    }
    
    @Override
    public void onComplete() {
        // Login request completed
        // 登录请求完成
    }
});
```

## Design Patterns
## 设计模式

This library uses multiple design patterns:
此库使用多种设计模式：

- **Singleton Pattern**: `HttpManager`
- **单例模式**：`HttpManager`
- **Builder Pattern**: `HttpConfig.Builder`
- **构建者模式**：`HttpConfig.Builder`
- **Factory Pattern**: `HttpManager.createApi()`
- **工厂模式**：`HttpManager.createApi()`
- **Observer Pattern**: `RequestCallback`
- **观察者模式**：`RequestCallback`
- **Template Method Pattern**: `BaseApiService`
- **模板方法模式**：`BaseApiService`
- **Strategy Pattern**: Different request strategies through different API interfaces
- **策略模式**：通过不同的API接口实现不同的请求策略
- **Proxy Pattern**: `HeaderInterceptor`
- **代理模式**：`HeaderInterceptor`

## Project Structure
## 项目结构

```
com.zhuhai.network.http
├── HttpManager.java               // HTTP Manager
│                                  // HTTP管理器
├── api                            // API interface definitions
│                                  // API接口定义
├── callback                       // Callback interfaces
│                                  // 回调接口
│   └── RequestCallback.java       // Request callback interface
│                                  // 请求回调接口
├── config                         // Configuration classes
│                                  // 配置类
│   └── HttpConfig.java            // HTTP configuration class
│                                  // HTTP配置类
├── interceptor                    // Interceptors
│                                  // 拦截器
│   └── HeaderInterceptor.java     // Request header interceptor
│                                  // 请求头拦截器
├── model                          // Data models
│                                  // 数据模型
│   └── BaseResponse.java          // Base response class
│                                  // 基础响应类
└── service                        // Service classes
                                   // 服务类
    └── BaseApiService.java        // Base API service class
                                   // 基础API服务类
``` 

```txt
JAVA开发者或其他开发人员使用请参考:
https://central.sonatype.com/artifact/io.github.vance0901/http/overview
For JAVA developers or other developers to use, please refer to:
https://central.sonatype.com/artifact/io.github.vance0901/http/overview
更多详细用法请查看demo。 For more detailed usage, please refer to the demo.
``` 