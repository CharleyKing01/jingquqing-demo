package com.jqq.service;
import com.jqq.demain.SysUser;
import com.jqq.enums.ResultEnum;
import com.jqq.exception.JqqException;
import com.jqq.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * Created by lql on 2017/02/12.
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserRepository sysUserRepository;

    @Transactional
    public void insertTwo(){
        SysUser sysUserA  = new SysUser();
        sysUserA.setUserName("zhangsan");
        sysUserA.setAge(18);
        sysUserRepository.save(sysUserA);

        SysUser sysUserB  = new SysUser();
        sysUserB.setUserName("lisi");
        sysUserB.setAge(20);
        sysUserRepository.save(sysUserB);
    }

    public void getAge(Integer id) throws Exception{
        SysUser sysUser = sysUserRepository.findOne(id);
        Integer age = sysUser.getAge();
        if(age < 10){
            throw new JqqException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age >10 && age < 16){
            throw new JqqException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过Id查询一个女生的信息
     * @param id
     * @return
     */
    public SysUser findOne(Integer id){
        return sysUserRepository.findOne(id);
    }
}
