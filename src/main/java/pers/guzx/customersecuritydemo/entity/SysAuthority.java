package pers.guzx.customersecuritydemo.entity;

import lombok.Data;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/19 10:08
 * @describe 系统权限
 * 如果没有在HttpSecurity中配置，则默认所有认证通过的都可以访问
 * 配置了访问规则后，主要通过name即用户角色来控制访问
 * 如果name有值，则直接通过角色关联到具体权限
 * 如果name为空则说明不是特定角色的权限，不仅可以通过角色访问，还可以直接通过用户权限表关联到用户达到访问的目的
 */
@Setter
@Table(name = "sys_authority")
public class SysAuthority implements GrantedAuthority {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "url")
    private String url;

    public Integer getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getUrl() {
        return this.url;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
