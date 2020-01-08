package com.example.studyvue.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName User
 * @Description TODO
 * @Author ff
 * @Date 2019/12/22 16:40
 * @ModifyDate 2019/12/22 16:40
 * @Version 1.0
 */

@Entity
@Table(name = "T_USER")
public class UserEntity {

    /**用户id*/
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userid;
    /**用户名*/
    @Column(name = "userName",nullable = false)
    private String username;
    /**手机号码*/
    @Column(name = "phoneNumber",nullable = false,unique = true)
    private String phonenumber;
    /**用户类别*/
    @Column(name = "userCategory")
    private String usercategory;
    /**性别*/
    @Column(name = "sex")
    private String sex;
    /**用户级别*/
    @Column(name = "userLevel")
    private String userlevel;
    /**头像地址*/
    @Column(name = "pictureAddress")
    private String pictureaddress;
    /**最后登录ip*/
    @Column(name = "lastLoginIp")
    private String lastloginip;
    /**用户密码*/
    @Column(name = "userPassword")
    private String userpassword;
    /**真实姓名*/
    @Column(name = "trueName",nullable = false)
    private String truename;
    /**身份号码*/
    @Column(name = "identityID",nullable = false)
    private String identityid;
    /**注册时间*/
    @Column(name = "registrationTime")
    private Date registrationTime;
    /**最后登陆时间*/
    @Column(name = "lastLoginTime")
    private Date lastlogintime;
    /**账号状态*/
    @Column(name = "accountStatus",columnDefinition = "0")
    private char accountStatus;


    @OneToMany(mappedBy = "userEntity",targetEntity = AddressEntity.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<AddressEntity> addressEntityList=new ArrayList<AddressEntity>();

    @OneToMany(mappedBy = "shoppingCartUserEntity",targetEntity = ShoppingCartEntity.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<ShoppingCartEntity> shoppingCartEntityList=new ArrayList<ShoppingCartEntity>();
    /**
     * 获取用户id
     * @return
     */
    public Long getUserid(){
        return this.userid;
    }

    /**
     * 设置用户id
     * @param userid
     */
    public void setUserid(Long userid){
        this.userid=userid;
    }
    /**
     * 获取用户名
     * @return
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * 设置用户名
     * @param username
     */
    public void setUsername(String username){
        this.username=(username == null ? null : username.trim());
    }
    /**
     * 获取手机号码
     * @return
     */
    public String getPhonenumber(){
        return this.phonenumber;
    }

    /**
     * 设置手机号码
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber){
        this.phonenumber=(phonenumber == null ? null : phonenumber.trim());
    }
    /**
     * 获取用户类别
     * @return
     */
    public String getUsercategory(){
        return this.usercategory;
    }

    /**
     * 设置用户类别
     * @param usercategory
     */
    public void setUsercategory(String usercategory){
        this.usercategory=(usercategory == null ? null : usercategory.trim());
    }
    /**
     * 获取性别
     * @return
     */
    public String getSex(){
        return this.sex;
    }

    /**
     * 设置性别
     * @param sex
     */
    public void setSex(String sex){
        this.sex=(sex == null ? null : sex.trim());
    }

    /**
     * 获取用户级别
     * @return
     */
    public String getUserlevel(){
        return this.userlevel;
    }

    /**
     * 设置用户级别
     * @param userlevel
     */
    public void setUserlevel(String userlevel){
        this.userlevel=(userlevel == null ? null : userlevel.trim());
    }
    /**
     * 获取头像地址
     * @return
     */
    public String getPictureaddress(){
        return this.pictureaddress;
    }

    /**
     * 设置头像地址
     * @param pictureaddress
     */
    public void setPictureaddress(String pictureaddress){
        this.pictureaddress=(pictureaddress == null ? null : pictureaddress.trim());
    }
    /**
     * 获取最后登录时间
     * @return
     */

    /**
     * 获取用户密码
     * @return
     */
    public String getUserpassword(){
        return this.userpassword;
    }

    /**
     * 设置用户密码
     * @param userpassword
     */
    public void setUserpassword(String userpassword){
        this.userpassword=(userpassword == null ? null : userpassword.trim());
    }
    /**
     * 获取真实姓名
     * @return
     */
    public String getTruename(){
        return this.truename;
    }

    /**
     * 设置真实姓名
     * @param truename
     */
    public void setTruename(String truename){
        this.truename=(truename == null ? null : truename.trim());
    }
    /**
     * 获取身份号码
     * @return
     */
    public String getIdentityid(){
        return this.identityid;
    }

    /**
     * 设置身份号码
     * @param identityid
     */
    public void setIdentityid(String identityid){
        this.identityid=(identityid == null ? null : identityid.trim());
    }


    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = (lastloginip == null ? null : lastloginip.trim());
    }

    public char getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(char accountStatus) {
        this.accountStatus = accountStatus;
    }

    public List<AddressEntity> getAddressEntityList() {
        return addressEntityList;
    }

    public void setAddressEntityList(List<AddressEntity> addressEntityList) {
        this.addressEntityList = addressEntityList;
    }

    public List<ShoppingCartEntity> getShoppingCartEntityList() {
        return shoppingCartEntityList;
    }

    public void setShoppingCartEntityList(List<ShoppingCartEntity> shoppingCartEntityList) {
        this.shoppingCartEntityList = shoppingCartEntityList;
    }
}
