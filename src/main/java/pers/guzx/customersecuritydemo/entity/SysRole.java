package pers.guzx.customersecuritydemo.entity;

import lombok.Data;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/19 10:07
 * @describe 系统角色，与权限表配合使用，一个角色可以有多个权限
 */
@Setter
public class SysRole implements GrantedAuthority {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private String name;
    private List<SysAuthority> sysAuthorities;

    public Integer getId() {
        return this.id;
    }

    public List<SysAuthority> getSysAuthorities() {
        return this.sysAuthorities;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
