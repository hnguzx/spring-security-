package pers.guzx.customersecuritydemo.service;

import pers.guzx.customersecuritydemo.entity.SysRole;
import pers.guzx.customersecuritydemo.entity.SysUser;
import pers.guzx.customersecuritydemo.entity.UserRole;

import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/19 11:35
 * @describe
 */
public interface RoleService {
    UserRole getUserRole(Integer userId);

    SysRole getRoleById(UserRole userRoles);

    UserRole getUserRoleByUser(SysUser user);
}
