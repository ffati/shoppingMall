package com.example.studyvue.service.user.userImpl;

import com.example.studyvue.entity.RoleEntity;
import com.example.studyvue.entity.UserEntity;
import com.example.studyvue.repository.role.RoleDao;
import com.example.studyvue.repository.user.UserDao;
import com.example.studyvue.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author ff
 * @Date 2019/12/22 17:34
 * @ModifyDate 2019/12/22 17:34
 * @Version 1.0
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;


    /**
     * @author: ff
     * @date:
     * @param: [userEntity]
     * @return: com.example.studyvue.entity.UserEntity
     * 根据参数查询
     */
    @Override
    public UserEntity findByAnyParameter(UserEntity userEntity) {
        Example<UserEntity> entityExample=Example.of(userEntity);
        if (userDao.findOne(entityExample).isPresent()){
            return userDao.findOne(entityExample).get();
        }
        return null;
    }

    @Override
    //@Transactional(isolation = Isolation.SERIALIZABLE)
    public void register(UserEntity userEntity) {
        userDao.save(userEntity);
    }

    @Override
    public Integer findMaxID() {
        return userDao.findMaxId();
    }

    /*
     * @author: ff
     * @date: 2019/12/22 22:21
     * @param: [number]
     * @return: java.lang.Boolean
     * 检测手机号是否重复，true为重复
     */
    @Override
    public Boolean findDuplicatePhoneNumber(String number) {

        UserEntity userEntity=new UserEntity();
        userEntity.setPhonenumber(number);
       // Example<UserEntity> entityExample=Example.of(userEntity);
        if (null!=this.findByAnyParameter(userEntity)){
            return true;
        }
        return false;
    }

    @Override
    public List<RoleEntity> findAllRole() {
        return roleDao.findAll();
    }
}
