package com.liuying.user.controller;

import com.liuying.user.service.UserService;
import com.liuying.vo.JsonRespVo;
import com.liuying.vo.user.UserSigninJsonReqVo;
import com.liuying.vo.user.UserSigninJsonRespVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by luo on 19/02/2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    public static Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @Autowired
    UserService userService;

    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    @ResponseBody
    public JsonRespVo<UserSigninJsonRespVo> checkUserIsLegal(UserSigninJsonReqVo reqVo){
        return userService.isLegal(reqVo);
    }


}
