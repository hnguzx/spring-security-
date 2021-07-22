package pers.guzx.customersecuritydemo.authorize;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import pers.guzx.customersecuritydemo.entity.SysAuthority;

import java.util.Collection;
import java.util.Objects;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/21 18:07
 * @describe 设置为permitAll()的请求不会进入，
 */
@Component
public class UrlMatchVoter implements AccessDecisionVoter<Object> {
    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
        if (authentication == null) {
            return ACCESS_DENIED;
        }


        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        boolean hasPerm = false;

        for (GrantedAuthority authority : authorities) {
            if (!(authority instanceof SysAuthority)) {
                continue;
            }

            SysAuthority urlGrantedAuthority = (SysAuthority) authority;
            if (Objects.isNull(urlGrantedAuthority.getUrl())) {
                continue;
            }
            //AntPathRequestMatcher进行匹配，url支持ant风格（如：/user/**）
            AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher(urlGrantedAuthority.getUrl());

            if (antPathRequestMatcher.matches(((FilterInvocation) object).getRequest())) {
                hasPerm = true;
                break;
            }
        }

        if (!hasPerm) {
            return ACCESS_DENIED;
        }

        return ACCESS_GRANTED;
    }

}
