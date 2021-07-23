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
    private Integer id;
    private Integer userId;
    private Integer roleId;
}
