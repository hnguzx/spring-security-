package pers.guzx.customersecuritydemo.service;

        import pers.guzx.customersecuritydemo.entity.*;

        import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/19 11:35
 * @describe
 */
public interface AuthorityService {
    UserAuthority getUserAuthority(Integer userId);

    List<SysAuthority> getAuthorityById(List<UserAuthority> userAuthorities);

    List<UserAuthority> getUserAuthorityByUser(SysUser user);
}
