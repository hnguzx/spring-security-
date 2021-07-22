package pers.guzx.customersecuritydemo.ServiceImpl;

import org.springframework.stereotype.Service;
import pers.guzx.customersecuritydemo.entity.SysRole;
import pers.guzx.customersecuritydemo.entity.SysUser;
import pers.guzx.customersecuritydemo.entity.UserRole;
import pers.guzx.customersecuritydemo.mapper.RoleMapper;
import pers.guzx.customersecuritydemo.mapper.UserRoleMapper;
import pers.guzx.customersecuritydemo.service.RoleService;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/19 11:36
 * @describe
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public UserRole getUserRole(Integer userId) {
        return null;
    }

    @Override
    public SysRole getRoleById(UserRole userRole) {
        SysRole role = roleMapper.selectByPrimaryKey(userRole.getRoleId());
        return role;
    }

    @Override
    public UserRole getUserRoleByUser(SysUser user) {
        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", user.getId());
        List<UserRole> userRoles = userRoleMapper.selectByExample(example);
        if (userRoles.size() > 0) {
            return userRoles.get(0);
        }
        return null;
    }

    public SysRole save(SysRole role) {
        int insert = roleMapper.insert(role);
        return role;
    }

    public UserRole save(UserRole userRole) {
        int insert = userRoleMapper.insert(userRole);
        return userRole;
    }
}
