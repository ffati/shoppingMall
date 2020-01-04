package com.example.studyvue.entity;

import javax.persistence.*;

/**
 * @ClassName UserAddress
 * @Description TODO
 * @Author ff
 * @Date 2019/12/22 16:41
 * @ModifyDate 2019/12/22 16:41
 * @Version 1.0
 */

@Entity
@Table(name = "T_USERADDRESS")
public class UserAddressEntity {

    /**地址id*/
    @Id
    @GeneratedValue
    private Long addressid;
    /**关联用户主键*/
    @Column(name = "FKUserID")
    private Long fkuserid;
    /**地址id*/
    @Column(name = "addressNumber")
    private String addressnumber;

    /**
     *无参构造函数
     */
    public UserAddressEntity(){
        super();
    }

    /**
     * 带主键构造函数
     * @param id
     */
    public UserAddressEntity(Long id){
        super();
        this.addressid=id;
    }

    /**
     * 获取地址id
     * @return
     */
    public Long getAddressid(){
        return this.addressid;
    }

    /**
     * 设置地址id
     * @param addressid
     */
    public void setAddressid(Long addressid){
        this.addressid=addressid;
    }
    /**
     * 获取关联用户主键
     * @return
     */
    public Long getFkuserid(){
        return this.fkuserid;
    }

    /**
     * 设置关联用户主键
     * @param fkuserid
     */
    public void setFkuserid(Long fkuserid){
        this.fkuserid=fkuserid;
    }
    /**
     * 获取地址id
     * @return
     */
    public String getAddressnumber(){
        return this.addressnumber;
    }

    /**
     * 设置地址id
     * @param addressnumber
     */
    public void setAddressnumber(String addressnumber){
        this.addressnumber=(addressnumber == null ? null : addressnumber.trim());
    }

}
