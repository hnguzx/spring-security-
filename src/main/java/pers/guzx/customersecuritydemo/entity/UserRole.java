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
@Table(name = "sys_user_role")
public class UserRole {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "role_id")
    private Integer roleId;
}
