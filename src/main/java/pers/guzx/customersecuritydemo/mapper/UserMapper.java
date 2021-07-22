package pers.guzx.customersecuritydemo.mapper;


import org.springframework.stereotype.Repository;
import pers.guzx.customersecuritydemo.entity.SysUser;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/19 10:23
 * @describe
 */
public interface UserMapper extends Mapper<SysUser> {
}
