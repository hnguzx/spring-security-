package pers.guzx.customersecuritydemo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/7/19 10:34
 * @describe
 */
@Data
@Table(name = "sys_role_authority")
public class RoleAuthority {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private Integer roleId;
    private Integer authorityId;
}
