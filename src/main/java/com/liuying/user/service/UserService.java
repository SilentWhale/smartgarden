package com.liuying.user.service;

import com.liuying.vo.JsonRespVo;
import com.liuying.vo.user.UserSigninJsonReqVo;
import com.liuying.vo.user.UserSigninJsonRespVo;
import org.springframework.stereotype.Service;

/**
 * Created by luo on 19/02/2017.
 */
public interface UserService {
    JsonRespVo<UserSigninJsonRespVo> isLegal(UserSigninJsonReqVo reqVo);
}
