package com.liuying.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.liuying.constant.JsonRespStatusConstant;
import com.liuying.user.constant.SignInKeyTypeEnum;
import com.liuying.user.dao.UserMapper;
import com.liuying.user.domain.User;
import com.liuying.user.service.UserService;
import com.liuying.vo.ErrorJsonResp;
import com.liuying.vo.JsonRespVo;
import com.liuying.vo.user.UserSigninJsonReqVo;
import com.liuying.vo.user.UserSigninJsonRespVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by luo on 27/02/2017.
 */
@Component
public class UserServiceImpl implements UserService {


    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonRespVo<UserSigninJsonRespVo> isLegal(UserSigninJsonReqVo reqVo) {
        LOGGER.info("reqVO:{}", JSON.toJSONString(reqVo));
        JsonRespVo<UserSigninJsonRespVo> jsonRespVoJsonRespVo = null ;
        try {
            List<User> selectedUser = findUser(reqVo);
            if(selectedUser.size() >= 2){
                jsonRespVoJsonRespVo = buildFailJsonResp("该用户异常,请切换id登录");
                LOGGER.error("more then two user with the same id in db:{}",JSON.toJSON(selectedUser));
            } else if (selectedUser.size() == 0) {
                jsonRespVoJsonRespVo = buildFailJsonResp("yo");
                LOGGER.info("no user with the id in db:{}",JSON.toJSON(selectedUser));
            } else {
                // TODO: 04/03/2017  进行密码校验 ,目前只进行用户名校验
                jsonRespVoJsonRespVo = buildSuccessJsonResp();
                LOGGER.info("signin resp:{}",JSON.toJSON(jsonRespVoJsonRespVo));
            }
            return jsonRespVoJsonRespVo;
        }catch (Exception e) {
            LOGGER.error("excepiton while user login:{}",JSON.toJSON(e));
            return buildExceptionJsonResp("后台服务异常");
        }
    }



    private JsonRespVo<UserSigninJsonRespVo> buildSuccessJsonResp() {
        JsonRespVo<UserSigninJsonRespVo> jsonResp = new JsonRespVo<UserSigninJsonRespVo>();
        jsonResp.setStatus(JsonRespStatusConstant.SUCCESS);
        UserSigninJsonRespVo userSigninJsonRespVo = new UserSigninJsonRespVo();
        userSigninJsonRespVo.setIsLegal(UserSigninJsonRespVo.LEGAL);
        userSigninJsonRespVo.setSignInMessage("welcome");
        jsonResp.setData(userSigninJsonRespVo);
        return jsonResp;
    }

    private JsonRespVo<UserSigninJsonRespVo> buildFailJsonResp(String errorMessage) {
        JsonRespVo<UserSigninJsonRespVo> jsonResp = new JsonRespVo<UserSigninJsonRespVo>();
        jsonResp.setStatus(JsonRespVo.SUCCESS);
        UserSigninJsonRespVo userSigninJsonRespVo = new UserSigninJsonRespVo();
        userSigninJsonRespVo.setIsLegal(UserSigninJsonRespVo.ILLEGAL);
        userSigninJsonRespVo.setSignInMessage(errorMessage);
        jsonResp.setData(userSigninJsonRespVo);
        return jsonResp;

    }
    private JsonRespVo<UserSigninJsonRespVo> buildExceptionJsonResp(String errorMessage) {
        JsonRespVo<UserSigninJsonRespVo> jsonResp = new JsonRespVo<UserSigninJsonRespVo>();
        jsonResp.setStatus(JsonRespVo.FAIL);
        jsonResp.setError(new ErrorJsonResp(errorMessage));
        return jsonResp;

    }

    private List<User> findUser(UserSigninJsonReqVo reqVo) {
        if(reqVo == null) {
            return null;
        }
        SignInKeyTypeEnum signInKeyTypeEnum = SignInKeyTypeEnum.findType(reqVo.getSignInType());
        List<User> userList;
        if(signInKeyTypeEnum == null) {
            return null;
        }
        switch (signInKeyTypeEnum.getType()) {
            case "mail":
                userList = userMapper.selectUserByMail(reqVo.getSignInKey());
                break;
            case "username":
                userList = userMapper.selectUserByName(reqVo.getSignInKey());
                break;
            case "phonenumber":
                userList = userMapper.selectUserByPhoneNum(reqVo.getSignInKey());
                break;
            default:
                return null;
        }
        return userList;
    }
}
