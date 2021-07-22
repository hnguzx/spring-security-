package pers.guzx.customersecuritydemo.authorize;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import pers.guzx.customersecuritydemo.code.ErrorCode;
import pers.guzx.customersecuritydemo.entity.SysAuthority;

import java.util.Collection;
import java.util.Objects;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/21 17:48
 * @describe 严格匹配url
 */
@Component
public class UrlMatchAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (authentication == null) {
            throw new AccessDeniedException(ErrorCode.USER_NOT_AUTH.getMsg());
        }

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        boolean hasPerm = false;

        // request请求路径和httpMethod 和权限列表比对。
        for (GrantedAuthority authority : authorities) {
            if (!(authority instanceof SysAuthority)) {
                continue;
            }

            SysAuthority urlGrantedAuthority = (SysAuthority) authority;
            if (Objects.isNull(urlGrantedAuthority.getAuthority())) {
                continue;
            }

            AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher(urlGrantedAuthority.getAuthority());
            if (antPathRequestMatcher.matches(((FilterInvocation) object).getRequest())) {
                hasPerm = true;
                break;
            }
        }

        if (!hasPerm) {
            throw new AccessDeniedException(ErrorCode.USER_NOT_AUTH.getMsg());
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
