package pers.guzx.customersecuritydemo.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pers.guzx.customersecuritydemo.entity.UserRole;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/19 11:35
 * @describe
 */
public interface RoleService {
    UserRole getUserRole(Integer userId);

    GrantedAuthority getRoleById(UserRole userRoles);

    UserRole getUserRoleByUser(UserDetails user);
}
