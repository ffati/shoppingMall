package com.example.studyvue.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName ShoppingCart
 * @Description TODO
 * @Author ff
 * @Date 2019/12/22 16:41
 * @ModifyDate 2019/12/22 16:41
 * @Version 1.0
 */

@Entity
@Table(name = "T_SHOPPINGCART")
public class ShoppingCartEntity {


    /**主键*/
    @Id
    @GeneratedValue
    private Long shoppingcartid;
/*    *//**关联用户id*//*
    @Column(name = "FKUserID")
    private Long fkuserid;*/
    /**商品*/
    @Column(name = "commodity")
    private Long commodity;
    /**是否有效（ture为有效）*/
    @Column(name = "stock")
    private String stock;

    @Column(name = "joinTime")
    private Date jointime;


    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "FKUserID")
    private UserEntity shoppingCartUserEntity;


    /**
     *无参构造函数
     */
    public ShoppingCartEntity(){
        super();
    }

    /**
     * 带主键构造函数
     * @param id
     */
    public ShoppingCartEntity(Long id){
        super();
        this.shoppingcartid=id;
    }

    /**
     * 获取主键
     * @return
     */
    public Long getShoppingcartid(){
        return this.shoppingcartid;
    }

    /**
     * 设置主键
     * @param shoppingcartid
     */
    public void setShoppingcartid(Long shoppingcartid){
        this.shoppingcartid=shoppingcartid;
    }

    /**
     * 获取商品
     * @return
     */
    public Long getCommodity(){
        return this.commodity;
    }

    /**
     * 设置商品
     * @param commodity
     */
    public void setCommodity(Long commodity){
        this.commodity=commodity;
    }

    /**
     * 获取是否有效（ture为有效）
     * @return
     */
    public String getStock(){
        return this.stock;
    }

    /**
     * 设置是否有效（ture为有效）
     * @param stock
     */
    public void setStock(String stock){
        this.stock=(stock == null ? null : stock.trim());
    }

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    public UserEntity getShoppingCartUserEntity() {
        return shoppingCartUserEntity;
    }

    public void setShoppingCartUserEntity(UserEntity shoppingCartUserEntity) {
        this.shoppingCartUserEntity = shoppingCartUserEntity;
    }
}
