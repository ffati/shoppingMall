package com.example.studyvue.entity;

import javax.persistence.*;

/**
 * @ClassName Role
 * @Description TODO
 * @Author ff
 * @Date 2020/1/1 15:57
 * @ModifyDate 2020/1/1 15:57
 * @Version 1.0
 */

@Entity
@Table(name = "t_role")
public class RoleEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "roleName")
    private String roleName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
