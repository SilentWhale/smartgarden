### 用户登录接口

##### 接口地址
 + /user/signin
 + req 请求格式是json 格式的
 ```
   {
     "signInKey": // 用户登录的key,电话,邮箱,用户昵称 String
     "signInPasswd" : // 用户登陆的密码 String
     "signInType":    // 告知后端接口,使用的是哪种登录方式,目前的枚举值有: "username","mail", "phonenumber"  String
   }
  ```

  + resp
  ```
   {
      "status": // String,表示后台服务是否正常
      "data":    // status 为success 时,此字段不为空
      {
          "isLegal":  // 标示是否验证成功String
          "signInMessage":  // 如果验证没成功,给出错误提示 String
      }
      "error":
      {
          "errorMessage": // String ,如果status 为 fail,此字段不为空,给出系统异常原因
      }
   }
   ```

