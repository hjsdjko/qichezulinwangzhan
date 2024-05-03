package com.entity.model;

import com.entity.QicheOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 汽车租赁订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QicheOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String qicheOrderUuidNumber;


    /**
     * 汽车租赁
     */
    private Integer qicheId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 租车日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zucheTime;


    /**
     * 预计还车日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yujihuancheTime;


    /**
     * 实际还车日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shijihuancheTime;


    /**
     * 使用天数
     */
    private Integer shiyongtianshu;


    /**
     * 花费总额
     */
    private Double huafeiMoney;


    /**
     * 订单类型
     */
    private Integer qicheOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getQicheOrderUuidNumber() {
        return qicheOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setQicheOrderUuidNumber(String qicheOrderUuidNumber) {
        this.qicheOrderUuidNumber = qicheOrderUuidNumber;
    }
    /**
	 * 获取：汽车租赁
	 */
    public Integer getQicheId() {
        return qicheId;
    }


    /**
	 * 设置：汽车租赁
	 */
    public void setQicheId(Integer qicheId) {
        this.qicheId = qicheId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：租车日期
	 */
    public Date getZucheTime() {
        return zucheTime;
    }


    /**
	 * 设置：租车日期
	 */
    public void setZucheTime(Date zucheTime) {
        this.zucheTime = zucheTime;
    }
    /**
	 * 获取：预计还车日期
	 */
    public Date getYujihuancheTime() {
        return yujihuancheTime;
    }


    /**
	 * 设置：预计还车日期
	 */
    public void setYujihuancheTime(Date yujihuancheTime) {
        this.yujihuancheTime = yujihuancheTime;
    }
    /**
	 * 获取：实际还车日期
	 */
    public Date getShijihuancheTime() {
        return shijihuancheTime;
    }


    /**
	 * 设置：实际还车日期
	 */
    public void setShijihuancheTime(Date shijihuancheTime) {
        this.shijihuancheTime = shijihuancheTime;
    }
    /**
	 * 获取：使用天数
	 */
    public Integer getShiyongtianshu() {
        return shiyongtianshu;
    }


    /**
	 * 设置：使用天数
	 */
    public void setShiyongtianshu(Integer shiyongtianshu) {
        this.shiyongtianshu = shiyongtianshu;
    }
    /**
	 * 获取：花费总额
	 */
    public Double getHuafeiMoney() {
        return huafeiMoney;
    }


    /**
	 * 设置：花费总额
	 */
    public void setHuafeiMoney(Double huafeiMoney) {
        this.huafeiMoney = huafeiMoney;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getQicheOrderTypes() {
        return qicheOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setQicheOrderTypes(Integer qicheOrderTypes) {
        this.qicheOrderTypes = qicheOrderTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
