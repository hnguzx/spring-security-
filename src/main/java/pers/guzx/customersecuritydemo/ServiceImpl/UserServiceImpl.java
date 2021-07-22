package pers.guzx.customersecuritydemo.ServiceImpl;

import org.springframework.stereotype.Service;
import pers.guzx.customersecuritydemo.entity.SysUser;
import pers.guzx.customersecuritydemo.mapper.UserMapper;
import pers.guzx.customersecuritydemo.service.UserService;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/19 10:22
 * @describe
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public SysUser getUserByUsername(String username) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        List<SysUser> sysUsers = userMapper.selectByExample(example);
        if (sysUsers.size() > 0) {
            return sysUsers.get(0);
        }
        return null;
    }

    public SysUser saveUser(SysUser user){
        userMapper.insert(user);
        return user;
    }
}
