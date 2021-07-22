package pers.guzx.customersecuritydemo.mapper;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pers.guzx.customersecuritydemo.entity.SysAuthority;
import pers.guzx.customersecuritydemo.entity.SysRole;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/19 10:23
 * @describe
 */
public interface AuthorityMapper extends Mapper<SysAuthority> {
}
