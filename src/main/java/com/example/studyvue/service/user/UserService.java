package com.example.studyvue.service.user;

import com.example.studyvue.entity.RoleEntity;
import com.example.studyvue.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author ff
 * @Date 2019/12/22 17:34
 * @ModifyDate 2019/12/22 17:34
 * @Version 1.0
 */

@Service
public interface UserService {

   void register(UserEntity userEntity);

   Integer findMaxID();

   Boolean findDuplicatePhoneNumber(String number);

   UserEntity findByAnyParameter(UserEntity userEntity);

   List<RoleEntity> findAllRole();

   void updateUser(UserEntity userEntity);
}
