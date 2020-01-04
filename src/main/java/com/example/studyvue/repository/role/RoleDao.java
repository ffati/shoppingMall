package com.example.studyvue.repository.role;

import com.example.studyvue.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName Role
 * @Description TODO
 * @Author ff
 * @Date 2020/1/1 16:01
 * @ModifyDate 2020/1/1 16:01
 * @Version 1.0
 */

public interface RoleDao extends JpaRepository<RoleEntity,Long> {
}
