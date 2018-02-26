package com.jqq.repository;
import com.jqq.demain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Created by lql on 2017/12/22.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Integer> {
    //通过年龄查询
    public List<SysUser> findByAge(Integer age);
}
