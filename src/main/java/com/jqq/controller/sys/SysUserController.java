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
public class SysUserController {

    private final static Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/sys/index.do")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("sys/index");
        return modelAndView;
    }

    /**
     * 查找所有
     * @return
     */
    @RequestMapping("/sysUsers")
    public List<SysUser> girlList(){
        logger.info("girlList");
        return sysUserRepository.findAll();
    }

    /**
     * 新增一条
     * @return
     */
    @RequestMapping(value = "/sysUserAdd")
    public Result girlAdd(@Valid SysUser sysUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return Result.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return Result.ok().put("data",sysUserRepository.save(sysUser));
    }

    /**
     * 查找一条
     * @param userId
     * @return
     */
    @RequestMapping(value = "/sysUser/{userId}")
    public SysUser girlFindOne(@PathVariable("userId") Integer userId){
        return sysUserRepository.findOne(userId);
    }

    @RequestMapping(value = "update/{userId}")
    public SysUser sysUserUpdate(@PathVariable("userId") Integer userId,
                           @RequestParam("userName") String userName,
                           @RequestParam("age") Integer age){
        SysUser sysUser = new SysUser();
        sysUser.setUserId(1);
        sysUser.setUserName("haha");
        sysUser.setAge(age);
        return sysUserRepository.save(sysUser);
    }

    /**
     * 删除
     * @param userId
     */
    @RequestMapping(value = "delete/{userId}")
    public void sysUserDelete(@PathVariable("userId") Integer userId){
        sysUserRepository.delete(userId);
    }

    /**
     * 通过年龄查询
     * @param age
     * @return
     */
    @RequestMapping(value = "sysUsers/age/{age}")
    public List<SysUser> sysUserListByAge(@PathVariable("age") Integer age){
        return sysUserRepository.findByAge(age);
    }

    @RequestMapping(value = "insertTwo")
    public void insertTwo(){
        sysUserService.insertTwo();
    }

    @RequestMapping(value = "/sysUser/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        sysUserService.getAge(id);
    }
}
