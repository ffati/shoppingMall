package com.example.studyvue.entity;

import javax.persistence.*;

/**
 * @ClassName Address
 * @Description TODO
 * @Author ff
 * @Date 2019/12/22 16:40
 * @ModifyDate 2019/12/22 16:40
 * @Version 1.0
 */

@Entity
@Table(name = "T_ADDRESS")
public class AddressEntity {


    /**主键*/
    @Id
    @GeneratedValue
    private String specificaddressid;
    /**关联用户id*/
/*    @Column(name = "FKUserID")
    private Long fkuserid;*/
    /**国家*/
    @Column(name = "country")
    private String country;
    /**省*/
    @Column(name = "province")
    private String province;
    /**市*/
    @Column(name = "city")
    private String city;
    /**县*/
    @Column(name = "county")
    private String county;
    /**镇*/
    @Column(name = "town")
    private String town;
    /**区*/
    @Column(name = "area")
    private String area;
    /**详细地址*/
    @Column(name = "specificAddress")
    private String specificaddress;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FKUserID")
    private UserEntity userEntity;


    /**
     *无参构造函数
     */
    public AddressEntity(){
        super();
    }

    /**
     * 带主键构造函数
     * @param id
     */
    public AddressEntity(String id){
        super();
        this.specificaddressid=id;
    }

    /**
     * 获取主键
     * @return
     */
    public String getSpecificaddressid(){
        return this.specificaddressid;
    }

    /**
     * 设置主键
     * @param specificaddressid
     */
    public void setSpecificaddressid(String specificaddressid){
        this.specificaddressid=(specificaddressid == null ? null : specificaddressid.trim());
    }
/*    *//**
     * 获取关联用户id
     * @return
     *//*
    public Long getFkuserid(){
        return this.fkuserid;
    }

    *//**
     * 设置关联用户id
     * @param fkuserid
     *//*
    public void setFkuserid(Long fkuserid){
        this.fkuserid=fkuserid;
    }*/
    /**
     * 获取国家
     * @return
     */
    public String getCountry(){
        return this.country;
    }

    /**
     * 设置国家
     * @param country
     */
    public void setCountry(String country){
        this.country=(country == null ? null : country.trim());
    }
    /**
     * 获取省
     * @return
     */
    public String getProvince(){
        return this.province;
    }

    /**
     * 设置省
     * @param province
     */
    public void setProvince(String province){
        this.province=(province == null ? null : province.trim());
    }
    /**
     * 获取市
     * @return
     */
    public String getCity(){
        return this.city;
    }

    /**
     * 设置市
     * @param city
     */
    public void setCity(String city){
        this.city=(city == null ? null : city.trim());
    }
    /**
     * 获取县
     * @return
     */
    public String getCounty(){
        return this.county;
    }

    /**
     * 设置县
     * @param county
     */
    public void setCounty(String county){
        this.county=(county == null ? null : county.trim());
    }
    /**
     * 获取镇
     * @return
     */
    public String getTown(){
        return this.town;
    }

    /**
     * 设置镇
     * @param town
     */
    public void setTown(String town){
        this.town=(town == null ? null : town.trim());
    }
    /**
     * 获取区
     * @return
     */
    public String getArea(){
        return this.area;
    }

    /**
     * 设置区
     * @param area
     */
    public void setArea(String area){
        this.area=(area == null ? null : area.trim());
    }
    /**
     * 获取详细地址
     * @return
     */
    public String getSpecificaddress(){
        return this.specificaddress;
    }

    /**
     * 设置详细地址
     * @param specificaddress
     */
    public void setSpecificaddress(String specificaddress){
        this.specificaddress=(specificaddress == null ? null : specificaddress.trim());
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
