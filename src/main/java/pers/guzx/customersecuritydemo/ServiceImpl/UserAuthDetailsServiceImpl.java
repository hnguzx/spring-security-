package pers.guzx.customersecuritydemo.ServiceImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pers.guzx.customersecuritydemo.entity.*;
import pers.guzx.customersecuritydemo.mapper.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/19 10:22
 * @describe
 */
@Service
public class UserAuthDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserServiceImpl userService;

    @Resource
    private RoleServiceImpl roleService;

    @Resource
    private AuthorityServiceImpl authorityService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.getUserByUsername(username);
        UserRole userRoleByUser = roleService.getUserRoleByUser(user);
        SysRole role = roleService.getRoleById(userRoleByUser);
        user.setRoles(role);

        List<UserAuthority> userAuthorityByUser = authorityService.getUserAuthorityByUser(user);
        List<SysAuthority> authority = authorityService.getAuthorityById(userAuthorityByUser);
        List<SysAuthority> authorityByRole = authorityService.getAuthorityByRole(role);
        authority.addAll(authorityByRole);
        user.setAuthorities(authority);
        return user;
    }
}
