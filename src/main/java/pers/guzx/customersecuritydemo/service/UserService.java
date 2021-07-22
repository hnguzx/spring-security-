package pers.guzx.customersecuritydemo.service;

import pers.guzx.customersecuritydemo.entity.SysUser;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/19 10:22
 * @describe
 */
public interface UserService {
    SysUser getUserByUsername(String username);
}
