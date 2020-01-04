package com.example.studyvue.repository.user;

import com.example.studyvue.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author ff
 * @Date 2019/12/22 17:37
 * @ModifyDate 2019/12/22 17:37
 * @Version 1.0
 */

public interface UserDao extends JpaRepository<UserEntity,Long> {

    //@Modifying
    @Query(value = "select max(userID) from t_user",nativeQuery = true)
   Integer findMaxId();

}
