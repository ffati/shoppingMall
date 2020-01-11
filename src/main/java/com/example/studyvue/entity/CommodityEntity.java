package com.example.studyvue.entity;

import javax.persistence.*;

/**
 * @ClassName CommodityEntity
 * @Description TODO
 * @Author ff
 * @Date 2020/1/11 15:45
 * @ModifyDate 2020/1/11 15:45
 * @Version 1.0
 */

@Entity
@Table(name = "t_commodity")
public class CommodityEntity {

    /**主键*/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**价格*/
    @Column(name = "price",nullable = false)
    private Long price;

    /**描述销量*/
    @Column(name = "describe",nullable = false)
    private String describe;

    /**销量*/
    @Column(name = "salesVolume",nullable = false)
    private String salesvolume;

    /**产品照片*/
    @Column(name = "productImage",nullable = false)
    private String productimage;

    /**详细照片*/
    @Column(name = "productDetailPicture",nullable = false)
    private String productdetailpicture;

    /**
     *无参构造函数
     */
    public CommodityEntity(){
        super();
    }

    /**
     * 带主键构造函数
     * @param id
     */
    public CommodityEntity(Long id){
        super();
        this.id=id;
    }

    /**
     * 获取主键
     * @return
     */
    public Long getId(){
        return this.id;
    }

    /**
     * 设置主键
     * @param id
     */
    public void setId(Long id){
        this.id=id;
    }
    /**
     * 获取价格
     * @return
     */
    public Long getPrice(){
        return this.price;
    }

    /**
     * 设置价格
     * @param price
     */
    public void setPrice(Long price){
        this.price=price;
    }
    /**
     * 获取描述销量
     * @return
     */
    public String getDescribe(){
        return this.describe;
    }

    /**
     * 设置描述销量
     * @param describe
     */
    public void setDescribe(String describe){
        this.describe=(describe == null ? null : describe.trim());
    }
    /**
     * 获取销量
     * @return
     */
    public String getSalesvolume(){
        return this.salesvolume;
    }

    /**
     * 设置销量
     * @param salesvolume
     */
    public void setSalesvolume(String salesvolume){
        this.salesvolume=(salesvolume == null ? null : salesvolume.trim());
    }
    /**
     * 获取产品照片
     * @return
     */
    public String getProductimage(){
        return this.productimage;
    }

    /**
     * 设置产品照片
     * @param productimage
     */
    public void setProductimage(String productimage){
        this.productimage=(productimage == null ? null : productimage.trim());
    }
    /**
     * 获取详细照片
     * @return
     */
    public String getProductdetailpicture(){
        return this.productdetailpicture;
    }

    /**
     * 设置详细照片
     * @param productdetailpicture
     */
    public void setProductdetailpicture(String productdetailpicture){
        this.productdetailpicture=(productdetailpicture == null ? null : productdetailpicture.trim());
    }


}
