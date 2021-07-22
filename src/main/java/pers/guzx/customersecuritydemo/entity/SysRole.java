package pers.guzx.customersecuritydemo.entity;

import lombok.Data;

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
@Data
@Table(name = "sys_role")
public class SysRole {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    private List<SysAuthority> sysAuthorities;
}
