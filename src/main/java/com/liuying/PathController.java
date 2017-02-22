package com.liuying;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by luo on 19/02/2017.
 */
@Controller
@RequestMapping("/user")
public class PathController {
    @RequestMapping("/signin")
    public ModelAndView userSignIn(ModelAndView mv) {
        mv.setViewName("user/signIn");
        return mv;
    }
}
