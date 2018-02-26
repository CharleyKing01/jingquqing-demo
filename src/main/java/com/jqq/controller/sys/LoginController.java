package com.jqq.controller.sys;
import com.jqq.demain.Result;
import com.jqq.demain.SysUser;
import com.jqq.repository.SysUserRepository;
import com.jqq.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by lql on 2018/02/22.
 */
@RestController
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/sys/login.do")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("sys/login");
        return modelAndView;
    }


}
